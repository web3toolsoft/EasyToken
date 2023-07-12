package org.web3soft.commons.web.i18n;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;
import org.web3soft.commons.dictionary.consts.AppEnvConsts;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author web3soft-team
 **/
@Slf4j
public class LocaleUtils {
    /**
     * 请求终端
     */
    public final static String SPIDER = "spider";
    public final static String ANDROID = "android";
    public final static String IPHONE = "iphone";
    public final static String IOS = "ios";

    /**
     * 请求头User-Agent
     */
    public final static String USER_AGENT = "User-Agent";

    /**
     * 请求头x-locale用于解决app(android,ios及feign-client)请求中含带语言设置
     */
    public final static String HEADER_X_LOCALE = "x-locale";

    /**
     * 繁体中文
     */
    public final static String[] TRADITIONAL_CHINESE = {"zh-tw", "zh_tw", "zh-hk", "zh_hk", "zh-hant", "zh_hant"};

    /**
     * 匹配手机端的UA中的本地化语言
     */
    private final static Pattern LOCALE_PATTERN = Pattern.compile("locale=(.*)$", Pattern.CASE_INSENSITIVE);

    private static final char UNDERLINE = '_';
    private static final char DASH = '-';

    private static final Map<String, Locale> LOCALE_MAP = new HashMap<>(16);

    private static LocaleResolver localeResolver;

    static {
        LOCALE_MAP.put(Locale.SIMPLIFIED_CHINESE.getLanguage(), Locale.SIMPLIFIED_CHINESE);
        LOCALE_MAP.put(Locale.ENGLISH.getLanguage(), Locale.US);
        LOCALE_MAP.put(Locale.FRANCE.getLanguage(), Locale.FRANCE);
        LOCALE_MAP.put(Locale.GERMANY.getLanguage(), Locale.GERMANY);
        LOCALE_MAP.put(Locale.ITALY.getLanguage(), Locale.ITALY);
        LOCALE_MAP.put(Locale.JAPAN.getLanguage(), Locale.JAPAN);
        LOCALE_MAP.put(Locale.KOREA.getLanguage(), Locale.KOREA);
    }

    public LocaleUtils(final LocaleResolver localeResolver) {
        LocaleUtils.localeResolver = localeResolver;
    }

    /**
     * 根据当前request对象中的locale(Header的Accept属性)初始化系统国际化语言区域环境
     *
     * @param request  当前请求对象
     * @param response 当前响应对象
     */
    public static void setInitLocale(final HttpServletRequest request, final HttpServletResponse response) {
        final Locale locale = request.getLocale();

        if (localeResolver instanceof final CookieLocaleResolver cookieLocaleResolver) {
            final Cookie cookie = WebUtils.getCookie(request, CookieLocaleResolver.DEFAULT_COOKIE_NAME);
            if (cookie == null) {
                setLocale(request, response, locale,
                        "Init CookieLocaleResolver locale url :{},country:{},lang:{}");
                return;
            }
            log.debug("CookieLocaleResolver locale name:{} ,value:{}", cookie.getName(), cookie.getValue());
        }

        if (localeResolver instanceof SessionLocaleResolver) {
            try {
                final Locale sessionLocale = (Locale) WebUtils.getRequiredSessionAttribute(
                        request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME
                );
                log.debug("SessionLocaleResolver Locale: {}", sessionLocale.toLanguageTag());
            }catch (final Exception e){
                setLocale(request, response, locale, "Init SessionLocaleResolver locale url :{}, country:{},lang:{}");
                log.error("SessionLocaleResolver Locale error", e);
            }
        }
    }

    /**
     * @param request
     * @param response
     * @param locale
     * @param format
     */
    private static void setLocale(final HttpServletRequest request, final HttpServletResponse response,
                                  final Locale locale, final String format) {
        setLocale(locale.toLanguageTag(), request, response);
        log.debug(format, request.getRequestURL().toString(), locale.getCountry(), locale.toLanguageTag());
    }

