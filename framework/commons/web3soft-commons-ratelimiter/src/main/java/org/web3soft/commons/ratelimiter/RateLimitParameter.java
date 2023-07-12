package org.web3soft.commons.ratelimiter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author web3soft-team
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitParameter {
    /**
     * 唯一key
     */
    private String rateLimitKey;

    /**
     * 最大请求次数
     */
    private long maxRequestTimes;

    /**
     * 计量秒(用于限制每多少seconds时间内的maxRequestTimes（如：10/2 表示2秒内最多请求10次）
     */
    private long seconds;

    /**
     * 当前已经请求的次数
     */
    private long used;
}
