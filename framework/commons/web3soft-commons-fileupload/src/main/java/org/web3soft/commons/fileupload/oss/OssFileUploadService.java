package org.web3soft.commons.fileupload.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
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
 * Aliyun OSS 文件上传服务类
 *
 * @author web3soft-team
 */
@Slf4j
public class OssFileUploadService extends AbstractFileUploadService implements FileUploadService {
    private final OSSClient ossClient;

    public OssFileUploadService(final AbstractFileUploadConfig config, final OSSClient ossClient) {
        super(config);
        this.ossClient = ossClient;
    }

    @Override
    public boolean delete(final String path, final String fileName) {
        try {
            this.ossClient.deleteObject(this.config.getBucketName(), this.getKey(path, fileName));
            return true;
        } catch (final Exception ex) {
            log.error("delete oss object failure", ex);
            return false;
        }
    }

    @Override
    protected String generatePresignedUrl(final String bucketName, final String key, final Date expiration) {
        final URL url = this.ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url.toString();
    }

    /**
     * @param uploadMetadata objectMetaData
     * @return ObjectMetadata
     */
    private ObjectMetadata createObjectMetadata(final FileUploadMetadata uploadMetadata) {
        if (Objects.isNull(uploadMetadata)) {
            return null;
        }
        final ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(uploadMetadata.getContentType());
        objectMetadata.setContentLength(uploadMetadata.getContentLength());
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
            this.ossClient.putObject(new PutObjectRequest(this.config.getBucketName(), key, file, metadata));
        } else if (fileObject instanceof final InputStream inputStream) {
            this.ossClient.putObject(new PutObjectRequest(this.config.getBucketName(), key, inputStream, metadata));
        }
        this.ossClient.setObjectAcl(this.config.getBucketName(), key, CannedAccessControlList.parse(acl.toString()));
        return FileUploadResponse.builder()
                .key(key)
                .url(url)
                .fileName(fileName)
                .build();
    }
}
