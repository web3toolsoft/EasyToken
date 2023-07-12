package org.web3soft.commons.ratelimiter;

/**
 * @author web3soft-team
 */
public interface RateLimiter {
    /**
     * @param parameter
     * @return
     */
    boolean canAcquire(RateLimitParameter parameter);

    /**
     * 清除记数器
     *
     * @param key
     */
    void clear(String key);
}