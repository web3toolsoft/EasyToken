package org.web3soft.commons.auth.token.hmac;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Component;
import org.web3soft.commons.auth.config.TokenConfig;
import org.web3soft.commons.auth.consts.TokenConsts;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.AbstractTokenProvider;
import org.web3soft.commons.auth.token.TokenProvider;

import java.util.Date;

/**
 * @author web3soft-team
 */
@Slf4j
@Component
public class HmacTokenProvider
        extends AbstractTokenProvider implements TokenProvider {

    public HmacTokenProvider(final TokenConfig tokenConfig,
                             final TokenCryptoProvider cryptoProvider,
                             final SessionService<TokenUserInfo> sessionService) {
        super(tokenConfig, cryptoProvider, sessionService);
    }

    @Override
    public TokenUserInfo getTokenUserInfo(final String accessToken) {
        final String hmacToken = this.getHmacToken(accessToken);
        final TokenUserInfo tokenUserInfo = this.sessionService.getByToken(hmacToken);
        if (tokenUserInfo == null) {
            log.warn("token is expired");
            return TokenUserInfo.builder().status(TokenConsts.STATUS_NOT_EXISTS).build();
        }
        return tokenUserInfo;
    }

    @Override
    public String generateToken(final TokenUserInfo tokenUserInfo) {
        final String text = tokenUserInfo.getSid() + ":" + tokenUserInfo.getUserId() + ":" + tokenUserInfo.getUsername();
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, this.tokenConfig.getSecret()).hmacHex(text);
    }

    @Override
    public String getHmacToken(final String rawToken) {
        return rawToken;
    }

    @Override
    public String refreshToken(final String accessToken) {
        return null;
    }

    @Override
    public boolean canTokenBeRefreshed(final String accessToken, final Date lastPasswordReset) {
        return false;
    }

    @Override
    public boolean validateToken(final String accessToken, final TokenUserInfo tokenUserInfo) {
        return false;
    }

    @Override
    public Date getExpirationDate(final Date createdDate) {
        return null;
    }
}
