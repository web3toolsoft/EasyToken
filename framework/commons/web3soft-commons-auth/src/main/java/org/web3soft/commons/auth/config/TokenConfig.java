package org.web3soft.commons.auth.config;

/**
 * @author web3soft-team
 */
public class TokenConfig {
    private String requestHeaderName;
    private String secret;
    private String cryptoKey;
    private boolean validateIpAndDevice;

    /**
     * 获取httpRequest Header中存放token token的名称
     *
     * @return requestHeaderName
     */
    public String getRequestHeaderName() {
        return this.requestHeaderName;
    }

    /**
     * 设置httpRequest Header中存放token token的名称
     *
     * @param requestHeaderName httpRequest Header中存放token token的名称
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
     * 获取JWT playload内容加密密钥(默认为AES算法）(可选)
     *
     * @return JWT playload内容加密密钥
     */
    public String getCryptoKey() {
        return this.cryptoKey;
    }

    /**
     * 设置 JWT playload内容加密密钥(默认为AES算法）(可选)
     *
     * @param cryptoKey JWT playload内容加密密钥
     */
    public void setCryptoKey(final String cryptoKey) {
        this.cryptoKey = cryptoKey;
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
