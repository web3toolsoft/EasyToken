package org.web3soft.commons.auth.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.web3soft.commons.auth.exception.AbnormalAccessException;
import org.web3soft.commons.auth.exception.SessionExpiredException;
import org.web3soft.commons.auth.exception.TokenInvalidException;
import org.web3soft.commons.auth.exception.UserForbiddenException;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.TokenProvider;

/**
 * @author web3soft-team
 */
@Slf4j
public class HmacTokenInterceptor extends AbstractTokenInterceptor {

    public HmacTokenInterceptor(final TokenProvider tokenProvider, final SessionService<TokenUserInfo> sessionService) {
        super(tokenProvider, sessionService);
    }

    @Override
    protected TokenUserInfo getTokenUserInfo(final String accessToken, final HttpServletRequest request) {
        TokenUserInfo tokenUserInfo = null;
        final String hmacToken = this.tokenProvider.getHmacToken(accessToken);

        try {
            tokenUserInfo = this.tokenProvider.getTokenUserInfo(accessToken);
            this.validateAndRefresh(tokenUserInfo, hmacToken, request);
        } catch (final UserForbiddenException | SessionExpiredException ex) {
            throw ex;
        } catch (final Exception ex) {
            this.clearSession(hmacToken, tokenUserInfo);
            if (ex instanceof AbnormalAccessException) {
                throw new AbnormalAccessException(ex.getMessage(), ex);
            }
            throw new TokenInvalidException(ex.getMessage(), ex);
        }
        return tokenUserInfo;
    }
}
