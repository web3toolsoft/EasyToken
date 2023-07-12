package org.web3soft.commons.kms.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.kms.client.util.EncryptionUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * @author web3soft-team
 */
@Slf4j
public abstract class AbstractClient implements KmsClient {
    protected final Base64.Decoder BASE64_DECODER = Base64.getDecoder();
    protected final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();

    @Override
    public String encryptAsBase64(final String plainText) {
        if (StringUtils.isBlank(plainText)) {
            return StringUtils.EMPTY;
        }
        final ByteBuffer encryptedBytes = this.encryptAsByteBuffer(plainText);
        return EncryptionUtils.extractString(ByteBuffer.wrap(this.BASE64_ENCODER.encode(encryptedBytes.array())));
    }

    @Override
    public String decryptAsBase64(final String cipherBlob) {
        if (StringUtils.isBlank(cipherBlob)) {
            return StringUtils.EMPTY;
        }
        log.debug("cipherBlob={}", cipherBlob);
        final Map<String, String> encryptionContext = EncryptionUtils.extractEncryptionContext(cipherBlob);
        final String encryptedValue = EncryptionUtils.extractEncryptedValue(cipherBlob);
        final ByteBuffer encryptedBytes = ByteBuffer.wrap(this.BASE64_DECODER.decode(encryptedValue.getBytes(StandardCharsets.UTF_8)));
        return EncryptionUtils.extractString(this.decryptAsByteBuffer(encryptedBytes, encryptionContext));
    }
}
