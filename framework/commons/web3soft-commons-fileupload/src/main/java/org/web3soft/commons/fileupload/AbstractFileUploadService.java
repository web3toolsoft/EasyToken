package org.web3soft.commons.fileupload;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * @author web3soft-team
 */
public abstract class AbstractFileUploadService implements FileUploadService {
    protected final AbstractFileUploadConfig config;

    protected AbstractFileUploadService(final AbstractFileUploadConfig config) {
        this.config = config;
    }

    @Override
    public FileUploadResponse uploadFile(final File file, final String fileName) {
        return this.uploadFile(file, "", fileName);
    }

    @Override
    public FileUploadResponse uploadFile(final InputStream inputStream, final String fileName) {
        return this.uploadFile(inputStream, "", fileName);
    }

    @Override
    public FileUploadResponse uploadFile(final File file, final String fileName, final CannedAclEnum acl) {
        return this.uploadFile(file, "", fileName, acl);
    }

    @Override
    public FileUploadResponse uploadFile(final InputStream inputStream, final String fileName, final CannedAclEnum acl) {
        return this.uploadFile(inputStream, "", fileName, acl);
    }

    @Override
    public FileUploadResponse uploadFile(final File file, final String path, final String fileName) {
        return this.uploadFile(file, path, fileName, CannedAclEnum.Default);
    }

    @Override
    public FileUploadResponse uploadFile(final InputStream inputStream, final String path, final String fileName) {
        return this.uploadFile(inputStream, path, fileName, CannedAclEnum.Default);
    }

    @Override
    public FileUploadResponse uploadFile(final File file, final String fileName, final FileUploadMetadata objectMeta) {
        return this.uploadFile(file, "", fileName, objectMeta, CannedAclEnum.Default);
    }

    @Override
    public FileUploadResponse uploadFile(final InputStream inputStream, final String fileName, final FileUploadMetadata objectMeta) {
        return this.uploadFile(inputStream, "", fileName, objectMeta, CannedAclEnum.Default);
    }

    @Override
    public FileUploadResponse uploadFile(final File file, final String path, final String fileName, final CannedAclEnum acl) {
        return this.upload(file, path, fileName, acl, null);
    }

    @Override
    public FileUploadResponse uploadFile(final InputStream inputStream, final String path, final String fileName, final CannedAclEnum acl) {
        return this.upload(inputStream, path, fileName, acl, null);
    }

    @Override
    public FileUploadResponse uploadFile(final File file, final String path, final String fileName,
                                         final FileUploadMetadata objectMeta, final CannedAclEnum acl) {
        return this.upload(file, path, fileName, acl, objectMeta);
    }

    @Override
    public FileUploadResponse uploadFile(final InputStream inputStream, final String path, final String fileName,
                                         final FileUploadMetadata objectMeta, final CannedAclEnum acl) {
        return this.upload(inputStream, path, fileName, acl, objectMeta);
    }
    
    @Override
    public boolean delete(final String fileName) {
        return this.delete("", fileName);
    }

    @Override
    public String getUrl(final String fileName) {
        return this.getUrl("", fileName);
    }

    @Override
    public String getUrl(final String path, final String fileName) {
        return StringUtils.join(StringUtils.appendIfMissing(this.getBucketDomainUrl(), "/"), this.getKey(path, fileName));
    }

    @Override
    public String getSignedUrl(final String fileName) {
        return this.getSignedUrl(this.config.getDefaultPath(), fileName);
    }

    @Override
    public String getSignedUrl(final String path, final String fileName) {
        final String key = this.getKey(path, fileName);
        final Date expiration = new Date(System.currentTimeMillis() + this.config.getExpiredTime() * 1000);
        final String signedUrl = this.generatePresignedUrl(key, expiration);
        final String newUrl = this.replaceUrlScheme(signedUrl);
        final String vpcBucketUrl = this.appendBucketNameBefore(this.config.getVpcEndpoint(), this.config.getBucketName());
        final String bucketDomainUrl = this.getBucketDomainUrl();
        return StringUtils.replace(newUrl, vpcBucketUrl, bucketDomainUrl);
    }

    @Override
    public String getKey(final String fileName) {
        return this.getKey("", fileName);
    }

    @Override
    public String getKey(final String path, final String fileName) {
        final String path1 = StringUtils.defaultIfBlank(path, this.config.getDefaultPath());
        final String stripFileName = StringUtils.removeStart(fileName, "/");
        final String stripPath = StringUtils.removeStart(StringUtils.defaultString(path1), "/");
        return StringUtils.join(StringUtils.appendIfMissing(stripPath, "/"), stripFileName);
    }

    @Override
    public String getDatePath() {
        return this.getDatePath("");
    }

    @Override
    public String getDatePath(final String pattern) {
        final LocalDateTime dateTime = LocalDateTime.now();
        final DateTimeFormatter df = DateTimeFormatter.ofPattern(StringUtils.defaultIfBlank(pattern, "yyyyMMdd"));
        return df.format(dateTime);
    }

    @Override
    public String getDatePathFileName(final String fileName) {
        return this.getDatePathFileName(fileName, "");
    }

    @Override
    public String getDatePathFileName(final String fileName, final String pattern) {
        final String path = this.getDatePath(pattern);
        return String.join("/", path, StringUtils.removeStart(fileName, "/"));
    }

    @Override
    public String getFileName(final String originalFileName) {
        final String newFileName = UUID.randomUUID().toString();
        return this.getFileName(originalFileName, newFileName);
    }

    @Override
    public String getFileName(final String originalFileName, final String newFileName) {
        final String ext = StringUtils.substringAfterLast(originalFileName, ".");
        return String.join(".", newFileName, ext);
    }

    protected String getBucketDomainUrl() {
        final String bucketUrl = this.appendBucketNameBefore(this.config.getEndpoint(), this.config.getBucketName());
        final String bucketDomainUrl = StringUtils.defaultIfBlank(this.config.getDomain(), bucketUrl);
        return StringUtils.removeEnd(bucketDomainUrl, "/");
    }

    /**
     * url scheme后加入bucket name
     *
     * @param url        url地址
     * @param bucketName 桶名
     * @return 替换后的url
     */
    protected String appendBucketNameBefore(final String url, final String bucketName) {
        final String newUrl = this.replaceUrlScheme(url);
        final String regex = "^(" + this.config.getUrlScheme() + "://)";
        return RegExUtils.replacePattern(newUrl, regex, "$1" + bucketName + ".");
    }

    /**
     * 替换url scheme
     *
     * @param url url地址
     * @return 替换后的url
     */
    protected String replaceUrlScheme(final String url) {
        return RegExUtils.replacePattern(url, "^(http[s]?://)", this.config.getUrlScheme() + "://");
    }

    /**
     * 生成带私有签名文件url地址
     *
     * @param key        存储key
     * @param expiration 过期时间
     * @return 私有签名文件url地址
     */
    protected String generatePresignedUrl(final String key, final Date expiration) {
        return this.generatePresignedUrl(this.config.getBucketName(), key, expiration);
    }

    /**
     * 生成带私有签名文件url地址
     *
     * @param bucketName 桶名称
     * @param key        存储key
     * @param expiration 过期时间
     * @return 私有签名文件url地址
     */
    protected abstract String generatePresignedUrl(String bucketName, String key, Date expiration);

    /**
     * @param fileObject
     * @param path
     * @param fileName
     * @param acl
     * @param objectMeta
     * @param <T>
     * @return
     */
    protected abstract <T> FileUploadResponse upload(T fileObject, String path, String fileName, CannedAclEnum acl, FileUploadMetadata objectMeta);
}
