package org.web3soft.commons.i18n.repository;

import java.util.Locale;

/**
 * mongodb message repository
 *
 * @link http://mongodb.github.io/mongo-java-driver/
 */
public class MongoDbMessageSourceRepository implements MessageSourceRepository {
    @Override
    public String getMessage(final String code, final Locale locale) {
        return null;
    }
}
