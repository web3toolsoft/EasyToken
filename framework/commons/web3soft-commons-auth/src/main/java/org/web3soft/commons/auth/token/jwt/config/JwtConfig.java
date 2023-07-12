package org.web3soft.commons.auth.token.jwt.config;

import org.web3soft.commons.auth.config.TokenConfig;

/**
 * @author web3soft-team
 */
public final class JwtConfig extends TokenConfig {
    private String issuer;
    private long expiration;

    /**
     * 获取颁发机构
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
     * (默认为"604800"相当于7天有效期)
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
