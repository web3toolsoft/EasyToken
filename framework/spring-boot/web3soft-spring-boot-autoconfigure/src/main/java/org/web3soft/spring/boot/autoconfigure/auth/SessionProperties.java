package org.web3soft.spring.boot.autoconfigure.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.web3soft.commons.auth.consts.SessionConsts;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.auth.session")
public class SessionProperties {
    private int maxInactiveInterval = SessionConsts.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS;

    /**
     * 获取session过期时间(default 10 minutes),如果为负数表示永不过期(单位:秒)
     */
    public int getMaxInactiveInterval() {
        return this.maxInactiveInterval < 0 ? Integer.MAX_VALUE : this.maxInactiveInterval;
    }

    /**
     * 获取session过期时间(default 10 minutes),如果为负数表示永不过期(单位:秒)
     *
     * @param maxInactiveInterval session过期时间(单位:秒)
     */
    public void setMaxInactiveInterval(final int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }
}
