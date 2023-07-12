package org.web3soft.commons.security.sign;


import org.apache.commons.codec.binary.Hex;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 基于RSA数字签名
 *
 * @author web3soft-team
 */
public class RsaSignUtils {

    /**
     * 非对称密钥算法名称
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 数字签名算法。JDK只提供了MD2withRSA, MD5withRSA, SHA1withRSA，其他的算法需要第三方包才能支持
     **/
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data   加密数据(十六进制字符串格式)
     * @param prvKey 私钥(十六进制字符串格式)
     * @return 签名信息
     */
    public static String sign(final String data, final String prvKey) throws Exception {
        return sign(Hex.decodeHex(data), prvKey);
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data   加密数据
     * @param prvKey 私钥(十六进制字符串格式)
     * @return 签名信息
     */
    public static String sign(final byte[] data, final String prvKey) throws Exception {
        final byte[] keyBytes = Hex.decodeHex(prvKey);
        final PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        final PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        final Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return Hex.encodeHexString(signature.sign());
    }

    /**
     * 签名验证
     *
     * @param data   加密数据(十六进制字符串格式)
     * @param sign   数字签名
     * @param pubKey 公钥
     * @return true|false
     */
    public static boolean verify(final String data, final String sign, final String pubKey) throws Exception {
        return verify(Hex.decodeHex(data), sign, pubKey);
    }

    /**
     * 签名验证
     *
     * @param data   加密数据(十六进制字符串格式)
     * @param sign   数字签名
     * @param pubKey 公钥
     * @return true|false
     */
    public static boolean verify(final byte[] data, final String sign, final String pubKey) throws Exception {
        final byte[] keyBytes = Hex.decodeHex(pubKey);
        final X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        final PublicKey publicKey = keyFactory.generatePublic(keySpec);
        final Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(Hex.decodeHex(sign));
    }
}
