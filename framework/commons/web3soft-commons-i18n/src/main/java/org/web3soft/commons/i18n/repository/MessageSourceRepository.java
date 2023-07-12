package org.web3soft.commons.i18n.repository;

import java.util.Locale;

public interface MessageSourceRepository {
    /**
     * @param code
     * @param locale
     * @return message
     */
    String getMessage(final String code, final Locale locale);
}
