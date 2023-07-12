package org.web3soft.commons.fileupload.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.fileupload.AbstractFileUploadConfig;
import org.web3soft.commons.fileupload.AbstractFileUploadService;
import org.web3soft.commons.fileupload.CannedAclEnum;
import org.web3soft.commons.fileupload.FileUploadMetadata;
import org.web3soft.commons.fileupload.FileUploadResponse;
import org.web3soft.commons.fileupload.FileUploadService;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

/**
 * AWS S3 文件上传服务类
 *
 * @author web3soft-team
 */
@Slf4j
public class S3FileUploadService extends AbstractFileUploadService implements FileUploadService {
    private final AmazonS3 s3Client;

    public S3FileUploadService(final AbstractFileUploadConfig config, final AmazonS3 s3Client) {
        super(config);
        this.s3Client = s3Client;
    }
    
    @Override
    public boolean delete(final String path, final String fileName) {
        try {
            this.s3Client.deleteObject(this.config.getBucketName(), this.getKey(path, fileName));
            return true;
        } catch (final Exception ex) {
            log.error("delete oss object failure", ex);
            return false;
        }
    }

    @Override
    public String getUrl(final String path, final String fileName) {
        final URL url = this.s3Client.getUrl(this.config.getBucketName(), this.getKey(path, fileName));
        final String newUrl = this.replaceUrlScheme(url.toString());
        final String vpcBucketUrl = this.appendBucketNameBefore(this.config.getVpcEndpoint(), this.config.getBucketName());
        final String bucketDomainUrl = this.getBucketDomainUrl();
        return StringUtils.replace(newUrl, vpcBucketUrl, bucketDomainUrl);
    }

    @Override
    protected String generatePresignedUrl(final String bucketName, final String key, final Date expiration) {
        final URL url = this.s3Client.generatePresignedUrl(bucketName, key, expiration);
        return url.toString();
    }

    /**
     * @param uploadMetadata objectMetaData
     * @return ObjectMetadata
     */
    private ObjectMetadata createObjectMetadata(final FileUploadMetadata uploadMetadata) {
        if (uploadMetadata == null) {
            return null;
        }
        final ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(uploadMetadata.getContentLength());
        objectMetadata.setContentType(uploadMetadata.getContentType());
        objectMetadata.setCacheControl("max-age=" + this.config.getCacheControlMaxAge());
        return objectMetadata;
    }

    @Override
    protected <T> FileUploadResponse upload(final T fileObject, final String path, final String fileName,
                                            final CannedAclEnum acl, final FileUploadMetadata objectMeta) {
        final String key = this.getKey(path, fileName);
        final ObjectMetadata metadata = this.createObjectMetadata(objectMeta);
        final String url = Objects.isNull(metadata) ? this.getUrl(path, fileName) : this.getSignedUrl(path, fileName);
        if (fileObject instanceof final File file) {
            this.s3Client.putObject(new PutObjectRequest(this.config.getBucketName(), key, file)
                    .withMetadata(metadata)
                    .withCannedAcl(CannedAccessControlList.valueOf(acl.toString()))
            );
        } else if (fileObject instanceof final InputStream inputStream) {
            this.s3Client.putObject(new PutObjectRequest(this.config.getBucketName(), key, inputStream, metadata)
                    .withCannedAcl(CannedAccessControlList.valueOf(acl.toString()))
            );
        }
        return FileUploadResponse.builder()
                .key(key)
                .url(url)
                .fileName(fileName)
                .build();
    }
}
