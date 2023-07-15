package org.web3soft.commons.auth.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.web3soft.commons.auth.config.BizFrozenConfig;
import org.web3soft.commons.auth.exception.BizFrozenException;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.dictionary.consts.UserAuthConsts;

/**
 * @author web3soft-team
 */
@Slf4j
public class BizFrozenInterceptor implements AsyncHandlerInterceptor {
    private final BizFrozenConfig frozenConfig;
    private final SessionService<TokenUserInfo> sessionService;

    public BizFrozenInterceptor(final BizFrozenConfig frozenConfig, final SessionService<TokenUserInfo> sessionService) {
        this.frozenConfig = frozenConfig;
        this.sessionService = sessionService;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response, final Object handler) throws Exception {
        log.debug("request url:{}", request.getRequestURL());
        this.validateFrozen(request);
        return true;
    }

    private void validateFrozen(final HttpServletRequest request) {
        final TokenUserInfo tokenUserInfo = (TokenUserInfo) request.getAttribute(UserAuthConsts.TOKEN_CURRENT_USER);
        if (tokenUserInfo == null || tokenUserInfo.isFrozenAll()) {
            throw new BizFrozenException();
        }
    }
}
