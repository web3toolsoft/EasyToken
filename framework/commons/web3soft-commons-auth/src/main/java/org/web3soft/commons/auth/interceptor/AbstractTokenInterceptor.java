package org.web3soft.commons.auth.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.util.WebUtils;
import org.web3soft.commons.auth.consts.TokenConsts;
import org.web3soft.commons.auth.exception.AbnormalAccessException;
import org.web3soft.commons.auth.exception.SessionExpiredException;
import org.web3soft.commons.auth.exception.TokenNotFoundException;
import org.web3soft.commons.auth.exception.UserForbiddenException;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.TokenProvider;
import org.web3soft.commons.auth.util.ValidateUtils;
import org.web3soft.commons.dictionary.consts.AppEnvConsts;
import org.web3soft.commons.dictionary.consts.UserAuthConsts;

import java.util.Objects;

/**
 * @author web3soft-team
 */
@Slf4j
public abstract class AbstractTokenInterceptor implements AsyncHandlerInterceptor {
    protected TokenProvider tokenProvider;
    protected SessionService<?> sessionService;

    protected AbstractTokenInterceptor(final TokenProvider tokenProvider, final SessionService<?> sessionService) {
        this.tokenProvider = tokenProvider;
        this.sessionService = sessionService;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response, final Object handler) throws Exception {
        log.debug("request url:{}", request.getRequestURL());

        final String headerName = this.tokenProvider.getTokenConfig().getRequestHeaderName();
        final String accessToken = request.getHeader(headerName);
        if (StringUtils.isBlank(accessToken)) {
            if (AppEnvConsts.isProductionMode()) {
                throw new TokenNotFoundException();
            }
            //非生产环境方便调试支持从cookie中读取token
            final Cookie tokenCookie = WebUtils.getCookie(request, TokenConsts.TOKEN);
            if (tokenCookie == null || StringUtils.isBlank(tokenCookie.getValue())) {
                throw new TokenNotFoundException();
            }
        }

        final TokenUserInfo tokenUserInfo = this.getTokenUserInfo(accessToken, request);
        request.setAttribute(UserAuthConsts.TOKEN_CURRENT_USER, tokenUserInfo);
        request.setAttribute(UserAuthConsts.TOKEN_CURRENT_USER_ID, Objects.isNull(tokenUserInfo) ? null : tokenUserInfo.getUserId());
        return true;
    }

    protected void validateAndRefresh(final TokenUserInfo tokenUserInfo, final String hmacToken,
                                      final HttpServletRequest request) {
        //如果session中不存在当前登录用户
        if (tokenUserInfo.isNotExists()) {
            throw new AbnormalAccessException();
        }
        //用户被禁用 或 为二次认证的token
        if (tokenUserInfo.isForbidden() || TokenConsts.STATUS_TWO_FACTOR.equals(tokenUserInfo.getStatus())) {
            throw new UserForbiddenException();
        }
        final TokenUserInfo session = this.sessionService.getByToken(hmacToken);
        if (Objects.isNull(session)) {
            throw new SessionExpiredException();
        }
        //非正常访问
        if (this.tokenProvider.verifyIpAndDevice(
                tokenUserInfo,
                ValidateUtils.getDeviceId(request),
                ValidateUtils.getRequestIP(request))
        ) {
            throw new AbnormalAccessException();
        }

        this.sessionService.refresh(hmacToken);
    }

    protected void clearSession(final String hmacToken, final TokenUserInfo tokenUserInfo) {
        this.sessionService.remove(hmacToken);
    }

    /**
     * token 关联的登录用户信息
     *
     * @param accessToken 用户当前登录会话token
     * @param request     HttpServletRequest
     * @return token关联的登录用户信息
     */
    protected abstract TokenUserInfo getTokenUserInfo(String accessToken, HttpServletRequest request);
}
