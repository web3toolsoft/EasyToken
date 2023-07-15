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
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web3soft.commons.auth.config.TokenConfig;
import org.web3soft.commons.auth.crypto.AesTokenCryptoProvider;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.interceptor.HmacTokenInterceptor;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.TokenProvider;
import org.web3soft.commons.auth.token.hmac.HmacTokenProvider;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass({HmacTokenInterceptor.class})
@ConditionalOnProperty(prefix = "web3soft.auth.token", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties({AuthProperties.class})
public class HmacTokenAutoConfiguration
        implements WebMvcConfigurer, ApplicationContextAware {
    private static final String HMAC_TOKEN_INTERCEPTOR_BEAN_NAME = "hmacTokenInterceptor";
    private final AuthProperties authProperties;
    private final TokenConfig tokenConfig;
    private final TokenCryptoProvider cryptoProvider;
    private final TokenProvider tokenProvider;
    private final SessionService<TokenUserInfo> sessionService;
    private ApplicationContext applicationContext;

    public HmacTokenAutoConfiguration(final AuthProperties authProperties,
                                      final TokenConfig tokenConfig,
                                      final TokenCryptoProvider cryptoProvider,
                                      final TokenProvider tokenProvider,
                                      final SessionService<TokenUserInfo> sessionService) {
        this.authProperties = authProperties;
        this.tokenConfig = tokenConfig;
        this.cryptoProvider = cryptoProvider;
        this.tokenProvider = tokenProvider;
        this.sessionService = sessionService;
    }

    @Primary
    @Bean
    public TokenConfig hmacTokenConfig() {
        final AuthProperties.Token token = this.authProperties.getToken();
        final TokenConfig tokenConfig = new TokenConfig();
        tokenConfig.setRequestHeaderName(token.getRequestHeaderName());
        tokenConfig.setCryptoKey(token.getCryptoKey());
        tokenConfig.setSecret(token.getSecret());
        tokenConfig.setValidateIpAndDevice(token.isValidateIpAndDevice());
        return tokenConfig;
    }

    @Primary
    @Bean
    public TokenCryptoProvider tokenCryptoProvider() {
        return new AesTokenCryptoProvider();
    }

    @Primary
    @Bean
    public TokenProvider hmacTokenProvider() {
        return new HmacTokenProvider(this.tokenConfig, this.cryptoProvider, this.sessionService);
    }

    @Primary
    @Bean
    public HmacTokenInterceptor hmacTokenInterceptor() {
        return new HmacTokenInterceptor(this.tokenProvider, this.sessionService);
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        if (this.applicationContext.containsBean(HmacTokenAutoConfiguration.HMAC_TOKEN_INTERCEPTOR_BEAN_NAME)) {
            final String[] includeUrlPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.authProperties.getToken().getIncludeUrlPatterns()), String.class);
            final String[] excludePathPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.authProperties.getToken().getExcludePathPatterns()), String.class);
            registry.addInterceptor(this.hmacTokenInterceptor())
                    .addPathPatterns(includeUrlPatterns)
                    .excludePathPatterns(excludePathPatterns);
        }
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
