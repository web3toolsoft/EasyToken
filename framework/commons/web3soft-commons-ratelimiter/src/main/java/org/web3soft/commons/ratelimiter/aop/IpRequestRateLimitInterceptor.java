package org.web3soft.commons.ratelimiter.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.web3soft.commons.lang.util.IpUtil;
import org.web3soft.commons.ratelimiter.RateLimitParameter;
import org.web3soft.commons.ratelimiter.RateLimiter;
import org.web3soft.commons.ratelimiter.annotation.IpRequestRateLimit;
import org.web3soft.commons.ratelimiter.config.RateLimiterConfig;
import org.web3soft.commons.ratelimiter.consts.RateLimitKeys;
import org.web3soft.commons.ratelimiter.model.RateLimitInfo;
import org.web3soft.commons.ratelimiter.util.RateLimiterUtils;

import java.lang.reflect.Method;

/**
 * Api请求次数限制拦截器
 *
 * @author web3soft-team
 */
@Slf4j
public class IpRequestRateLimitInterceptor implements AsyncHandlerInterceptor {
    private final static int VALID_ARRAY_LENGTH = 2;

    private final RateLimiterConfig rateLimiterConfig;
    private final RateLimiter rateLimiter;

    public IpRequestRateLimitInterceptor(final RateLimiterConfig rateLimiterConfig, final RateLimiter rateLimiter) {
        this.rateLimiterConfig = rateLimiterConfig;
        this.rateLimiter = rateLimiter;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        if (handler instanceof HandlerMethod) {
            final Method method = ((HandlerMethod) handler).getMethod();
            final String mappingUrl = RateLimiterUtils.getRequestMappingUrl(method);
            if (StringUtils.isBlank(mappingUrl)) {
                return true;
            }

            String limitValue = StringUtils.EMPTY;
            final IpRequestRateLimit limitAnnotation = method.getAnnotation(IpRequestRateLimit.class);
            if (limitAnnotation != null) {
                limitValue = limitAnnotation.value();
            }

            final RateLimitParameter rateLimitParameter = this.createRateLimitParameter(request, mappingUrl, limitValue);
            final boolean canAcquire = this.rateLimiter.canAcquire(rateLimitParameter);
            if (canAcquire) {
                log.info("ip rate limit key:{}", rateLimitParameter.getRateLimitKey());
                RateLimiterUtils.setResponseHeaders(response,
                        rateLimitParameter.getSeconds(),
                        rateLimitParameter.getUsed(),
                        rateLimitParameter.getMaxRequestTimes()
                );
            } else {
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                return false;
            }
        }
        return true;
    }

    private RateLimitParameter createRateLimitParameter(final HttpServletRequest request,
                                                        final String mappingUrl,
                                                        final String limitValue) {
        final String rateLimitKey = this.getRateLimitKey(request, mappingUrl);
        final RateLimitInfo rateLimitInfo = this.getRateLimitInfo(limitValue);
        return RateLimitParameter.builder()
                .rateLimitKey(rateLimitKey)
                .maxRequestTimes(rateLimitInfo.getMaxRequestTimes())
                .seconds(rateLimitInfo.getSeconds()).build();
    }

    private String getRateLimitKey(final HttpServletRequest request,
                                   final String mappingUrl) {
        final String ip = IpUtil.getRealIPAddress(request);
        final long longIp = IpUtil.toLong(IpUtil.getRealIPAddress(request));
        log.info("rate limit ip:{}({})", ip, longIp);
        return RateLimitKeys.IP_RATE_LIMITER_KEY_PREFIX + StringUtils.joinWith(":", longIp, mappingUrl);
    }

    private RateLimitInfo getRateLimitInfo(final String limitValue) {
        final int defaultMaxRequestTimes = this.rateLimiterConfig.getIpRequestRateLimiter().getMaxRequestTimes();
        final int defaultSeconds = this.rateLimiterConfig.getIpRequestRateLimiter().getSeconds();

        final String[] limits = StringUtils.split(limitValue, "/");
        if (ArrayUtils.getLength(limits) == VALID_ARRAY_LENGTH) {
            return RateLimitInfo.builder()
                    .maxRequestTimes(NumberUtils.toInt(limits[0], defaultMaxRequestTimes))
                    .seconds(NumberUtils.toInt(limits[1], defaultSeconds))
                    .build();
        }
        return RateLimitInfo.builder()
                .maxRequestTimes(defaultMaxRequestTimes)
                .seconds(defaultSeconds)
                .build();
    }
}
