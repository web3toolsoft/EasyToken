package org.web3soft.spring.boot.autoconfigure.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.web3soft.commons.security.xss.XssFilterPolicyEnum;

import java.time.Duration;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.security")
public class SecurityProperties {
    private boolean exceptionAdvice = true;
    private Xss xss;
    private Csrf csrf;
    private AccessKey accessKey = new AccessKey();
    private CryptoKey cryptoKey = new CryptoKey();

    public boolean isExceptionAdvice() {
        return this.exceptionAdvice;
    }

    public void setExceptionAdvice(final boolean exceptionAdvice) {
        this.exceptionAdvice = exceptionAdvice;
    }

    public Xss getXss() {
        return this.xss;
    }

    public void setXss(final Xss xss) {
        this.xss = xss;
    }

    public Csrf getCsrf() {
        return this.csrf;
    }

    public void setCsrf(final Csrf csrf) {
        this.csrf = csrf;
    }

    public AccessKey getAccessKey() {
        return this.accessKey;
    }

    public void setAccessKey(final AccessKey accessKey) {
        this.accessKey = accessKey;
    }

    public CryptoKey getCryptoKey() {
        return this.cryptoKey;
    }

    public void setCryptoKey(final CryptoKey cryptoKey) {
        this.cryptoKey = cryptoKey;
    }

    public static class Xss {
        private boolean enabled = true;
        private String policy = "owasp";
        private String urlPatterns = "/v1/*";
        private String excludeUrlPatterns = "";

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }

        /**
         * 获取需要XssFilter过滤策略
         * 默认为{@link XssFilterPolicyEnum#OWASP }
         *
         * @return 过滤策略
         * @see XssFilterPolicyEnum
         */
        public String getPolicy() {
            return this.policy;
        }

        /**
         * 设置需要XssFilter过滤策略
         *
         * @param policy XssFilter过滤策略
         */
        public void setPolicy(final String policy) {
            this.policy = policy;
        }

        /**
         * 获取需要XssFilter的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @return url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public String getUrlPatterns() {
            return this.urlPatterns;
        }

        /**
         * 设置需要XssFilter的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @param urlPatterns url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public void setUrlPatterns(final String urlPatterns) {
            this.urlPatterns = urlPatterns;
        }

        /**
         * 获取排出XssFilter的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @return url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public String getExcludeUrlPatterns() {
            return this.excludeUrlPatterns;
        }

        /**
         * 设置排出XssFilter的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @param excludeUrlPatterns url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public void setExcludeUrlPatterns(final String excludeUrlPatterns) {
            this.excludeUrlPatterns = excludeUrlPatterns;
        }
    }

    public static class Csrf {
        private boolean enabled = true;
        private String refererPattern = "all";
        private String excludePathPatterns = "";

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }

        /**
         * 获取可以通过csrf的http header referer url pattern(正则表达式）
         * 默认值为"all"表示全部通过
         *
         * @return http header referer url pattern(正则表达式）
         */
        public String getRefererPattern() {
            return this.refererPattern;
        }

        /**
         * 设置可以通过csrf的http header referer url pattern(正则表达式）
         *
         * @param refererPattern http header referer pattern(正则表达式）
         */
        public void setRefererPattern(final String refererPattern) {
            this.refererPattern = refererPattern;
        }

