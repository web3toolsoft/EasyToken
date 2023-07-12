package org.web3soft.commons.auth.util;

import org.web3soft.commons.dictionary.consts.UserAuthConsts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3soft.commons.auth.consts.TokenConsts;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.TokenProvider;

/**
 * @author web3soft-team
 */
@Slf4j
@Component
public class TokenUtils {
    private static TokenProvider tokenProvider;
    private static SessionService<TokenUserInfo> sessionService;

    @Autowired
    public TokenUtils(final TokenProvider tokenProvider, final SessionService<TokenUserInfo> sessionService) {
        TokenUtils.tokenProvider = tokenProvider;
        TokenUtils.sessionService = sessionService;
    }

    /**
     * 获取与登录会话有关的全局冻结业务变量
     *
     * @param key 缓存key名称
     * @return 状态值
     */
    public static Integer getGlobalFrozenStatus(final String key) {
        return sessionService.getGlobalStatus(key);
    }

    /**
     * 设置与登录会话有关的全局冻结业务变量
     *
     * @param key    缓存key名称
     * @param status 状态值
     */
    public static void setGlobalFrozenStatus(final String key, final Integer status) {
        sessionService.setGlobalStatus(key, status);
    }

    /**
     * 删除登录会话有关的全局冻结业务变量
     *
     * @param key 缓存key名称
     */
    public static void removeGlobalFrozenStatus(final String key) {
        sessionService.deleteGlobalStatus(key);
    }

    /**
     * 从http request中获取当前登录用户对象
     *
     * @param request HttpServletRequest
     * @return @see #TokenUserInfo
     */
    public static TokenUserInfo getCurrentLoginUser(final HttpServletRequest request) {
        final TokenUserInfo tokenUserInfo = (TokenUserInfo) request.getAttribute(UserAuthConsts.TOKEN_CURRENT_USER);
        if (tokenUserInfo == null) {
            return TokenUserInfo.builder().status(TokenConsts.STATUS_NOT_EXISTS).build();
        }
        return tokenUserInfo;
    }

    /**
     * 从http request中获取当前登录用户对象
     *
     * @param request HttpServletRequest
     * @return @see #TokenUserInfo
     */
    public static TokenUserInfo getCurrentLoginUserFromToken(final HttpServletRequest request) {
        final String accessToken = getAccessToken(request);
        return getCurrentLoginUserFromToken(accessToken);
    }

    /**
     * 获取当前登录用户对象
     *
     * @param accessToken 用户当前登录token
     * @return @see #TokenUserInfo
     */
    public static TokenUserInfo getCurrentLoginUserFromToken(final String accessToken) {
        if (StringUtils.isBlank(accessToken)) {
            log.warn("token is empty");
            return TokenUserInfo.builder().status(TokenConsts.STATUS_NOT_EXISTS).build();
        }
        return tokenProvider.getTokenUserInfo(accessToken);
    }

    /**
     * 清除当前登录用户会话记录
     *
     * @param request http request
     */
    public static void clearSession(final HttpServletRequest request) {
        final String accessToken = getAccessToken(request);
        if (StringUtils.isNotBlank(accessToken)) {
            final String hmacToken = tokenProvider.getHmacToken(accessToken);
            sessionService.remove(hmacToken);
        }
    }

    /**
     * 获取当前用户登录access token
     *
     * @param request http request
     * @return 获取当前用户登录access token
     */
    public static String getAccessToken(final HttpServletRequest request) {
        final String tokenName = tokenProvider.getTokenConfig().getRequestHeaderName();
        return request.getHeader(tokenName);
    }

    /**
     * 删除登录会话用户状态信息(会影响所有端web,android,ios等的登录状)
     *
     * @param userId 登录用户id
     */
    public static void removeSessionUser(final long userId) {
        sessionService.removeSessionUser(userId);
    }

    /**
     * 根据用户ID获取当前用户登录会话信息
     *
     * @param userId 用户id
     * @return {@link TokenUserInfo}
     */
    public static TokenUserInfo getSession(final long userId) {
        return sessionService.getByUserId(userId);
    }

    /**
     * 生成 token
     *
     * @param tokenUserInfo {@link TokenUserInfo}
     * @param request       http request
     * @return access token
     */
    public static String generateToken(final TokenUserInfo tokenUserInfo, final HttpServletRequest request) {
        tokenUserInfo.setIp(ValidateUtils.getRequestIP(request));
        tokenUserInfo.setDevId(ValidateUtils.getDeviceId(request));
        return tokenProvider.generateToken(tokenUserInfo);
    }

    /**
     * 生成 token 并 创建登录session记录
     *
     * @param tokenUserInfo {@link TokenUserInfo}
     * @param request       http request
     * @return access token
     */
    public static String generateTokenAndCreateSession(final TokenUserInfo tokenUserInfo,
                                                       final HttpServletRequest request) {
        final String accessToken = generateToken(tokenUserInfo, request);
        final String hmacToken = tokenProvider.getHmacToken(accessToken);
        sessionService.save(hmacToken, tokenUserInfo);
        return accessToken;
    }

    /**
     * 更新用户登录会话状态
     *
     * @param tokenUserInfo {@link TokenUserInfo}
     */
    public static void updateSession(final TokenUserInfo tokenUserInfo) {
        sessionService.updateByUserId(tokenUserInfo);
    }

    /**
     * 清除所有登录用户会话记录
     */
    public static void clearAllSession() {
        sessionService.clearAllSession();
    }
}
