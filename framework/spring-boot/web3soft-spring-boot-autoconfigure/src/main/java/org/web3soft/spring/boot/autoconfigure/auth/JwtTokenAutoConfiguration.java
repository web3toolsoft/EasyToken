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
import org.web3soft.commons.auth.config.TokenConfig;
import org.web3soft.commons.auth.crypto.AesTokenCryptoProvider;
import org.web3soft.commons.auth.crypto.TokenCryptoProvider;
import org.web3soft.commons.auth.interceptor.JwtTokenInterceptor;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.token.TokenProvider;
import org.web3soft.commons.auth.token.jwt.config.JwtConfig;
import org.web3soft.commons.auth.token.jwt.provider.JwtTokenProvider;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass({JwtTokenInterceptor.class})
@ConditionalOnProperty(prefix = "web3soft.auth.jwt", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties({AuthProperties.class})
public class JwtTokenAutoConfiguration implements WebMvcConfigurer, ApplicationContextAware {
    private static final String JWT_INTERCEPTOR_BEAN_NAME = "jwtTokenInterceptor";
    private final AuthProperties authProperties;
    private final TokenConfig tokenConfig;
    private final TokenCryptoProvider cryptoProvider;
    private final TokenProvider tokenProvider;
    private final SessionService<TokenUserInfo> sessionService;
    private ApplicationContext applicationContext;

    public JwtTokenAutoConfiguration(final AuthProperties authProperties,
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

    @Bean
    public TokenConfig jwtTokenConfig() {
        final AuthProperties.Jwt jwt = this.authProperties.getJwt();
        final JwtConfig jwtConfig = new JwtConfig();
        jwtConfig.setRequestHeaderName(jwt.getRequestHeaderName());
        jwtConfig.setCryptoKey(jwt.getCryptoKey());
        jwtConfig.setIssuer(jwt.getIssuer());
        jwtConfig.setSecret(jwt.getSecret());
        jwtConfig.setExpiration(jwt.getExpiration());
        jwtConfig.setValidateIpAndDevice(jwt.isValidateIpAndDevice());
        return jwtConfig;
    }

    @Bean
    public TokenCryptoProvider tokenCryptoProvider() {
        return new AesTokenCryptoProvider();
    }

    @Bean
    public TokenProvider jwtTokenProvider() {
        return new JwtTokenProvider(this.tokenConfig, this.cryptoProvider, this.sessionService);
    }


    @Bean
    public JwtTokenInterceptor jwtTokenInterceptor() {
        return new JwtTokenInterceptor(this.tokenProvider, this.sessionService);
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        if (this.applicationContext.containsBean(JwtTokenAutoConfiguration.JWT_INTERCEPTOR_BEAN_NAME)) {
            final String[] includeUrlPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.authProperties.getJwt().getIncludeUrlPatterns()), String.class);
            final String[] excludePathPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.authProperties.getJwt().getExcludePathPatterns()), String.class);
            registry.addInterceptor(this.jwtTokenInterceptor())
                    .addPathPatterns(includeUrlPatterns)
                    .excludePathPatterns(excludePathPatterns);
        }
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
