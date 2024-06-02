package org.web3soft.spring.boot.autoconfigure.fileupload;

/**
 * @author web3soft-team
 * @since 1.0.0
 */
public class AbstractFileUploadClientConfig {
    protected String vpcEndpoint;
    protected String endpoint;
    protected String accessKeyId;
    protected String accessKeySecret;
    protected String bucketName;
    protected String defaultPath;
    protected String urlScheme = "https";
    protected long expiredTime = 3600 * 5L;
    protected long cacheControlMaxAge = 3600 * 24L;

    public String getVpcEndpoint() {
        return this.vpcEndpoint;
    }

    public void setVpcEndpoint(final String vpcEndpoint) {
        this.vpcEndpoint = vpcEndpoint;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
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

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(final String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDefaultPath() {
        return this.defaultPath;
    }

    public void setDefaultPath(final String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public String getUrlScheme() {
        return this.urlScheme;
    }

    public void setUrlScheme(final String urlScheme) {
        this.urlScheme = urlScheme;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(final long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public long getCacheControlMaxAge() {
        return this.cacheControlMaxAge;
    }

    public void setCacheControlMaxAge(final long cacheControlMaxAge) {
        this.cacheControlMaxAge = cacheControlMaxAge;
    }
}
