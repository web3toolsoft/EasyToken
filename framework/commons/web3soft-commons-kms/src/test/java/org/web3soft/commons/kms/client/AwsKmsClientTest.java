package org.web3soft.commons.kms.client;

import org.web3soft.commons.kms.client.config.KmsClientConfig;
import org.web3soft.commons.kms.client.config.KmsClientConfiger;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class AwsKmsClientTest {
    private KmsClientConfig kmsClientConfig;

    @BeforeEach
    public void setup() {
        this.kmsClientConfig = KmsClientConfiger.createAwsKmsClientConfig(
                "https://kms.ap-southeast-1.amazonaws.com",
                "https://kms.ap-southeast-1.amazonaws.com",
                "ap-southeast-1",
                "AKIA4VZXAAT6ZYKBJ6VS",
                "etGySuU1DMdCRE/dexncA9qfWfPHdrWTKE2QXnHq",
                "da804957-adf4-4ee0-9b2f-d54d347d6d6c");
    }

    @Test
    public void decryptTest() {
        final String ciphertext = "";
        final AwsKmsClient kmsClient = KmsClientFactory.createAwsKmsClient(this.kmsClientConfig);
        final String text = kmsClient.decryptAsBase64(ciphertext);
        Assertions.assertThat(text).isEqualTo("Hello World!");
    }

    @Test
    public void encryptTest() {
        final String[] plaintextList = {
                ""
        };
        final AwsKmsClient kmsClient = KmsClientFactory.createAwsKmsClient(this.kmsClientConfig);
        for (int i = 0; i < plaintextList.length; i++) {
            System.out.printf("\ncipherText%s:%s\n", i, kmsClient.encryptAsBase64(plaintextList[i]));
        }
    }
}