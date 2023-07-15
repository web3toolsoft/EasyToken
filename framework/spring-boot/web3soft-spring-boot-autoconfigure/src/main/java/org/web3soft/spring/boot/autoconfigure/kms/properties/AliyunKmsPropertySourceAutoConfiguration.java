package org.web3soft.spring.boot.autoconfigure.kms.properties;

import com.aliyuncs.DefaultAcsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.web3soft.commons.kms.client.AliyunKmsClient;
import org.web3soft.commons.kms.client.KmsClientFactory;
import org.web3soft.commons.kms.client.config.KmsClientConfiger;
import org.web3soft.commons.kms.client.config.KmsConfigServicePropertySourceLocator;
import org.web3soft.spring.boot.autoconfigure.kms.KmsProperties;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnProperty(name = "web3soft.kms.provider", havingValue = "aliyun")
@ConditionalOnClass({DefaultAcsClient.class, KmsConfigServicePropertySourceLocator.class})
@EnableConfigurationProperties(KmsProperties.class)
public class AliyunKmsPropertySourceAutoConfiguration {

    private final KmsProperties.KmsConfig config;
    @Value("${spring.application.name}")
    private String applicationName;

    public AliyunKmsPropertySourceAutoConfiguration(final KmsProperties properties) {
        this.config = properties.getAliyun();
    }


    @Bean
    @Primary
    @Order(-1)
    @ConditionalOnProperty("spring.cloud.config.enabled")
    public PropertySourceLocator propertySourceLocator(final ConfigClientProperties defaultProperties) {
        final AliyunKmsClient kmsClient = KmsClientFactory.createAliyunKmsClient(
                KmsClientConfiger.createAliyunKmsClientConfig(
                        this.config.getVpcEndpoint(),
                        this.config.getEndpoint(),
                        this.config.getRegion(),
                        this.config.getAccessKeyId(),
                        this.config.getAccessKeySecret(),
                        this.config.getKeyId())
        );
        return new KmsConfigServicePropertySourceLocator(defaultProperties, this.applicationName, kmsClient);
    }
}
