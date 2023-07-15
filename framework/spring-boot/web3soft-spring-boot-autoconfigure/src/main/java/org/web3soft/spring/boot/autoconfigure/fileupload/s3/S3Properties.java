package org.web3soft.spring.boot.autoconfigure.fileupload.s3;

import com.amazonaws.ClientConfiguration;
import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.web3soft.spring.boot.autoconfigure.fileupload.AbstractFileUploadClientConfig;
import org.web3soft.spring.boot.autoconfigure.fileupload.AbstractFileUploadProperties;

import java.util.Map;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.fileupload.s3")
public class S3Properties extends AbstractFileUploadProperties {
    /**
     * S3Client配置项
     * 该配置项为(可选)
     * oss client config
     */
    @NestedConfigurationProperty
    private ClientConfiguration config;

    /**
     * S3文件上传client配置项
     * 如果有多个client需要配置，则启用该选项，否则不需要使用
     * 该配置项为(可选)
     */
    @NestedConfigurationProperty
    private Map<String, S3FileUploadClientConfig> clients = Maps.newHashMap();

    /**
     * 获取当前S3Client配置项
     *
     * @return ClientConfiguration
     * @see ClientConfiguration
     */
    public ClientConfiguration getConfig() {
        return this.config;
    }

    /**
     * 设置当前S3Client配置项
     *
     * @param config S3Client的配置项
     * @see ClientConfiguration
     */
    public void setConfig(final ClientConfiguration config) {
        this.config = config;
    }

    /**
     * 获取其他S3Client配置项
     *
     * @return @see S3ClientConfig
     */
    public Map<String, S3FileUploadClientConfig> getClients() {
        return this.clients;
    }

    /**
     * 设置其他S3Client配置项
     */
    public void setClients(final Map<String, S3FileUploadClientConfig> clients) {
        this.clients = clients;
    }

    public static class S3FileUploadClientConfig extends AbstractFileUploadClientConfig {
        private ClientConfiguration config;

        public ClientConfiguration getConfig() {
            return this.config;
        }

        public void setConfig(final ClientConfiguration config) {
            this.config = config;
        }
    }
}
