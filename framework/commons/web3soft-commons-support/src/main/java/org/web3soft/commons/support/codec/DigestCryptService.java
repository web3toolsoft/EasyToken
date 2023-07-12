package org.web3soft.commons.support.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.lang.crypto.AESUtil;

import java.time.Duration;
import java.time.Instant;

/**
 * @author web3soft-team
 **/
@Slf4j
public class DigestCryptService {
    private final CodecConfig codecConfig;

    public DigestCryptService(final CodecConfig codecConfig) {
        this.codecConfig = codecConfig;
    }

    /**
     * 获取配置信息
     *
     * @return CodecConfig
     */
    public CodecConfig getCodecConfig() {
        return this.codecConfig;
    }

    /**
     * 获取Feign内部方法调用签名过期时间(默认20s)
     *
     * @return 过期时间(默认20s)
     */
    public Duration getSignMethodExpired() {
        return this.codecConfig.getAccessKey().getSignMethod().getExpired();
    }

    /**
     * 是否开启Feign内部方法调用签名
     *
     * @return true|false
     */
    public boolean isEnableSignMethod() {
        return this.codecConfig.getAccessKey().getSignMethod().isEnabled();
    }

    /**
     * 基于{@link HmacAlgorithms#HMAC_SHA_256}生成签名摘要
     *
     * @param timestamp 当前时间戳{@link  Instant#now()#getEpochSecond()}
     * @return HMAC_SHA_256(accessKeySecret, accessKeyId + timestamp)
     */
    public String generateSignature(final long timestamp) {
        final String plaintext = String.format("%s-%s", this.codecConfig.getAccessKey().getKeyId(), timestamp);
        return this.generateSignature(plaintext);
    }

    /**
     * 基于{@link HmacAlgorithms#HMAC_SHA_256}生成签名摘要
     *
     * @param plaintext 原始信息
     * @return HMAC_SHA_256签名摘要
     */
    public String generateSignature(final String plaintext) {
        final String key = this.codecConfig.getAccessKey().getKeySecret();
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key).hmacHex(plaintext);
    }

    /**
     * 比对签名摘要
     *
     * @param accessSign 原始签名
     * @param currSign   当前签名
     * @return true|false
     */
    public boolean validateSignature(final String accessSign, final String currSign) {
        return StringUtils.equals(accessSign, currSign);
    }

    /**
     * 解密信息
     *
     * @param encode 加密串
     * @return 解密串
     */
    public String decrypt(final String encode) {
        try {
            return AESUtil.decrypt(encode, this.codecConfig.getCryptoKey().getKeyId());
        } catch (final Exception ex) {
            log.error("decrypt error", ex);
        }
        return StringUtils.EMPTY;
    }

    /**
     * 加密信息
     *
     * @param plaintext 原始信息
     * @return 加密串
     */
    public String encrypt(final String plaintext) {
        try {
            return AESUtil.encrypt(plaintext, this.codecConfig.getCryptoKey().getKeyId());
        } catch (final Exception ex) {
            log.error("encrypt error", ex);
        }
        return StringUtils.EMPTY;
    }
}
