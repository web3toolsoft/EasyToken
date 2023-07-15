package org.web3soft.spring.boot.autoconfigure.security;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.web3soft.commons.support.codec.CodecConfig;
import org.web3soft.commons.support.codec.DigestCryptService;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@EnableConfigurationProperties({SecurityProperties.class})
@ConditionalOnClass(DigestCryptService.class)
public class DigestCryptAutoConfiguration {
    private final SecurityProperties securityProperties;

    public DigestCryptAutoConfiguration(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean("digestCryptService")
    public DigestCryptService digestCryptService() {
        final CodecConfig config = CodecConfig.builder()
                .accessKey(CodecConfig.AccessKey.builder()
                        .issuer(this.securityProperties.getAccessKey().getIssuer())
                        .keyId(this.securityProperties.getAccessKey().getKeyId())
                        .keySecret(this.securityProperties.getAccessKey().getKeySecret())
                        .expired(this.securityProperties.getAccessKey().getExpired())
                        .signMethod(CodecConfig.AccessKey.SignMethod.builder()
                                .enabled(this.securityProperties.getAccessKey().getSignMethod().isEnabled())
                                .expired(this.securityProperties.getAccessKey().getSignMethod().getExpired())
                                .build())
                        .build())
                .cryptoKey(CodecConfig.CryptoKey.builder()
                        .issuer(this.securityProperties.getCryptoKey().getIssuer())
                        .keyId(this.securityProperties.getCryptoKey().getKeyId())
                        .expired(this.securityProperties.getCryptoKey().getExpired())
                        .algorithm(this.securityProperties.getCryptoKey().getAlgorithm())
                        .build())
                .build();
        return new DigestCryptService(config);
    }
}