        /**
         * 获取排出csrf的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @return url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public String getExcludePathPatterns() {
            return this.excludePathPatterns;
        }

        /**
         * 设置排出csrf的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @param excludePathPatterns 排出csrf的url pattern(ant pattern 表达式)
         */
        public void setExcludePathPatterns(final String excludePathPatterns) {
            this.excludePathPatterns = excludePathPatterns;
        }
    }

    /**
     * 服务之前内部调用的AccessKey
     */
    public static class AccessKey {
        private String issuer = "web3soft";
        private String keyId;
        private String keySecret;
        private String expired;
        private SignMethod signMethod = new SignMethod();

        /**
         * 设置颁发机构
         *
         * @return 颁发机构
         */
        public String getIssuer() {
            return this.issuer;
        }

        /**
         * 获取颁发机构(默认为"web3soft")
         *
         * @param issuer 颁发机构
         */
        public void setIssuer(final String issuer) {
            this.issuer = issuer;
        }

        /**
         * 获取AccessKeyId
         *
         * @return AccessKeyId
         */
        public String getKeyId() {
            return this.keyId;
        }

        /**
         * 设置AccessKeyId
         *
         * @param keyId AccessKeyId
         */
        public void setKeyId(final String keyId) {
            this.keyId = keyId;
        }

        /**
         * 获取 AccessKeySecret
         *
         * @return AccessKeySecret
         */
        public String getKeySecret() {
            return this.keySecret;
        }

        /**
         * 设置AccessKeySecret
         *
         * @param keySecret AccessKeySecret
         */
        public void setKeySecret(final String keySecret) {
            this.keySecret = keySecret;
        }

        /**
         * 获取AccessKey过期时间(格式为:yyyy-MM-dd)
         * 如果不设置则永久不过期
         *
         * @return AccessKey过期时间 (格式为:yyyy-MM-dd)
         */
        public String getExpired() {
            return this.expired;
        }

        /**
         * 设置AccessKey过期日期 (格式为:yyyy-MM-dd)
         * 如果不设置则永久不过期
         *
         * @param expired AccessKey过期日期 (格式为:yyyy-MM-dd)
         */
        public void setExpired(final String expired) {
            this.expired = expired;
        }

        /**
         * 获取AccessKey的签名方法设置
         *
         * @return AccessKey的签名方法设置
         */
        public SignMethod getSignMethod() {
            return this.signMethod;
        }

        /**
         * 设置AccessKey的签名方法
         *
         * @param signMethod AccessKey的签名方法设置
         */
        public void setSignMethod(final SignMethod signMethod) {
            this.signMethod = signMethod;
        }

        /**
         * AccessKey方法签名设置
         */
        public static class SignMethod {
            private boolean enabled = true;
            private Duration expired = Duration.ofSeconds(20);

            /**
             * 设置是否启用内部方法调用签名
             *
             * @return true|false
             */
            public boolean isEnabled() {
                return this.enabled;
            }

            /**
             * 获取是否启用内部方法调用签名
             * 默认为true
             *
             * @param enabled true|fase
             */
            public void setEnabled(final boolean enabled) {
                this.enabled = enabled;
            }

            /**
             * 获取方法签名过期时间(默认为20s)
             *
             * @return 方法签名过期时间(默认为20s)
             */
            public Duration getExpired() {
                return this.expired;
            }

            /**
             * 设置方法签名过期时间
             *
             * @param expired 方法签名过期时间
             */
            public void setExpired(final Duration expired) {
                this.expired = expired;
            }
        }
    }

    /**
     * 系统敏感信息加密的CryptoKey
     */
    public static class CryptoKey {
        private String issuer = "web3soft";
        private String keyId;
        private String algorithm = "AES";
        private String expired;

        /**
         * 设置颁发机构
         *
         * @return 颁发机构
         */
        public String getIssuer() {
            return this.issuer;
        }

        /**
         * 获取颁发机构(默认为"web3soft")
         *
         * @param issuer 颁发机构
         */
        public void setIssuer(final String issuer) {
            this.issuer = issuer;
        }

        /**
         * 获取加密CryptoKeyId
         *
         * @return 加密CryptoKeyId
         */
        public String getKeyId() {
            return this.keyId;
        }

        /**
         * 设置加密CryptoKeyId
         *
         * @param keyId 加密CryptoKeyId
         */
        public void setKeyId(final String keyId) {
            this.keyId = keyId;
        }

        /**
         * 获取加密算法名称(默认为"AES")
         *
         * @return 加密算法名称(默认为 " AES ")
         */
        public String getAlgorithm() {
            return this.algorithm;
        }

        /**
         * 设置加密算法名称(取值只能是AES|DES|TripleDES)
         *
         * @param algorithm 加密算法名称
         */
        public void setAlgorithm(final String algorithm) {
            this.algorithm = algorithm;
        }

        /**
         * 获取CryptoKey过期时间(格式为:yyyy-MM-dd)
         * 如果不设置则永久不过期
         *
         * @return CryptoKey过期时间 (格式为:yyyy-MM-dd)
         */
        public String getExpired() {
            return this.expired;
        }

        /**
         * 设置CryptoKey过期时间 (格式为:yyyy-MM-dd)
         * 如果不设置则永久不过期
         *
         * @param expired CryptoKey过期时间 (格式为:yyyy-MM-dd)
         */
        public void setExpired(final String expired) {
            this.expired = expired;
        }
    }
}
