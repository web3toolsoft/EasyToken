package org.web3soft.commons.web.i18n;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

/**
 * 自定义CookieLocaleResolver
 * 为了兼容language语言en-US/en_US两种模式
 *
 * @author web3soft-team
 */
public class CustomCookieLocaleResolver extends CookieLocaleResolver {

    public CustomCookieLocaleResolver(final String cookieName) {
        super(cookieName);
    }

    @Override
    protected Locale parseLocaleValue(@NonNull final String locale) {
        return LocaleUtils.getLocale(locale);
    }
}
