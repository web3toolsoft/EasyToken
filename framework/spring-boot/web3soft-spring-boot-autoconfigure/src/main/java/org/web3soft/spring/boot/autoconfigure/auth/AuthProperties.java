package org.web3soft.spring.boot.autoconfigure.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.web3soft.commons.support.properties.InterceptorProperty;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.auth")
public class AuthProperties {
    private Jwt jwt = new Jwt();
    private Token token = new Token();
    private Frozen frozen = new Frozen();

    public Jwt getJwt() {
        return this.jwt;
    }

    public void setJwt(final Jwt jwt) {
        this.jwt = jwt;
    }

    public Token getToken() {
        return this.token;
    }

    public void setToken(final Token token) {
        this.token = token;
    }

    public Frozen getFrozen() {
        return this.frozen;
    }

    public void setFrozen(final Frozen frozen) {
        this.frozen = frozen;
    }

    /**
     * session token配置
     */
    public static class Token {
        private boolean enabled = true;
        private boolean exceptionAdvice = true;
        private String requestHeaderName = "x-authorization";
        private String secret = "N4A%x$oCvqCFKpaH";
        private String cryptoKey = "b1mOt3jr#7r66^1V";
        private String includeUrlPatterns = "";
        private String excludePathPatterns = "";
        private String cryptoAlgorithm = "AES";
        private boolean validateIpAndDevice = false;

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isExceptionAdvice() {
            return this.exceptionAdvice;
        }

        public void setExceptionAdvice(final boolean exceptionAdvice) {
            this.exceptionAdvice = exceptionAdvice;
        }

        /**
         * 获取httpRequest Header中存放token的名称
         * (默认为"X-Authorization")
         *
         * @return requestHeaderName
         */
        public String getRequestHeaderName() {
            return this.requestHeaderName;
        }

        /**
         * 设置httpRequest Header中存放 token的名称
         *
         * @param requestHeaderName httpRequest Header中存放token的名称
         */
        public void setRequestHeaderName(final String requestHeaderName) {
            this.requestHeaderName = requestHeaderName;
        }

        /**
         * 获取token签名密钥
         *
         * @return token签名密钥
         */
        public String getSecret() {
            return this.secret;
        }

        /**
         * 设置token签名密钥
         *
         * @param secret token签名密钥
         */
        public void setSecret(final String secret) {
            this.secret = secret;
        }

        /**
         * 获取token playload内容加密密钥(默认为AES算法）(可选配置)
         *
         * @return token playload内容加密密钥
         */
        public String getCryptoKey() {
            return this.cryptoKey;
        }

        /**
         * 设置 token playload 内容加密密钥(默认为AES算法）(可选配置)
         *
         * @param cryptoKey token playload内容加密密钥
         */
        public void setCryptoKey(final String cryptoKey) {
            this.cryptoKey = cryptoKey;
        }

        /**
         * 获取拦截器需要包含的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @return include url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public String getIncludeUrlPatterns() {
            return this.includeUrlPatterns;
        }

        /**
         * 设置拦截器需要包含的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @param includeUrlPatterns include url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public void setIncludeUrlPatterns(final String includeUrlPatterns) {
            this.includeUrlPatterns = includeUrlPatterns;
        }

        /**
         * 获取排出token拦截的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @return url pattern(ant pattern 表达式)
         * @see org.springframework.util.AntPathMatcher
         */
        public String getExcludePathPatterns() {
            return this.excludePathPatterns;
        }

        /**
         * 设置排出token拦截的url pattern(ant pattern 表达式)
         * 多个pattern用英文逗号(,)分隔
         *
         * @param excludePathPatterns 排出token的url pattern(ant pattern 表达式)
         */
        public void setExcludePathPatterns(final String excludePathPatterns) {
            this.excludePathPatterns = excludePathPatterns;
        }

        /**
         * 获取token playload 内容加密算法名称(默认为AES）
         *
         * @return token playload 内容加密算法名称(默认为AES）
         */
        public String getCryptoAlgorithm() {
            return this.cryptoAlgorithm;
        }

        /**
         * 设置token playload内容加密算法名称）
         *
         * @param cryptoAlgorithm
         */
        public void setCryptoAlgorithm(final String cryptoAlgorithm) {
            this.cryptoAlgorithm = cryptoAlgorithm;
        }

        /**
         * 获取是否验证token中的ip与设备id的有效性(默认为false)
         *
         * @return true|false
         */
        public boolean isValidateIpAndDevice() {
            return this.validateIpAndDevice;
        }

        /**
         * 设置是否验证token中的ip与设备id的有效性(默认为false)
         *
         * @param validateIpAndDevice true|false
         */
        public void setValidateIpAndDevice(final boolean validateIpAndDevice) {
            this.validateIpAndDevice = validateIpAndDevice;
        }
    }

    /**
     * Json Web Token(JWT)配置项
     */
    public static class Jwt extends Token {
        private String issuer = "web3soft";
        private long expiration = 604800;

        /**
         * 获取颁发机构(默认为"web3soft")
         *
         * @return 颁发机构
         */
        public String getIssuer() {
            return this.issuer;
        }

        /**
         * 设置颁发机构
         *
         * @param issuer 颁发机构
         */
        public void setIssuer(final String issuer) {
            this.issuer = issuer;
        }

        /**
         * 获取TOKEN过期时间或刷新时间
         * (默认为"86400"相当于24小时有效期)
         *
         * @return TOKEN过期时间或刷新时间
         */
        public long getExpiration() {
            return this.expiration;
        }

        /**
         * 设置TOKEN过期时间或刷新时间
         *
         * @param expiration TOKEN过期时间或刷新时间
         */
        public void setExpiration(final long expiration) {
            this.expiration = expiration;
        }

    }

    /**
     *
     */
    public static class Frozen {
        /**
         * {@link org.web3soft.commons.dictionary.enums.BizTypeEnum}
         */
        private String bizType = "";

        private InterceptorProperty urlPatterns = new InterceptorProperty("", "");

        public String getBizType() {
            return this.bizType;
        }

        public void setBizType(final String bizType) {
            this.bizType = bizType;
        }

        public InterceptorProperty getUrlPatterns() {
            return this.urlPatterns;
        }

        public void setUrlPatterns(final InterceptorProperty urlPatterns) {
            this.urlPatterns = urlPatterns;
        }
    }
}
