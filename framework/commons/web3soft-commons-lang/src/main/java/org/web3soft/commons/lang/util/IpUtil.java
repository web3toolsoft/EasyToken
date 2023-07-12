package org.web3soft.commons.lang.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * IP 相关工具类
 *
 * @author web3soft-team
 */
@Slf4j
public class IpUtil {

    public static final String REAL_IP_HEADER = "X-Real-IP";

    public static String longToString(final long ip) {
        if (ip <= 0) {
            return "0.0.0.0";
        }

        try {
            return longToIp(ip);
        } catch (final Exception ex) {
            log.info("ip:{} long to string cast error", ip);
        }
        return "-1";
    }

    public static long toLong(final String ip) {
        if (StringUtils.isBlank(ip)) {
            log.info("ip address is empty");
            return -1;
        }

        try {
            return ipToLong2(ip);
        } catch (final Exception ex) {
            log.info("ip:{} string to long cast error", ip);
        }
        return -1;
    }

    private static long ipToLong(final String ip) {
        final String[] ipSegments = StringUtils.split(ip, '.');
        if (ipSegments.length != 4) {
            log.info("ip:{} is not ipv4 address", ip);
            return -1;
        }

        long result = 0;
        for (int i = 0; i < ipSegments.length; i++) {
            final int power = 3 - i;
            final int segment = Integer.parseInt(ipSegments[i]);
            result += segment * Math.pow(256, power);
        }
        return result;
    }

    private static long ipToLong2(final String ip) {
        final String[] ipSegments = StringUtils.split(ip, '.');
        if (ipSegments.length != 4) {
            log.info("ip:{} is not ipv4 address", ip);
            return -1;
        }

        long result = 0;
        for (int i = 3; i >= 0; i--) {
            final long segment = Long.parseLong(ipSegments[3 - i]);
            result |= segment << (i * 8);
        }
        return result;
    }

    private static String longToIp(final long i) {
        return ((i >> 24) & 0xFF) +
                "." + ((i >> 16) & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + (i & 0xFF);
    }

    private static String longToIp2(long ip) {
        final StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            sb.insert(0, Long.toString(ip & 0xff));
            if (i < 3) {
                sb.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return sb.toString();
    }

    /**
     * 从 {@link HttpServletRequest} 对象中获；得请求端 IP 地址。
     * 先尝试从 HTTP Header: "X-Real-IP" 中获取
     * 若失败则通过  {@link HttpServletRequest#getRemoteUser()} 获取
     *
     * @param request 请求
     * @return IP 地址的字符串表示
     */
    public static String getRealIPAddress(final HttpServletRequest request) {
        final String address = request.getHeader(REAL_IP_HEADER);
        final String firstAddress = StringUtils.substringBefore(address, ",");
        if (StringUtils.isNotEmpty(firstAddress)) {
            return firstAddress;
        }
        return request.getRemoteAddr();
    }
}
