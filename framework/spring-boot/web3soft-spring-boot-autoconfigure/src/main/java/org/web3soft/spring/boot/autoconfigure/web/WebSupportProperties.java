package org.web3soft.spring.boot.autoconfigure.web;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.web")
public class WebSupportProperties {
    private final InitDataFilterConfig initDataFilter = new InitDataFilterConfig();
    private final ServletContainerConfig servletContainer = new ServletContainerConfig();
    private final MessageConverterConfig messageConverter = new MessageConverterConfig();
    private final ExceptionAdviceConfig exceptionAdvice = new ExceptionAdviceConfig();

    public static class InitDataFilterConfig {
        private boolean enabled = true;

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }
    }

    public static class ServletContainerConfig {
        private boolean enabled = true;

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }
    }

    public static class MessageConverterConfig {
        private boolean enabled = true;

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }
    }

    public static class ExceptionAdviceConfig {
        private boolean enabled = true;

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }
    }
}
