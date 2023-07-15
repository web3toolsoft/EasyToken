package org.web3soft.spring.boot.autoconfigure.i18n;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.i18n")
public class I18nProperties {
    private boolean customMessageSource = false;
    private String repository = "redis";

    /**
     * 是否自定义message source {@link org.springframework.context.MessageSource}
     *
     * @return true|false
     */
    public boolean isCustomMessageSource() {
        return this.customMessageSource;
    }

    /**
     * 是否自定义message source {@link org.springframework.context.MessageSource}
     *
     * @param customMessageSource true|false
     */
    public void setCustomMessageSource(final boolean customMessageSource) {
        this.customMessageSource = customMessageSource;
    }

    /**
     * @return i18n message source repository
     */
    public String getRepository() {
        return this.repository;
    }

    /**
     * i18n message source repository
     *
     * @param repository value[redis|jdbc|mongodb]
     */
    public void setRepository(final String repository) {
        this.repository = repository;
    }
}
