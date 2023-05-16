package org.web3soft.commons.i18n;

import java.util.Locale;

public class I18nConsts {
    /**
     * 公共多语言(i18n)缓存key命名空间
     */
    public static final String COMMON_CACHE_NAMESPACE_I18N = "org:web3soft.commons:i18n:";

    /**
     * 公共多语言(i18n)messages缓存key命名空间
     */
    public static final String COMMON_CACHE_NAMESPACE_I18N_MSG = COMMON_CACHE_NAMESPACE_I18N + "msg:";

    /**
     * 系统默认语言项默认值（简体中文）
     */
    public static Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

    /**
     * 系统默认语言项默认值（简体中文）
     *
     * @return {@link Locale}
     */
    public static Locale setDefaultLocale(final Locale locale) {
        return I18nConsts.DEFAULT_LOCALE = locale;
    }
}
