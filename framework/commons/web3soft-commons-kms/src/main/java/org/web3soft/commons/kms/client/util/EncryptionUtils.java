package org.web3soft.commons.kms.client.util;

import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author web3soft-team
 */
public class EncryptionUtils {
    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();

    /**
     * Extract the encryption context. For a string such as "(param1=WdfaA,param2=AZrr,param3)thisIsEncrypted",
     * the value returned would be a map with pairs of key and values, such as:
     *
     * <ul>
     * <li>key=param1,value=WdfaA</li>
     * <li>key=param2,value=AZrr</li>
     * <li>key=param3,value=</li>
     * </ul>
     *
     * <p>Keys with no value are assigned an empty string for convenience. The remaining values are Base64 encoded.</p>
     *
     * @param encryptedText the encrypted text passed by spring security
     * @return the encryption context map, without the encryption text
     */
    public static Map<String, String> extractEncryptionContext(final String encryptedText) {
        final int lower = encryptedText.indexOf('(');
        final int upper = encryptedText.indexOf(')');
        if (lower != 0 || upper < 0) {
            return Collections.emptyMap();
        }
        final Map<String, String> encryptionContext = new HashMap<>();
        final String encryptionContextText = encryptedText.substring(lower + 1, upper);
        final String[] pairs = encryptionContextText.split(",");
        for (final String pair : pairs) {
            // we must not use simply split("="), as = is a pad symbol in base64, and would be cut out...
            final String[] keyValue = pair.split("=", 2);
            if (keyValue.length == 1) {
                encryptionContext.put(keyValue[0], "");
            } else if (keyValue.length == 2) {
                encryptionContext.put(keyValue[0], new String(EncryptionUtils.BASE64_DECODER.decode(keyValue[1].trim().getBytes())));
            }
        }
        return encryptionContext;
    }

    /**
     * Extract the encrypted value. For a string such as "(param1=WdfaA,param2=AZrr,param3)thisIsEncrypted",
     * the value returned would be just what comes after the last ')'. So the result for this example
     * would be "thisIsEncrypted". The initial part (encryption context) would be discarded.
     *
     * @param encryptedText the encrypted text passed by spring security
     * @return the encrypted value, minus any encryption context provided
     */
    public static String extractEncryptedValue(final String encryptedText) {
        final int index = encryptedText.lastIndexOf(')');
        if (index > 0) {
            return encryptedText.substring(index + 1);
        }
        return encryptedText;
    }

    /**
     * @param byteBuffer
     * @return extractString
     */
    public static String extractString(final ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            final byte[] bytes = new byte[byteBuffer.remaining()];
            byteBuffer.get(bytes, byteBuffer.arrayOffset(), byteBuffer.remaining());
            return new String(bytes, StandardCharsets.UTF_8);
        }
        return StringUtils.EMPTY;
    }
}
