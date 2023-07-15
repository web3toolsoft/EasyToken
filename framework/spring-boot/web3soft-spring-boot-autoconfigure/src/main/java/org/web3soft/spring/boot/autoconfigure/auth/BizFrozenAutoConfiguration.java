package org.web3soft.spring.boot.autoconfigure.auth;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web3soft.commons.auth.config.BizFrozenConfig;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.interceptor.BizFrozenInterceptor;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.dictionary.enums.BizTypeEnum;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass({TokenCryptoProvider.class, BizFrozenInterceptor.class})
@EnableConfigurationProperties({AuthProperties.class})
public class BizFrozenAutoConfiguration
        implements WebMvcConfigurer, ApplicationContextAware {
    private static final String BIZ_FROZEN_INTERCEPTOR_BEAN_NAME = "bizFrozenInterceptor";
    private final AuthProperties authProperties;
    private final BizFrozenConfig frozenConfig;
    private final SessionService<TokenUserInfo> sessionService;
    private ApplicationContext applicationContext;

    public BizFrozenAutoConfiguration(final AuthProperties authProperties,
                                      final BizFrozenConfig frozenConfig,
                                      final SessionService<TokenUserInfo> sessionService) {
        this.authProperties = authProperties;
        this.frozenConfig = frozenConfig;
        this.sessionService = sessionService;
    }

    @Bean
    @ConditionalOnProperty(prefix = "web3soft.auth.frozen", name = "biz-type")
    public BizFrozenInterceptor bizFrozenInterceptor() {
        return new BizFrozenInterceptor(this.frozenConfig,this.sessionService);
    }

    @Bean
    @ConditionalOnProperty(prefix = "web3soft.auth.frozen", name = "biz-type")
    public BizFrozenConfig bizFrozenConfig() {
        final BizFrozenConfig config = new BizFrozenConfig();
        config.setBizType(BizTypeEnum.forName(this.authProperties.getFrozen().getBizType()));
        return config;
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        if (this.applicationContext.containsBean(BizFrozenAutoConfiguration.BIZ_FROZEN_INTERCEPTOR_BEAN_NAME)) {
            final String[] frozenIncludeUrlPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.authProperties.getFrozen().getUrlPatterns().getIncludeUrlPatterns()), String.class);
            final String[] frozenExcludePathPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.authProperties.getFrozen().getUrlPatterns().getExcludeUrlPatterns()), String.class);

            registry.addInterceptor(this.bizFrozenInterceptor())
                    .addPathPatterns(frozenIncludeUrlPatterns)
                    .excludePathPatterns(frozenExcludePathPatterns);
        }
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
