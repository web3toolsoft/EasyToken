package org.web3soft.commons.auth.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.web3soft.commons.auth.consts.TokenConsts;
import org.web3soft.commons.auth.model.TokenUserInfo;

/**
 * 获取登录用户相关信息Utils类
 */
@Slf4j
public class HttpSessionUtils {

    /**
     * 获取当前登录用户id
     *
     * @param request
     * @return
     */
    public static long getUserId(final HttpServletRequest request) {
        try {
            final TokenUserInfo user = TokenUtils.getCurrentLoginUser(request);
            if (user.isNotExists()) {
                return -1L;
            }
            return ObjectUtils.defaultIfNull(user.getUserId(), -1L);
        } catch (final Exception e) {
            log.error("get user token error!", e);
        }
        return -1L;
    }

    /**
     * 获取当前登录用户id状态
     *
     * @param request
     * @return
     */
    public static int getUserTokenStatus(final HttpServletRequest request) {
        try {
            final TokenUserInfo user = TokenUtils.getCurrentLoginUser(request);
            return user.getStatus();
        } catch (final Exception e) {
            log.error("get user token error!", e);
        }
        return TokenConsts.STATUS_NOT_EXISTS;
    }
}
