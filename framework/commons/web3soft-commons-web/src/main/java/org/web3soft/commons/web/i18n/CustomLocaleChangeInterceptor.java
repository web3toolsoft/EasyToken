package org.web3soft.commons.web.i18n;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * 多端(web,android,iphone)国际化语言切换拦截器
 *
 * @author web3soft-team
 **/
public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
    @Override
    public boolean preHandle(@NonNull final HttpServletRequest request,
                             @NonNull final HttpServletResponse response,
                             @NonNull final Object handler)
            throws ServletException {
        LocaleUtils.setLocale(request, response);
        return true;
    }
}
