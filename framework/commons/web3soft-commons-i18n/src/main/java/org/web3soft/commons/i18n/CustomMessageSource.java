package org.web3soft.commons.i18n;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.lang.Nullable;
import org.web3soft.commons.i18n.repository.MessageSourceRepository;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * 自定义的国际化Message资源加载类
 *
 * @author web3soft-team
 **/
public class CustomMessageSource implements MessageSource {
    private final MessageSourceRepository repository;

    public CustomMessageSource(final MessageSourceRepository repository) {
        this.repository = repository;
    }

    @Nullable
    @Override
    public String getMessage(@Nullable final String code, @Nullable final Object[] args,
                             @Nullable final String defaultMessage, @Nullable Locale locale) {
        if (StringUtils.isBlank(code)) {
            return StringUtils.EMPTY;
        }

        // 默认语言为英语
        if (locale == null) {
            locale = I18nConsts.DEFAULT_LOCALE;
        }

        String msg = this.repository.getMessage(code, locale);
        if (StringUtils.isEmpty(msg) && !StringUtils.equals(I18nConsts.DEFAULT_LOCALE.toLanguageTag(), locale.toLanguageTag())) {
            locale = I18nConsts.DEFAULT_LOCALE;
            msg = this.repository.getMessage(code, locale);
        }

        msg = StringUtils.defaultIfBlank(msg, defaultMessage);
        if (StringUtils.isBlank(msg)) {
            return StringUtils.EMPTY;
        }

        final Object[] argsToUse = ArrayUtils.isEmpty(args) ? new Object[0] : args;
        final MessageFormat messageFormat = new MessageFormat(msg, locale);
        return messageFormat.format(argsToUse);
    }

    @Override
    public String getMessage(@Nullable final String code, @Nullable final Object[] args, @Nullable final Locale locale)
            throws NoSuchMessageException {
        return this.getMessage(code, args, null, locale);
    }

    @Override
    public String getMessage(@Nullable final MessageSourceResolvable resolvable, @Nullable final Locale locale)
            throws NoSuchMessageException {
        return null;
    }
}
