package org.web3soft.commons.lang.cache;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author web3soft-team
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cache {
    /**
     * 缓存ID
     */
    private final String key;
    /**
     * 缓存数据
     */
    private final String value;
    /**
     * 过期时间(毫秒)
     */
    private final long expire;
    /**
     * 当前时间(毫秒)
     */
    private final long currentMillis = System.currentTimeMillis();

    public boolean isExpired() {
        return System.currentTimeMillis() > this.currentMillis + this.expire;
    }
}
