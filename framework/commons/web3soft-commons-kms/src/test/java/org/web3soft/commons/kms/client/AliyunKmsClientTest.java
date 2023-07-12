package org.web3soft.commons.kms.client;

import org.web3soft.commons.kms.client.config.KmsClientConfig;
import org.web3soft.commons.kms.client.config.KmsClientConfiger;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class AliyunKmsClientTest {
    private KmsClientConfig kmsClientConfig;

    @BeforeEach
    public void setup() {
        this.kmsClientConfig = KmsClientConfiger.createAliyunKmsClientConfig(
                "kms.ap-southeast-1.aliyuncs.com",
                "",
                "ap-southeast-1",
                "LTAI5t6Hs5WT3z1BxZu9ikhF",
                "qAr766k0KjQufMdiSuAhn4roXuzCMp",
                "e5b295ca-0b5c-4384-a13f-90b47954d944");
    }

    @Test
    public void decryptTest() {
        final String[] cipherBlobList = {
                "NTU5ZmNkOTItMTdlNC00NmQ5LTg1NDQtMjc4OWYyN2RhMzRkMD+sfYeRDUMaTowRxYvJMziv2yneBYi7zdLPvl7AdfTRsJsu+r7uEF4="
        };
        final AliyunKmsClient kmsClient = KmsClientFactory.createAliyunKmsClient(this.kmsClientConfig);
        for (final String cipherBlob : cipherBlobList) {
            System.out.printf("\nplainText:%s\n", kmsClient.decryptAsString(cipherBlob));
        }
    }

    @Test
    public void encryptTest() {
        final String[] plaintexts = {
                ""
        };
        final AliyunKmsClient kmsClient = KmsClientFactory.createAliyunKmsClient(this.kmsClientConfig);
        for (final String plaintext : plaintexts) {
            System.out.printf("\ncipherText:%s\n", kmsClient.encryptAsString(plaintext));
        }
        //Assert.assertThat(text, IsEqual.equalTo(""));
    }
}