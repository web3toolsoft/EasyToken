package org.web3soft.commons.fileupload;

import org.apache.commons.lang3.StringUtils;

/**
 * @author web3soft-team
 */
public abstract class AbstractFileUploadConfig {
    private final static String HTTP_SCHEME = "https";
    private String vpcEndpoint;
    private String endpoint;
    private String domain;
    private String bucketName;
    private String defaultPath;
    private String urlScheme = HTTP_SCHEME;
    private long expiredTime = 3600 * 5L;
    private long cacheControlMaxAge = 3600 * 24L;

    /**
     * 获取内网endpoint地址
     * (如：<a href="https://oss-cn-hongkong-internal.aliyuncs.com">...</a>)
     *
     * @return vpc endpoint
     */
    public String getVpcEndpoint() {
        return this.vpcEndpoint;
    }

    /**
     * 设置内网endpoint地址
     *
     * @param vpcEndpoint 内网 endpoint
     */
    public void setVpcEndpoint(final String vpcEndpoint) {
        this.vpcEndpoint = vpcEndpoint;
    }

    /**
     * 获取具体上传的外网endpoint地址(如：<a href="https://oss-cn-hongkong.aliyuncs.com">...</a>）
     *
     * @return 外网endpoint
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * 获取外网endpoint地址
     *
     * @param endpoint 外网endpoint地址
     */
    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 上传文件自定义域名(如:<a href="https://image.example.com">...</a>)
     * 如不设置则为endpoint地址
     *
     * @return 上传文件自定义域名
     */
    public String getDomain() {
        return this.domain;
    }

    /**
     * 设置上传文件自定义域名(如:<a href="https://image.example.com">...</a>)
     * 如不设置则为endpoint地址
     *
     * @param domain 上传文件自定义域名
     */
    public void setDomain(final String domain) {
        this.domain = domain;
    }

    /**
     * @return bucketName
     */
    public String getBucketName() {
        return this.bucketName;
    }

    /**
     * @param bucketName bucket name
     */
    public void setBucketName(final String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * @return path
     */
    String getDefaultPath() {
        return this.defaultPath;
    }

    /**
     * @param defaultPath 默认上传路径
     */
    public void setDefaultPath(final String defaultPath) {
        this.defaultPath = defaultPath;
    }

    /**
     * 获取图片链接的有效期
     *
     * @return expired time
     */
    long getExpiredTime() {
        return this.expiredTime;
    }

    /**
     * 设置文件链接的有效期
     *
     * @param expiredTime
     */
    public void setExpiredTime(final long expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 设置文件缓存时间(默认24小时)
     *
     * @return cacheControlMaxAge
     */
    public long getCacheControlMaxAge() {
        return this.cacheControlMaxAge;
    }

    /**
     * 获取文件缓存时间(默认24小时)
     *
     * @param cacheControlMaxAge
     */
    public void setCacheControlMaxAge(final long cacheControlMaxAge) {
        this.cacheControlMaxAge = cacheControlMaxAge;
    }

    /**
     * @return urlScheme
     */
    String getUrlScheme() {
        if (StringUtils.isBlank(this.urlScheme)) {
            return AbstractFileUploadConfig.HTTP_SCHEME;
        }
        return this.urlScheme;
    }

    /**
     * @param urlScheme http|https
     */
    public void setUrlScheme(final String urlScheme) {
        this.urlScheme = urlScheme;
    }
}
