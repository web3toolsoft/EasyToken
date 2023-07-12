package org.web3soft.commons.kms.client;

import java.nio.ByteBuffer;
import java.util.Map;

/**
 * @author web3soft-team
 */
public interface KmsClient {
    ByteBuffer encryptAsByteBuffer(final String plainText);

    ByteBuffer decryptAsByteBuffer(final String cipherBlob);

    ByteBuffer decryptAsByteBuffer(final ByteBuffer byteBuffer, Map<String, String> encryptionContext);

    String encryptAsString(final String plainText);

    String decryptAsString(final String cipherBlob);

    /**
     * 生成Base64编码的加密密文
     *
     * @param plainText 明文密码
     * @return Base64编码的加密密文
     */
    String encryptAsBase64(final String plainText);

    /**
     * 对Base64编码的密文进行解密
     *
     * @param cipherBlob Base64编码的密文
     * @return 明文密码
     */
    String decryptAsBase64(final String cipherBlob);
}
