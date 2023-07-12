package org.web3soft.commons.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.web3soft.commons.support.annotation.ApiEnabledFor;
import org.web3soft.commons.support.enums.SystemErrorCode;
import org.web3soft.commons.support.exception.ApiDisabledException;

import java.lang.reflect.Method;

/**
 * Api是否启用拦截器
 *
 * @author web3soft-team
 */
public class ApiEnabledForInterceptor implements AsyncHandlerInterceptor {
    private static final String DEFAULT_APP_NAME = "test";
    private final String currentAppName;

    public ApiEnabledForInterceptor(final String appName) {
        this.currentAppName = appName;
    }

    @Override
    public boolean preHandle(@NonNull final HttpServletRequest request,
                             @NonNull final HttpServletResponse response,
                             @NonNull final Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final Method method = ((HandlerMethod) handler).getMethod();
            final ApiEnabledFor apiEnabledFor = method.getAnnotation(ApiEnabledFor.class);
            if (apiEnabledFor == null || StringUtils.equalsIgnoreCase(this.currentAppName, ApiEnabledForInterceptor.DEFAULT_APP_NAME)) {
                return true;
            }
            final String value = apiEnabledFor.value();
            if (!StringUtils.equalsIgnoreCase(value, this.currentAppName)) {
                throw new ApiDisabledException(SystemErrorCode.API_DISABLED);
            }
        }
        return true;
    }
}
