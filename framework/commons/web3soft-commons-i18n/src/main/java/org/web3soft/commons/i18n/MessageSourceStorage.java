package org.web3soft.commons.i18n;

/**
 * MessageSource Storage Enums
 */
public enum MessageSourceStorage {
    /**
     * redis
     */
    REDIS("redis"),

    /**
     * mysql/sqlserver/pgsql/etc.
     */
    JDBC("jdbc"),

    /**
     * mongodb
     */
    MONGODB("mongodb"),
    ;

    private final String name;

    MessageSourceStorage(final String name) {
        this.name = name;
    }

    public static MessageSourceStorage forName(final String name) {
        for (final var alg : MessageSourceStorage.values()) {
            if (alg.getName().equalsIgnoreCase(name)) {
                return alg;
            }
        }
        return MessageSourceStorage.REDIS;
    }

    public String getName() {
        return this.name;
    }
}
