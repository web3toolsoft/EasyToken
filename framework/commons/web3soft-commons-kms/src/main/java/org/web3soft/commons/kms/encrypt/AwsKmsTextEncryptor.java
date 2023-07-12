package org.web3soft.commons.kms.encrypt;

import org.web3soft.commons.kms.client.AwsKmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.util.Assert;

/**
 * This {@link TextEncryptor} uses AWS KMS (Key Management Service) to encrypt / decrypt strings. Encoded cipher strings
 * are represented in Base64 format, to have a nicer string representation (only alphanumeric chars), that can be
 * easily used as values in property files.
 *
 * @author linus
 */
@Slf4j
public class AwsKmsTextEncryptor implements TextEncryptor {

    private final AwsKmsClient kmsClient;

    /**
     * @param kmsClient The AWS KMS client
     */
    public AwsKmsTextEncryptor(final AwsKmsClient kmsClient) {
        Assert.notNull(kmsClient, "KMS client must not be null");
        this.kmsClient = kmsClient;
    }

    @Override
    public String encrypt(final String text) {
        return this.kmsClient.encryptAsBase64(text);
    }

    @Override
    public String decrypt(final String encryptedText) {
        return this.kmsClient.decryptAsBase64(encryptedText);
    }
}
