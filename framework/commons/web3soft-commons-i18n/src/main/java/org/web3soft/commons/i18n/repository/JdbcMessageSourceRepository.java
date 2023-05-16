package org.web3soft.commons.i18n.repository;

import java.util.Locale;

/**
 * jdbc(mysql,sqlserver,etc.) message repository
 */
public class JdbcMessageSourceRepository implements MessageSourceRepository {

    @Override
    public String getMessage(final String code, final Locale locale) {
        return null;
    }
}
