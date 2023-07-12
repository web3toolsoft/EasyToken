package org.web3soft.commons.auth.token;

import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.auth.config.TokenConfig;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;

import java.util.Date;

public abstract class AbstractTokenProvider implements TokenProvider {
    protected TokenConfig tokenConfig;
    protected TokenCryptoProvider cryptoProvider;
    protected SessionService<TokenUserInfo> sessionService;

    protected AbstractTokenProvider(final TokenConfig tokenConfig,
                                    final TokenCryptoProvider cryptoProvider,
                                    final SessionService<TokenUserInfo> sessionService) {
        this.tokenConfig = tokenConfig;
        this.cryptoProvider = cryptoProvider;
        this.sessionService = sessionService;
    }

    @Override
    public TokenConfig getTokenConfig() {
        return this.tokenConfig;
    }

    @Override
    public TokenCryptoProvider getCryptoProvider() {
        return this.cryptoProvider;
    }

    @Override
    public long getUserId(final String accessToken) {
        final TokenUserInfo tokenUserInfo = this.getTokenUserInfo(accessToken);
        return tokenUserInfo.getUserId();
    }

    @Override
    public boolean verifyIpAndDevice(final TokenUserInfo tokenUserInfo, final String deviceId, final long ip) {
        if (this.tokenConfig.isValidateIpAndDevice()) {
            return (tokenUserInfo.isNotFromSameDevice(deviceId) ||
                    tokenUserInfo.isNotFromSameIp(ip));
        }
        return false;
    }

    @Override
    public boolean isExpiredToken(final Date expired) {
        return expired.before(TimeProvider.now());
    }

    protected String encrypt(final String content) {
        return this.cryptoProvider.encrypt(StringUtils.defaultIfEmpty(content, ""), this.tokenConfig.getCryptoKey());
    }

    protected String decrypt(final String content) {
        return this.cryptoProvider.decrypt(StringUtils.defaultIfEmpty(content, ""), this.tokenConfig.getCryptoKey());
    }
}
