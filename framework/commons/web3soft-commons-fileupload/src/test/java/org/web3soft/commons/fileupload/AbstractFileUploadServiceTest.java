package org.web3soft.commons.fileupload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3soft.commons.fileupload.oss.OssFileUploadService;

import java.util.UUID;

/**
 * @author  web3soft-team
 * @since 1.0.0
 */
class AbstractFileUploadServiceTest {

    private OssFileUploadService fileUploadService;

    @BeforeEach
    void setup() {
        this.fileUploadService = new OssFileUploadService(null, null);
    }

    @Test
    void getDatePath() {
        final String path = this.fileUploadService.getDatePath();
        Assertions.assertEquals("20230621", path);
    }

    @Test
    void testGetDatePath() {
        final String pattern = "yyyyMMdd";
        final String path = this.fileUploadService.getDatePath(pattern);
        Assertions.assertEquals("20230621", path);
    }

    @Test
    void getDatePathFileName() {
        final String filename = "/test123/test1.jpg";
        final String datePathFileName = this.fileUploadService.getDatePathFileName(filename);
        Assertions.assertEquals("20230621/test123/test1.jpg", datePathFileName);
    }

    @Test
    void testGetDatePathFileName() {
        final String pattern = "yyyyMMdd";
        final String filename = "/test123/test1.jpg";
        final String datePathFileName = this.fileUploadService.getDatePathFileName(filename, pattern);
        Assertions.assertEquals("20230621/test123/test1.jpg", datePathFileName);
    }

    @Test
    void getFileName() {
        final String filename = "test1.jpg";
        final String filenameWithoutExt = UUID.randomUUID().toString();
        final String newFilename = this.fileUploadService.getFileName(filename, filenameWithoutExt);
        Assertions.assertEquals(filenameWithoutExt + ".jpg", newFilename);
    }
}