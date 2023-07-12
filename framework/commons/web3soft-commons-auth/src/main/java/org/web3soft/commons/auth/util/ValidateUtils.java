package org.web3soft.commons.auth.util;

import org.web3soft.commons.lang.util.IpUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.auth.consts.TokenConsts;

/**
 * @author web3soft-team
 */
public class ValidateUtils {

    /**
     * @param request
     * @return IP
     */
    public static Long getRequestIP(final HttpServletRequest request) {
        return IpUtil.toLong(IpUtil.getRealIPAddress(request));
    }

    /**
     * @param request
     * @return deviceId
     */
    public static String getDeviceId(final HttpServletRequest request) {
        return StringUtils.defaultIfBlank(request.getHeader(TokenConsts.X_DEV_ID), StringUtils.EMPTY);
    }
}
