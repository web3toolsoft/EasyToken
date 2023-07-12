package org.web3soft.commons.kms.client.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @author web3soft-team
 */
public class KmsClientConfiger {

    private static final String AWS = "aws";
    private static final String ALIYUN = "aliyun";

    public static KmsClientConfig createAliyunKmsClientConfig(final String vpcEndpoint, final String endpoint, final String region,
                                                              final String accessKeyId, final String accessKeySecret, final String keyId) {
        if (StringUtils.isAnyBlank(accessKeyId, accessKeySecret, keyId)) {
            return loadKmsConfigFromFile(ALIYUN);
        }
        return createKmsClientConfig(vpcEndpoint, endpoint, region, accessKeyId, accessKeySecret, keyId);
    }

    public static KmsClientConfig createAwsKmsClientConfig(final String vpcEndpoint, final String endpoint, final String region,
                                                           final String accessKeyId, final String accessKeySecret, final String keyId) {
        if (StringUtils.isAnyBlank(accessKeyId, accessKeySecret, keyId)) {
            return loadKmsConfigFromFile(AWS);
        }
        return createKmsClientConfig(vpcEndpoint, endpoint, region, accessKeyId, accessKeySecret, keyId);
    }

    private static KmsClientConfig loadKmsConfigFromFile(final String name) {
        final String path = "keystore/kms-secret.key";
        final File file = new File(path);
        if (!file.exists()) {
            if (StringUtils.equalsAnyIgnoreCase(AWS, name)) {
                return createDefaultAwsKmsClientConfig();
            }
            return createDefaultAliyunKmsClientConfig();
        }

        try {
            final Configurations configurations = new Configurations();
            FileBasedConfigurationBuilder.setDefaultEncoding(PropertiesConfiguration.class, "UTF-8");
            final Configuration config = configurations.properties(file);
            return createKmsClientConfig(
                    config.getString("vpcEndpoint"),
                    config.getString("endpoint"),
                    config.getString("region"),
                    config.getString("accessKeyId"),
                    config.getString("accessKeySecret"),
                    config.getString("keyId")
            );
        } catch (final Exception e) {
            throw new RuntimeException("load kms config file error", e);
        }
    }

    private static KmsClientConfig createDefaultAliyunKmsClientConfig() {
        return createAliyunKmsClientConfig(
                "kms.cn-hongkong.aliyuncs.com",
                "",
                "cn-hongkong",
                "default",
                "default",
                "default");
    }

    private static KmsClientConfig createDefaultAwsKmsClientConfig() {
        return createAwsKmsClientConfig(
                "https://kms.ap-southeast-1.amazonaws.com",
                "https://kms.ap-southeast-1.amazonaws.com",
                "ap-southeast-1",
                "default",
                "default",
                "default");
    }

    private static KmsClientConfig createKmsClientConfig(final String vpcEndpoint, final String endpoint, final String region,
                                                         final String accessKeyId, final String accessKeySecret, final String keyId) {
        final KmsClientConfig kmsConfig = new KmsClientConfig();
        kmsConfig.setVpcEndpoint(StringUtils.defaultString(vpcEndpoint));
        kmsConfig.setEndpoint(StringUtils.defaultString(endpoint));
        kmsConfig.setRegion(StringUtils.defaultString(region));
        kmsConfig.setAccessKeyId(StringUtils.defaultString(accessKeyId));
        kmsConfig.setAccessKeySecret(StringUtils.defaultString(accessKeySecret));
        kmsConfig.setKeyId(StringUtils.defaultString(keyId));
        return kmsConfig;
    }
}
