package org.web3soft.spring.boot.autoconfigure.ratelimiter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.web3soft.commons.support.properties.InterceptorProperty;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.rate-limiter")
public class RateLimiterProperties {
    private RateLimiterConfigProperties ipRateLimiter = new RateLimiterConfigProperties();

    public RateLimiterConfigProperties getIpRateLimiter() {
        return this.ipRateLimiter;
    }

    public void setIpRateLimiter(final RateLimiterConfigProperties ipRateLimiter) {
        this.ipRateLimiter = ipRateLimiter;
    }

    public static class RateLimiterConfigProperties {
        private boolean enabled = false;
        private int maxRequestTimes = 10;
        private int seconds = 1;

        @NestedConfigurationProperty
        private InterceptorProperty interceptor = new InterceptorProperty("/v1/**", "");

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }

        public int getMaxRequestTimes() {
            return this.maxRequestTimes;
        }

        public void setMaxRequestTimes(final int maxRequestTimes) {
            this.maxRequestTimes = maxRequestTimes;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public void setSeconds(final int seconds) {
            this.seconds = seconds;
        }

        public InterceptorProperty getInterceptor() {
            return this.interceptor;
        }

        public void setInterceptor(final InterceptorProperty interceptor) {
            this.interceptor = interceptor;
        }
    }
}
