package org.web3soft.commons.lang.crypto;

import lombok.extern.slf4j.Slf4j;
import org.web3soft.commons.lang.util.HexUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * DES加密和解密工具,可以对字符串进行加密和解密操作
 *
 * @author web3soft-team
 * @since 0.0.1
 **/
@Slf4j
public class DesUtil {
    private static final String DEFAULT_KEY = "0987!@#$()";
    private static final Cipher ENCRYPT_CIPHER;
    private static final Cipher DECRYPT_CIPHER;

    static {
        try {
            Security.addProvider(Security.getProvider("SunJCE"));
            final Key key = getKey(DEFAULT_KEY.getBytes());

            ENCRYPT_CIPHER = Cipher.getInstance("DES");
            ENCRYPT_CIPHER.init(Cipher.ENCRYPT_MODE, key);

            DECRYPT_CIPHER = Cipher.getInstance("DES");
            DECRYPT_CIPHER.init(Cipher.DECRYPT_MODE, key);
        } catch (final Exception e) {
            throw new RuntimeException("DesUtil init static code block error", e);
        }
    }

    /**
     * 加密字符串
     *
     * @param str 需加密的字符串
     * @return 加密后的字符串
     */
    public static String encrypt(final String str) {
        return HexUtil.encodeHex(encrypt(str.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 加密字节数组
     *
     * @param data 需加密的字节数组
     * @return 加密后的字节数组
     */
    public static byte[] encrypt(final byte[] data) {
        try {
            return ENCRYPT_CIPHER.doFinal(data);
        } catch (final IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException("encrypt error", e);
        }
    }

    /**
     * 解密字符串
     *
     * @param str 需解密的字符串
     * @return 解密后的字符串
     */
    public static String decrypt(final String str) {
        try {
            return new String(decrypt(HexUtil.decodeHex(str)), StandardCharsets.UTF_8);
        } catch (final Exception e) {
            throw new RuntimeException("decrypt error", e);
        }
    }

    /**
     * 解密字节数组
     *
     * @param data 需解密的字节数组
     * @return 解密后的字节数组
     */
    public static byte[] decrypt(final byte[] data) {
        try {
            return DECRYPT_CIPHER.doFinal(data);
        } catch (final IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException("decrypt error", e);
        }
    }

    /**
     * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
     *
     * @param data 构成该字符串的字节数组
     * @return 生成的密钥
     */
    public static Key getKey(final byte[] data) {
        // 创建一个空的8位字节数组（默认值为0）
        // 将原始字节数组转换为8位
        final byte[] bytes = Arrays.copyOf(data, 8);
        return new javax.crypto.spec.SecretKeySpec(bytes, "DES");
    }
}