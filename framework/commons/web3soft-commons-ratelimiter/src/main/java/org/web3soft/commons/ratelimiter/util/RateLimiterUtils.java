package org.web3soft.commons.ratelimiter.util;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web3soft.commons.ratelimiter.enums.RateLimitHttpHeaderEnum;

import java.lang.reflect.Method;

/**
 * @author web3soft-team
 */
public class RateLimiterUtils {
    /**
     * @param response
     * @param seconds
     * @param used     used request times
     * @param max      request times
     */
    public static void setResponseHeaders(final HttpServletResponse response,
                                          final long seconds, final long used, final long max) {
        response.setHeader(RateLimitHttpHeaderEnum.X_RATELIMIT_LIMIT.getName(), String.valueOf(max));
        response.setHeader(RateLimitHttpHeaderEnum.X_RATELIMIT_REMAINING.getName(), String.valueOf(max - used));
        response.setHeader(RateLimitHttpHeaderEnum.X_RATELIMIT_USED.getName(), String.valueOf(used));
        response.setHeader(RateLimitHttpHeaderEnum.X_RATELIMIT_RESET.getName(), String.valueOf(System.currentTimeMillis() + (seconds * 1000)));
    }

    /**
     * @param method
     * @return
     */
    public static String getRequestMappingUrl(final Method method) {
        final GetMapping getMapping = AnnotationUtils.getAnnotation(method, GetMapping.class);
        if (getMapping != null) {
            return getMapping.value()[0];
        }
        final PostMapping postMapping = AnnotationUtils.getAnnotation(method, PostMapping.class);
        if (postMapping != null) {
            return postMapping.value()[0];
        }
        final DeleteMapping deleteMapping = AnnotationUtils.getAnnotation(method, DeleteMapping.class);
        if (deleteMapping != null) {
            return deleteMapping.value()[0];
        }
        final PutMapping putMapping = AnnotationUtils.getAnnotation(method, PutMapping.class);
        if (putMapping != null) {
            return putMapping.value()[0];
        }
        final PatchMapping patchMapping = AnnotationUtils.getAnnotation(method, PatchMapping.class);
        if (patchMapping != null) {
            return patchMapping.value()[0];
        }
        final RequestMapping requestMapping = AnnotationUtils.getAnnotation(method, RequestMapping.class);
        if (requestMapping != null) {
            return requestMapping.value()[0];
        }
        return StringUtils.EMPTY;
    }

}
