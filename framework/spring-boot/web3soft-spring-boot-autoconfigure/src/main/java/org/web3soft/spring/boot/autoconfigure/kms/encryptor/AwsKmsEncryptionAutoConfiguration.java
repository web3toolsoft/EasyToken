package org.web3soft.spring.boot.autoconfigure.kms.encryptor;

import com.amazonaws.services.kms.AWSKMS;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.web3soft.commons.kms.client.AwsKmsClient;
import org.web3soft.commons.kms.client.KmsClientFactory;
import org.web3soft.commons.kms.client.config.KmsClientConfiger;
import org.web3soft.commons.kms.encrypt.AwsKmsTextEncryptor;
import org.web3soft.spring.boot.autoconfigure.kms.KmsProperties;

/**
 * This config must be applied to the bootstrap context, which is done by META-INF/spring.factories.<br/>
 * The properties here can be configured in bootstrap.[yml|xml|properties], but not in application.[yml]xml|properties]
 *
 * @author linus
 */
@AutoConfiguration
@ConditionalOnProperty(name = "web3soft.kms.provider", havingValue = "aws")
@ConditionalOnClass({AWSKMS.class, AwsKmsTextEncryptor.class})
@EnableConfigurationProperties(KmsProperties.class)
public class AwsKmsEncryptionAutoConfiguration {
    private final KmsProperties.KmsConfig config;

    public AwsKmsEncryptionAutoConfiguration(final KmsProperties properties) {
        this.config = properties.getAws();
    }

    @Bean
    public AwsKmsTextEncryptor awsKmsTextEncryptor() {
        return new AwsKmsTextEncryptor(this.awsKmsClient());
    }

    @Bean
    public AwsKmsClient awsKmsClient() {
        return KmsClientFactory.createAwsKmsClient(
                KmsClientConfiger.createAwsKmsClientConfig(
                        this.config.getVpcEndpoint(),
                        this.config.getEndpoint(),
                        this.config.getRegion(),
                        this.config.getAccessKeyId(),
                        this.config.getAccessKeySecret(),
                        this.config.getKeyId())
        );
    }
}