    /**
     * 设置国际化语言区域环境
     * 自动判断多请求端(web,android,ios,spider)
     *
     * @param request
     * @param response
     */
    public static void setLocale(final HttpServletRequest request, final HttpServletResponse response) {
        //如果当前请求已经带上本地化语言的cookie（即已经设置了当前语言环境）就不再次进行设置
        final Cookie cookie = WebUtils.getCookie(request, getLocaleCookieName());
        if (cookie != null) {
            return;
        }

        //如果当前请求是来自apps(android,ios)与feign client的
        final String xLocale = request.getHeader(HEADER_X_LOCALE);
        if (StringUtils.isNotBlank(xLocale)) {
            setLocale(xLocale, request, response);
            return;
        }

        //如果当前请求是来自spider
        final String userAgent = StringUtils.defaultIfBlank(
                request.getHeader(USER_AGENT), StringUtils.EMPTY).toLowerCase();
        log.debug("USER_AGENT :{}", userAgent);

        if (StringUtils.containsIgnoreCase(userAgent, SPIDER)) {
            final Matcher matcher = LOCALE_PATTERN.matcher(userAgent);
            if (matcher.find()) {
                final String lang = matcher.group(1);
                setLocale(lang, request, response);
            } else {
                localeResolver.setLocale(request, response, Locale.US);
            }
            return;
        }
        setInitLocale(request, response);
    }

    /**
     * 设置国际化语言区域环境
     *
     * @param lang     国际化语言名称
     * @param request  当前请求对象
     * @param response 当前响应对象
     */
    public static void setLocale(final String lang, final HttpServletRequest request, final HttpServletResponse response) {
        final Locale locale = getLocale(lang);
        localeResolver.setLocale(request, response, locale);
    }

    /**
     * 获取当前上下文本地化(locale)语言设置值
     *
     * @return 返回Locale对象的toLanguageTag名称(如zh - CN | en - US等)
     */
    public static String getLocale() {
        return LocaleContextHolder.getLocale().toLanguageTag();
    }

    /**
     * 获取当前系统支持的locale
     *
     * @param lang 当前请求中的lang
     * @return {@link Locale}
     */
    public static Locale getLocale(String lang) {
        Locale locale = AppEnvConsts.DEFAULT_LOCALE;
        if (StringUtils.isBlank(lang)) {
            return locale;
        }

        lang = StringUtils.trim(parseToLanguageTag(lang));
        locale = Locale.forLanguageTag(lang);
        if (StringUtils.isNotBlank(locale.getCountry())) {
            return locale;
        }

        if (LOCALE_MAP.containsKey(locale.getLanguage())) {
            return LOCALE_MAP.get(locale.getLanguage());
        }

        return AppEnvConsts.DEFAULT_LOCALE;
    }

    /**
     * 从当前请求中获取请求本地化(locale)语言设置值
     *
     * @param request @see #HttpServletRequest
     * @return 返回Locale对象的toLanguageTag名称(如zh - CN | en - US等)
     */
    public static String getLocale(final HttpServletRequest request) {
        //如果当前请求是来自apps(android,ios)与feign client的
        final String xLocale = request.getHeader(HEADER_X_LOCALE);
        if (StringUtils.isNotBlank(xLocale)) {
            return getLocale(xLocale).toLanguageTag();
        }
        return getLocale(request, getLocaleCookieName());
    }

    /**
     * 从当前请求cookie中获取请求本地化(locale)语言设置值
     *
     * @param request    @see #HttpServletRequest
     * @param cookieName locale cookie 名称
     * @return 返回Locale对象的toLanguageTag名称(如zh - CN | en - US等)
     */
    public static String getLocale(final HttpServletRequest request, final String cookieName) {
        final Cookie cookie = WebUtils.getCookie(request, cookieName);
        final String lang = (cookie != null ? parseToLanguageTag(cookie.getValue()) : StringUtils.EMPTY);
        return getLocale(lang).toLanguageTag();
    }

    /**
     * locale是否为繁体中文语言地区
     *
     * @param lang locale
     * @return true|false
     */
    public static boolean isTraditionalChinese(final String lang) {
        return StringUtils.equalsAnyIgnoreCase(lang, TRADITIONAL_CHINESE);
    }

    /**
     * 获取多语言cookie名称
     *
     * @return 多语言cookie名称
     */
    public static String getLocaleCookieName() {
        if (localeResolver instanceof CookieLocaleResolver) {
            return CookieLocaleResolver.DEFAULT_COOKIE_NAME;
        }
        return StringUtils.EMPTY;
    }

    /**
     * 把language 字符串转成LanguageTag格式
     *
     * @param locale (en-US|zh-CN)
     * @return {@see Locale#toLanguageTag()}
     */
    public static String parseToLanguageTag(final String locale) {
        return StringUtils.replaceChars(locale, UNDERLINE, DASH);
    }

}
