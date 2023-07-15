package org.web3soft.spring.boot.autoconfigure.ratelimiter;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web3soft.commons.ratelimiter.RateLimiter;
import org.web3soft.commons.ratelimiter.aop.IpRequestRateLimitInterceptor;
import org.web3soft.commons.ratelimiter.config.RateLimiterConfig;
import org.web3soft.commons.ratelimiter.limiter.RedisRateLimiter;

/**
 * @author web3soft-team
 */
@Order(90)
@AutoConfiguration
@EnableConfigurationProperties({RateLimiterProperties.class})
@ConditionalOnClass(RateLimiter.class)
public class RateLimiterAutoConfiguration
        implements WebMvcConfigurer, ApplicationContextAware {
    private static final String IP_REQUEST_RATE_LIMIT_INTERCEPTOR_BEAN_NAME = "ipRequestRateLimitInterceptor";
    private final RateLimiterProperties properties;
    private final RateLimiterConfig rateLimiterConfig;
    private final RateLimiter rateLimiter;
    private ApplicationContext applicationContext;

    public RateLimiterAutoConfiguration(final RateLimiterProperties properties,
                                        final RateLimiterConfig rateLimiterConfig,
                                        final RateLimiter rateLimiter) {
        this.properties = properties;
        this.rateLimiterConfig = rateLimiterConfig;
        this.rateLimiter = rateLimiter;
    }

    @Bean("rateLimiterConfig")
    public RateLimiterConfig rateLimiterConfig() {
        return RateLimiterConfig.builder()
                .ipRequestRateLimiter(RateLimiterConfig.RateLimiterConfigItem.builder()
                        .maxRequestTimes(this.properties.getIpRateLimiter().getMaxRequestTimes())
                        .seconds(this.properties.getIpRateLimiter().getSeconds())
                        .build())
                .build();
    }

    @Bean("rateLimiter")
    @ConditionalOnMissingBean(name = "customRateLimiter")
    public RateLimiter rateLimiter() {
        return new RedisRateLimiter();
    }

    @Bean("ipRequestRateLimitInterceptor")
    @ConditionalOnMissingBean(name = "ipRequestRateLimitInterceptor")
    @ConditionalOnProperty("web3soft.rate-limiter.ip-rate-limiter.enabled")
    public IpRequestRateLimitInterceptor ipRequestRateLimitInterceptor() {
        return new IpRequestRateLimitInterceptor(this.rateLimiterConfig, this.rateLimiter);
    }

    @Override
    public void addInterceptors(@NonNull final InterceptorRegistry registry) {
        final String[] ipIncludeUrlPatterns = Iterables.toArray(Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(this.properties.getIpRateLimiter().getInterceptor().getIncludeUrlPatterns()), String.class);
        final String[] ipExcludePathPatterns = Iterables.toArray(Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(this.properties.getIpRateLimiter().getInterceptor().getExcludeUrlPatterns()), String.class);

        if (this.applicationContext.containsBean(RateLimiterAutoConfiguration.IP_REQUEST_RATE_LIMIT_INTERCEPTOR_BEAN_NAME)) {
            registry.addInterceptor(this.ipRequestRateLimitInterceptor())
                    .addPathPatterns(ipIncludeUrlPatterns)
                    .excludePathPatterns(ipExcludePathPatterns);
        }
    }

    @Override
    public void setApplicationContext(@NonNull final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
