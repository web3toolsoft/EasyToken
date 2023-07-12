package org.web3soft.commons.support.codec;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

/**
 * @author web3soft-team
 */
@Data
@Builder
public class CodecConfig {
    private AccessKey accessKey;
    private CryptoKey cryptoKey;

    /**
     * 服务之前内部调用的AccessKey
     */
    @Data
    @Builder
    public static class AccessKey {
        private String issuer;
        private String keyId;
        private String keySecret;
        private String expired;
        private SignMethod signMethod;

        /**
         * AccessKey方法签名设置
         */
        @Data
        @Builder
        public static class SignMethod {
            private boolean enabled;
            private Duration expired;
        }
    }

    /**
     * 系统敏感信息加密的CryptoKey
     */
    @Data
    @Builder
    public static class CryptoKey {
        private String issuer;
        private String keyId;
        private String algorithm;
        private String expired;
    }
}
