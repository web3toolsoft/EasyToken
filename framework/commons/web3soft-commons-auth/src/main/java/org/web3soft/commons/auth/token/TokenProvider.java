package org.web3soft.commons.auth.token;

import org.web3soft.commons.auth.config.TokenConfig;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.model.TokenUserInfo;

import java.util.Date;

public interface TokenProvider {

    TokenConfig getTokenConfig();

    TokenCryptoProvider getCryptoProvider();

    long getUserId(String accessToken);

    TokenUserInfo getTokenUserInfo(String accessToken);

    String generateToken(TokenUserInfo tokenUserInfo);

    String getHmacToken(String rawToken);

    String refreshToken(String accessToken);

    boolean canTokenBeRefreshed(String accessToken, Date lastPasswordReset);

    boolean validateToken(String accessToken, TokenUserInfo tokenUserInfo);

    boolean isExpiredToken(Date expired);

    Date getExpirationDate(Date createdDate);

    boolean verifyIpAndDevice(TokenUserInfo tokenUserInfo, String deviceId, long ip);
}
