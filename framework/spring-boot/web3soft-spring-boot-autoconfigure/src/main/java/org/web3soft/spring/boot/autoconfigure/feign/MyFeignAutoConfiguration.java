package org.web3soft.spring.boot.autoconfigure.feign;

import feign.Feign;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.web3soft.commons.support.codec.DigestCryptService;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass(Feign.class)
@EnableConfigurationProperties(MyFeignProperties.class)
public class MyFeignAutoConfiguration {
    
    private final DigestCryptService digestCryptService;

    public MyFeignAutoConfiguration(final DigestCryptService digestCryptService) {
        this.digestCryptService = digestCryptService;
    }

    @Bean
    public RequestInterceptor headerRequestInterceptor() {
        return new HeaderRequestInterceptor(this.digestCryptService);
    }
}
