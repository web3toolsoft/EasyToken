package org.web3soft.spring.boot.autoconfigure.fileupload.oss;

import com.aliyun.oss.ClientConfiguration;
import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.web3soft.spring.boot.autoconfigure.fileupload.AbstractFileUploadClientConfig;
import org.web3soft.spring.boot.autoconfigure.fileupload.AbstractFileUploadProperties;

import java.util.Map;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.fileupload.oss")
public class OssProperties extends AbstractFileUploadProperties {
    /**
     * OssClient配置项
     * 该配置项为(可选)
     * oss client config
     */
    @NestedConfigurationProperty
    private ClientConfiguration config;

    /**
     * Oss文件上传client配置项
     * 如果有多个client需要配置，则启用该选项，否则不需要使用
     * 该配置项为(可选)
     */
    @NestedConfigurationProperty
    private Map<String, OssFileUploadClientConfig> clients = Maps.newHashMap();

    /**
     * 获取当前OssClient配置项
     *
     * @return @see OssClientConfig
     */
    public ClientConfiguration getConfig() {
        return this.config;
    }

    /**
     * 设置当前OssClient配置项
     *
     * @param config OssClient的配置项
     * @see ClientConfiguration
     */
    public void setConfig(final ClientConfiguration config) {
        this.config = config;
    }

    /**
     * 获取其他OssClient配置项
     *
     * @return @see OssClientConfig
     */
    public Map<String, OssFileUploadClientConfig> getClients() {
        return this.clients;
    }

    /**
     * 设置其他OssClient配置项
     */
    public void setClients(final Map<String, OssFileUploadClientConfig> clients) {
        this.clients = clients;
    }

    public static class OssFileUploadClientConfig extends AbstractFileUploadClientConfig {
        private ClientConfiguration config;

        public ClientConfiguration getConfig() {
            return this.config;
        }

        public void setConfig(final ClientConfiguration config) {
            this.config = config;
        }
    }
}
