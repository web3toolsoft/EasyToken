package org.web3soft.spring.boot.autoconfigure.kms.encryptor;

import com.aliyuncs.DefaultAcsClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.web3soft.commons.kms.client.AliyunKmsClient;
import org.web3soft.commons.kms.client.KmsClientFactory;
import org.web3soft.commons.kms.client.config.KmsClientConfiger;
import org.web3soft.commons.kms.encrypt.AliyunKmsTextEncryptor;
import org.web3soft.spring.boot.autoconfigure.kms.KmsProperties;

/**
 * This config must be applied to the bootstrap context, which is done by META-INF/spring.factories.<br/>
 * The properties here can be configured in bootstrap.[yml|xml|properties], but not in application.[yml]xml|properties]
 *
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnProperty(name = "web3soft.kms.provider", havingValue = "aliyun")
@ConditionalOnClass({DefaultAcsClient.class, AliyunKmsTextEncryptor.class})
@EnableConfigurationProperties(KmsProperties.class)
public class AliyunKmsEncryptionAutoConfiguration {
    private final KmsProperties.KmsConfig config;

    public AliyunKmsEncryptionAutoConfiguration(final KmsProperties properties) {
        this.config = properties.getAliyun();
    }

    @Bean
    public AliyunKmsTextEncryptor aliyunKmsTextEncryptor() {
        return new AliyunKmsTextEncryptor(this.aliyunKmsClient());
    }

    @Bean
    public AliyunKmsClient aliyunKmsClient() {
        return KmsClientFactory.createAliyunKmsClient(
                KmsClientConfiger.createAliyunKmsClientConfig(
                        this.config.getVpcEndpoint(),
                        this.config.getEndpoint(),
                        this.config.getRegion(),
                        this.config.getAccessKeyId(),
                        this.config.getAccessKeySecret(),
                        this.config.getKeyId())
        );
    }
}
