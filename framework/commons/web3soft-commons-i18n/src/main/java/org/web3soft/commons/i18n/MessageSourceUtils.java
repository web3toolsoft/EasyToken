package org.web3soft.commons.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * @author web3soft-team
 **/
@Slf4j
public class MessageSourceUtils {
    private static MessageSource messageSource;

    public MessageSourceUtils(final MessageSource messageSource) {
        MessageSourceUtils.messageSource = messageSource;
    }

    /**
     * @param code 对应messages配置的key.
     * @return String
     */
    public static String getMessage(final String code) {
        return getMessage(code, null);
    }

    /**
     * @param code 对应messages配置的key.
     * @param args 数组参数.
     * @return String
     */
    public static String getMessage(final String code, final Object[] args) {
        return getMessage(code, args, "");
    }

    /**
     * @param code           对应messages配置的key.
     * @param args           数组参数.
     * @param defaultMessage 没有设置key的时候的默认值.
     * @return String
     */
    public static String getMessage(final String code, final Object[] args, final String defaultMessage) {
        final Locale locale = LocaleContextHolder.getLocale();
        log.debug("Message Locale code:{}, tag:{},value:{}", code, locale.toLanguageTag(), locale);
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

}
