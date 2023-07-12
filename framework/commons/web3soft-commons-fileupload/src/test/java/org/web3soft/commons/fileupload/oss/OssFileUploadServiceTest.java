package org.web3soft.commons.fileupload.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3soft.commons.fileupload.BaseTest;
import org.web3soft.commons.fileupload.CannedAclEnum;
import org.web3soft.commons.fileupload.FileUploadMetadata;
import org.web3soft.commons.fileupload.FileUploadResponse;

import java.io.File;
import java.nio.file.Path;

/**
 * @author web3soft-team
 * @since 1.0.0
 */
@Slf4j
public class OssFileUploadServiceTest extends BaseTest {
    private OssFileUploadConfig config;
    private OSSClient ossClient;
    private OssFileUploadService fileUploadService;

    @Override
    @BeforeEach
    public void setup() {
        super.setup();
        this.config = new OssFileUploadConfig();
        //prod:https://oss-cn-hongkong-internal.aliyuncs.com
        this.config.setVpcEndpoint("https://oss-cn-hongkong.aliyuncs.com");
        this.config.setEndpoint("https://oss-cn-hongkong.aliyuncs.com");
        this.config.setDomain("https://assets.example.com");
        this.config.setBucketName("hk-example-test");
        this.config.setDefaultPath("project");

        final CredentialsProvider credentialsProvider = new DefaultCredentialProvider(
                "",
                ""
        );
        this.ossClient = new OSSClient(this.config.getVpcEndpoint(), credentialsProvider, null);

        this.fileUploadService = new OssFileUploadService(this.config, this.ossClient);
    }

    @Test
    public void uploadFile() {
        final String filename = "1000001.jpg";
        final String pathname = "/Users/linus/workspace/docs/logo/logo/" + filename;
        log.info("filename:{}", filename);
        final FileUploadResponse response = this.fileUploadService.uploadFile(new File(pathname), filename);
        Assertions.assertEquals(filename, response.getFileName());
    }

    @Test
    public void testUploadFile() {
        final String filename = "1000002.jpg";
        final String pathname = "/Users/linus/workspace/docs/logo/logo/" + filename;
        final String path = Path.of("/test123/").toString();
        final FileUploadResponse response = this.fileUploadService.uploadFile(new File(pathname), path, filename);
        Assertions.assertEquals(filename, response.getFileName());
        Assertions.assertEquals("https://assets.testnet.pro/test123/" + filename, response.getUrl());
    }

    @Test
    public void testUploadFile1() {
        final String filename = "1000003.jpg";
        final String pathname = "/Users/linus/workspace/docs/logo/logo/" + filename;
        final FileUploadResponse response = this.fileUploadService.uploadFile(
                new File(pathname),
                "/test123/",
                filename,
                CannedAclEnum.PublicRead);
        Assertions.assertEquals(filename, response.getFileName());
        Assertions.assertEquals("https://assets.testnet.pro/test123/" + filename, response.getUrl());
    }

    @Test
    public void testUploadFile2() {
        final String filename = "1000004.jpg";
        final String pathname = "/Users/linus/workspace/docs/logo/logo/" + filename;
        final FileUploadResponse response = this.fileUploadService.uploadFile(
                new File(pathname),
                "/test123/",
                filename,
                new FileUploadMetadata(),
                CannedAclEnum.Default);
        Assertions.assertEquals(filename, response.getFileName());
        Assertions.assertEquals("https://assets.testnet.pro/test123/" + filename, response.getUrl());
    }

    @Test
    void testUploadFile3() {
    }

    @Test
    void testUploadFile4() {
    }

    @Test
    void delete() {
    }

    @Test
    void getUrl() {
    }

    @Test
    void testGetUrl() {
    }

    @Test
    void getSignedUrl() {
    }

    @Test
    void testGetSignedUrl() {
    }

    @Test
    void getKey() {
    }

    @Test
    void testGetKey() {
    }

    @Test
    void getBucketDomainUrl() {
    }

    @Test
    void appendBucketNameBefore() {
    }

    @Test
    void replaceUrlScheme() {
    }

    @Test
    void generatePresignedUrl() {
    }

    @Test
    void testUploadFile5() {
    }

    @Test
    void testUploadFile6() {
    }

    @Test
    void testUploadFile7() {
    }

    @Test
    void testUploadFile8() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testGeneratePresignedUrl() {
    }
}