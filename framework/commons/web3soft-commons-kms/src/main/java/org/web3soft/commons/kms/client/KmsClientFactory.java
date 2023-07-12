package org.web3soft.commons.kms.client;

import org.web3soft.commons.kms.client.config.KmsClientConfig;

/**
 * @author web3soft-team
 */
public class KmsClientFactory {

    public static AliyunKmsClient createAliyunKmsClient(final KmsClientConfig config) {
        return new AliyunKmsClient(
                config.getVpcEndpoint(),
                config.getRegion(),
                config.getAccessKeyId(),
                config.getAccessKeySecret(),
                config.getKeyId()
        );
    }

    public static AwsKmsClient createAwsKmsClient(final KmsClientConfig config) {
        return new AwsKmsClient(
                config.getEndpoint(),
                config.getRegion(),
                config.getAccessKeyId(),
                config.getAccessKeySecret(),
                config.getKeyId()
        );
    }
}
