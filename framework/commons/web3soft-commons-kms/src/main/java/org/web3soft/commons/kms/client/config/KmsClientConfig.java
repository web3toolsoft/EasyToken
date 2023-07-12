package org.web3soft.commons.kms.client.config;

public class KmsClientConfig {
    /**
     * ID or full ARN of the KMS key, e.g.
     * <ul>
     * <li>Aws arn:aws:kms:eu-west-1:089972051332:key/9d9fca31-54c5-4de5-ba4f-128dfb9a5031</li>
     * <li>Aliyun arn:acs:kms:${region-id}:${resource-owner-id}:key/${key-uuid} </li>
     * </ul>
     * Only needed for encryption of values.
     */
    private String keyId;

    /**
     * <strong>Optional</strong> id of the AWS region of the KMS key that was used for encryption/decryption.
     * Must match the `name` property of one enum entry of {@link com.amazonaws.regions.Regions}. If not set, the
     * <a href="http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-region-selection.html#automatically-determine-the-aws-region-from-the-environment">
     * Default Region Provider Chain</a> of the AWS SDK is used.
     */
    private String region;

    /**
     * <strong>Optional</strong> service endpoint and signing region of AWS KMS that you would like to route to.
     * If provided, must supply either a custom created VPC Endpoint or one of the KMS Endpoints listed <a href="https://docs.aws.amazon.com/general/latest/gr/rande.html#kms_region">here</a>.
     * In the event that both region and endpoint properties are both supplied, region will be ignored as region is derived from the service endpoint.
     */
    private String endpoint;

    /**
     * vpc endpoint
     */
    private String vpcEndpoint;

    /**
     * <strong>Optional</strong> access key
     */
    private String accessKeyId;

    /**
     * <strong>Optional</strong>  access secret
     */
    private String accessKeySecret;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(final String keyId) {
        this.keyId = keyId;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String getVpcEndpoint() {
        return this.vpcEndpoint;
    }

    public void setVpcEndpoint(final String vpcEndpoint) {
        this.vpcEndpoint = vpcEndpoint;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public void setAccessKeyId(final String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public void setAccessKeySecret(final String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

}
