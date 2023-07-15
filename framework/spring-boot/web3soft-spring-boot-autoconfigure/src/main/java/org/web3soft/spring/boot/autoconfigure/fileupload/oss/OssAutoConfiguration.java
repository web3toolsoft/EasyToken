package org.web3soft.spring.boot.autoconfigure.fileupload.oss;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.web3soft.commons.fileupload.oss.OssFileUploadConfig;
import org.web3soft.commons.fileupload.oss.OssFileUploadService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass(OSSClient.class)
@ConditionalOnProperty(name = "web3soft.fileupload.oss.endpoint")
@EnableConfigurationProperties(OssProperties.class)
public class OssAutoConfiguration implements BeanFactoryAware {
    private final OssProperties ossProperties;
    private final OssProperties.OssFileUploadClientConfig defaultClientConfig;
    private BeanFactory beanFactory;

    public OssAutoConfiguration(final OssProperties ossProperties) {
        this.ossProperties = ossProperties;
        this.defaultClientConfig = this.createDefaultClientConfig(ossProperties);
    }

    @Override
    public void setBeanFactory(@NonNull final BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private ClientConfiguration getClientConfiguration(final ClientConfiguration config) {
        return config == null ? new ClientConfiguration() : config;
    }

    @Bean(name = "ossClient")
    public OSSClient createDefaultOssClient() {
        return this.createOssClient(this.defaultClientConfig);
    }

    @Bean(name = "ossFileUploadService")
    public OssFileUploadService createDefaultOssFileService(@Qualifier("ossClient") final OSSClient ossClient) {
        return this.createOssFileUploadService(this.defaultClientConfig, ossClient);
    }

    @Bean
    public List<OssFileUploadService> createOssFileUploadServices() {
        final ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) this.beanFactory;
        final List<OssFileUploadService> ossFileUploadServices = new LinkedList<>();
        for (final Map.Entry<String, OssProperties.OssFileUploadClientConfig> entry : this.ossProperties.getClients().entrySet()) {
            final String clientBeanName = "oss" + entry.getKey();
            final String fileUploadServiceBeanName = clientBeanName + "FileUploadService";
            final OssProperties.OssFileUploadClientConfig clientConfig = entry.getValue();
            final OSSClient ossClient = this.createOssClient(clientConfig);
            final OssFileUploadService fileUploadService = this.createOssFileUploadService(clientConfig, ossClient);
            configurableBeanFactory.registerSingleton(clientBeanName, ossClient);
            configurableBeanFactory.registerSingleton(fileUploadServiceBeanName, fileUploadService);
            ossFileUploadServices.add(fileUploadService);
        }
        return ossFileUploadServices;
    }

    private OssProperties.OssFileUploadClientConfig createDefaultClientConfig(final OssProperties ossProperties) {
        final OssProperties.OssFileUploadClientConfig client = new OssProperties.OssFileUploadClientConfig();
        client.setAccessKeyId(ossProperties.getAccessKeyId());
        client.setAccessKeySecret(ossProperties.getAccessKeySecret());
        client.setVpcEndpoint(ossProperties.getVpcEndpoint());
        client.setEndpoint(ossProperties.getEndpoint());
        client.setBucketName(ossProperties.getBucketName());
        client.setDefaultPath(ossProperties.getPath());
        client.setConfig(ossProperties.getConfig());
        client.setUrlScheme(ossProperties.getUrlScheme());
        client.setCacheControlMaxAge(ossProperties.getCacheControlMaxAge());
        client.setExpiredTime(ossProperties.getExpiredTime());
        return client;
    }

    private OssFileUploadService createOssFileUploadService(final OssProperties.OssFileUploadClientConfig clientConfig,
                                                            final OSSClient ossClient) {
        final OssFileUploadConfig config = new OssFileUploadConfig();
        config.setVpcEndpoint(clientConfig.getVpcEndpoint());
        config.setEndpoint(clientConfig.getEndpoint());
        config.setBucketName(clientConfig.getBucketName());
        config.setCacheControlMaxAge(clientConfig.getCacheControlMaxAge());
        config.setDefaultPath(clientConfig.getDefaultPath());
        config.setExpiredTime(clientConfig.getExpiredTime());
        config.setUrlScheme(clientConfig.getUrlScheme());
        return new OssFileUploadService(config, ossClient);
    }

    private OSSClient createOssClient(final OssProperties.OssFileUploadClientConfig config) {
        final CredentialsProvider credsProvider = new DefaultCredentialProvider(config.getAccessKeyId(), config.getAccessKeySecret());
        return new OSSClient(
                config.getVpcEndpoint(),
                credsProvider,
                this.getClientConfiguration(config.getConfig())
        );
    }
}
