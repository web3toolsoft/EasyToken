package org.web3soft.commons.security.sign;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


/**
 * 非对称加密算法RSA算法Utils
 *
 * @author web3soft-team
 */
public class RsaKeyUtils {

    /**
     * 非对称密钥算法名称
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 密钥长度，DH算法的默认密钥长度是1024
     * 密钥长度必须是64的倍数，在512到65536位之间
     */
    private static final int KEY_SIZE = 512;

    /**
     * 生成密钥对
     *
     * @return KeyPair
     */
    public static KeyPair createKeyPair() throws Exception {
        //实例化密钥生成器
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器
        keyPairGenerator.initialize(KEY_SIZE);
        //生成密钥对
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 私钥加密
     *
     * @param data   待加密数据
     * @param prvKey 密钥
     * @return String 加密数据 (十六进制格式)
     */
    public static String encryptByPrivateKey(final String data, final String prvKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        final byte[] encodes = encryptByPrivateKey(data.getBytes(), Hex.decodeHex(prvKey));
        return Hex.encodeHexString(encodes);
    }

    /**
     * 私钥加密
     *
     * @param data   待加密数据
     * @param prvKey 密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(final byte[] data, final byte[] prvKey) throws Exception {
        final PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(prvKey);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        final PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        final Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data   待解密数据
     * @param pubKey 密钥
     * @return 解密数据
     */
    public static String decryptByPublicKey(final String data, final String pubKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        final byte[] encodes = decryptByPublicKey(Hex.decodeHex(data), Hex.decodeHex(pubKey));
        return new String(encodes);
    }

    /**
     * 公钥解密
     *
     * @param data   待解密数据
     * @param pubKey 密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPublicKey(final byte[] data, final byte[] pubKey) throws Exception {
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        final X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKey);
        final PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        final Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data   待加密数据
     * @param pubKey 密钥
     * @return String 加密数据 (十六进制格式)
     */
    public static String encryptByPublicKey(final String data, final String pubKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        final byte[] encodes = encryptByPublicKey(data.getBytes(), Hex.decodeHex(pubKey));
        return Hex.encodeHexString(encodes);
    }

    /**
     * 公钥加密
     *
     * @param data   待加密数据
     * @param pubKey 密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPublicKey(final byte[] data, final byte[] pubKey) throws Exception {
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        final X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKey);
        final PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        final Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data   待解密数据
     * @param prvKey 密钥
     * @return byte[] 解密数据
     */
    public static String decryptByPrivateKey(final String data, final String prvKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        final byte[] encodes = decryptByPrivateKey(Hex.decodeHex(data), Hex.decodeHex(prvKey));
        return new String(encodes);
    }

    /**
     * 私钥解密
     *
     * @param data   待解密数据
     * @param prvKey 密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPrivateKey(final byte[] data, final byte[] prvKey) throws Exception {
        final PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(prvKey);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        final PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        final Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }
}
