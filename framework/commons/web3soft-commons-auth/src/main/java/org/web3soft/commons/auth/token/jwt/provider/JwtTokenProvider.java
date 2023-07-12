package org.web3soft.commons.auth.token.jwt.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.web3soft.commons.auth.config.TokenConfig;
import org.web3soft.commons.auth.consts.TokenConsts;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.AbstractTokenProvider;
import org.web3soft.commons.auth.token.TimeProvider;
import org.web3soft.commons.auth.token.TokenProvider;
import org.web3soft.commons.auth.token.jwt.config.JwtConfig;
import org.web3soft.commons.auth.token.jwt.model.JwtPublicClaims;

import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author web3soft-team
 */
@Slf4j
@Component
public class JwtTokenProvider
        extends AbstractTokenProvider implements TokenProvider {

    public JwtTokenProvider(final TokenConfig tokenConfig,
                            final TokenCryptoProvider cryptoProvider,
                            final SessionService<TokenUserInfo> sessionService) {
        super(tokenConfig, cryptoProvider, sessionService);
    }

    @Override
    public TokenUserInfo getTokenUserInfo(final String accessToken) {
        final JwtPublicClaims publicClaims = this.parseClaims(accessToken);
        if (this.isExpiredToken(publicClaims.getExpiration())) {
            log.debug("token is expired");
            final TokenUserInfo tokenUserInfo = new TokenUserInfo();
            tokenUserInfo.setStatus(-1);
            return tokenUserInfo;
        }

        TokenUserInfo tokenUserInfo = this.getTokenUserInfo(this.parseClaims(accessToken));
        //二步验证token
        if (TokenConsts.STATUS_TWO_FACTOR.equals(tokenUserInfo.getStatus())) {
            return tokenUserInfo;
        }

        if (TokenConsts.STATUS_NOT_EXISTS.equals(tokenUserInfo.getStatus())) {
            log.warn("token not exits");
            return TokenUserInfo.builder().status(TokenConsts.STATUS_NOT_EXISTS).build();
        }

        final String hmacToken = this.getHmacToken(accessToken);
        tokenUserInfo = this.sessionService.getByToken(hmacToken);
        if (tokenUserInfo == null) {
            log.warn("token is expired");
            return TokenUserInfo.builder().status(TokenConsts.STATUS_NOT_EXISTS).build();
        }
        return tokenUserInfo;
    }

    @Override
    public String generateToken(final TokenUserInfo tokenUserInfo) {
        final String userId = this.encrypt(String.valueOf(tokenUserInfo.getUserId()));
        final String ip = this.encrypt(String.valueOf(tokenUserInfo.getIp()));
        final String devId = this.encrypt(tokenUserInfo.getDevId());

        final Date createdDate = tokenUserInfo.getCreated();
        final Date expirationDate = ObjectUtils.defaultIfNull(tokenUserInfo.getExpired(), this.getExpirationDate(createdDate));
        log.debug("doGenerateToken createdDate: {}", createdDate);

        final JwtPublicClaims publicClaims = new JwtPublicClaims(new DefaultClaims());
        publicClaims
                .setId(StringUtils.defaultIfBlank(tokenUserInfo.getSid(), UUID.randomUUID().toString()))
                .setUserId(userId)
                .setIp(ip)
                .setDevId(devId)
                .setStatus(tokenUserInfo.getStatus())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .setIssuer(((JwtConfig) this.tokenConfig).getIssuer());

        return Jwts.builder()
                .setClaims(publicClaims.getClaims())
                .signWith(SignatureAlgorithm.HS256,this.tokenConfig.getSecret())
                .compact();
    }

    @Override
    public String getHmacToken(final String rawToken) {
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, this.tokenConfig.getSecret()).hmacHex(rawToken);
    }

    @Override
    public String refreshToken(final String accessToken) {
        final Date createdDate = TimeProvider.now();
        final Date expirationDate = this.getExpirationDate(createdDate);

        final Claims claims = this.parseClaims(accessToken).getClaims();
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, this.tokenConfig.getSecret())
                .compact();
    }

    @Override
    public boolean validateToken(final String accessToken, final TokenUserInfo user) {
        final JwtPublicClaims jwtPublicClaims = this.parseClaims(accessToken);
        final String username = jwtPublicClaims.getUsername();
        final Date expired = jwtPublicClaims.getExpiration();
        return (username.equals(user.getUsername())
                && !this.isExpiredToken(expired));
    }

    @Override
    public boolean canTokenBeRefreshed(final String accessToken, final Date lastPasswordReset) {
        final JwtPublicClaims jwtPublicClaims = this.parseClaims(accessToken);
        final Date created = jwtPublicClaims.getIssuedAt();
        final Date expired = jwtPublicClaims.getExpiration();
        return (this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset) || this.isExpiredToken(expired));
    }

    @Override
    public Date getExpirationDate(final Date createdDate) {
        return new Date(createdDate.getTime() + ((JwtConfig) this.tokenConfig).getExpiration() * 1000);
    }

    public TokenUserInfo getTokenUserInfo(final JwtPublicClaims publicClaims) {
        final long userId = NumberUtils.toLong(this.decrypt(publicClaims.getUserId()), -1);
        final long ip = NumberUtils.toLong(this.decrypt(publicClaims.getIp()), -1);
        final String devId = this.decrypt(publicClaims.getDevId());

        final TokenUserInfo tokenUserInfo = new TokenUserInfo();
        tokenUserInfo.setSid(publicClaims.getId());
        tokenUserInfo.setUserId(userId);
        tokenUserInfo.setIp(ip);
        tokenUserInfo.setDevId(devId);
        tokenUserInfo.setStatus(publicClaims.getStatus());
        tokenUserInfo.setCreated(publicClaims.getIssuedAt());
        return tokenUserInfo;
    }

    public <T> T getClaims(final JwtPublicClaims claims, final Function<JwtPublicClaims, T> claimsResolver) {
        return claimsResolver.apply(claims);
    }

    public JwtPublicClaims parseClaims(final String token) {
        final Claims claims = Jwts.parser()
                .setSigningKey(this.tokenConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();
        return new JwtPublicClaims(claims);
    }

    private boolean isCreatedBeforeLastPasswordReset(final Date created, final Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
}
