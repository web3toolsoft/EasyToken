package org.web3soft.spring.boot.autoconfigure.fileupload;

/**
 * @author web3soft-team
 */
public abstract class AbstractFileUploadProperties {
    protected String vpcEndpoint;
    protected String endpoint;
    protected String region;
    protected String accessKeyId;
    protected String accessKeySecret;
    protected String bucketName;
    protected String path = "http";
    protected String urlScheme;
    protected long expiredTime = 1000 * 60 * 60 * 5L + 1000 * 60 * 30L;
    protected long cacheControlMaxAge = 60 * 60 * 24;

    /**
     * 获取vpc oss or s3 endpoint地址
     * (如：<a href="http://vpc-100.s3-cn-hangzhou.aliyuncs.com">...</a>)
     *
     * @return vpc endpoint
     */
    public String getVpcEndpoint() {
        return this.vpcEndpoint;
    }

    /**
     * 设置vpc oss or s3 endpoint地址
     *
     * @param vpcEndpoint vpc endpoint
     */
    public void setVpcEndpoint(final String vpcEndpoint) {
        this.vpcEndpoint = vpcEndpoint;
    }

    /**
     * 获取具体上传的oss or s3 endpoint地址(如：<a href="http://s3-cn-hangzhou.aliyuncs.com">...</a>）
     *
     * @return oss or s3 endpoint
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * 获取oss or s3 endpoint地址 (ap-northeast-1)
     *
     * @param endpoint
     */
    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 获取具体上传的oss or s3  Region
     *
     * @return region （如:ap-northeast-1)
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * 设置具体上传的oss or s3  Region
     *
     * @param region 如:ap-northeast-1)
     */
    public void setRegion(final String region) {
        this.region = region;
    }

    /**
     * @return
     */
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    /**
     * @param accessKeyId
     */
    public void setAccessKeyId(final String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    /**
     * @return
     */
    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    /**
     * @param accessKeySecret
     */
    public void setAccessKeySecret(final String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    /**
     * @return
     */
    public String getBucketName() {
        return this.bucketName;
    }

    /**
     * @param bucketName
     */
    public void setBucketName(final String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * @return
     */
    public String getPath() {
        return this.path;
    }

    /**
     * @param path
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * 获取图片链接的有效期
     *
     * @return
     */
    public long getExpiredTime() {
        return this.expiredTime;
    }

    /**
     * 设置图片链接的有效期
     *
     * @param expiredTime
     */
    public void setExpiredTime(final long expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 设置图片缓存时间(默认24小时)
     *
     * @return
     */
    public long getCacheControlMaxAge() {
        return this.cacheControlMaxAge;
    }

    /**
     * 获取图片缓存时间(默认24小时)
     *
     * @param cacheControlMaxAge
     */
    public void setCacheControlMaxAge(final long cacheControlMaxAge) {
        this.cacheControlMaxAge = cacheControlMaxAge;
    }

    /**
     * @return
     */
    public String getUrlScheme() {
        return this.urlScheme;
    }

    /**
     * @param urlScheme
     */
    public void setUrlScheme(final String urlScheme) {
        this.urlScheme = urlScheme;
    }

}
