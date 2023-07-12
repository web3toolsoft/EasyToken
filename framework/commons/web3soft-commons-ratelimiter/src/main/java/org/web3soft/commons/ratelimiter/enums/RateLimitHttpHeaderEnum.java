package org.web3soft.commons.ratelimiter.enums;

import lombok.Getter;

/**
 * API RateLimiting Custom Http Headers
 *
 * @author web3soft-team
 */
@Getter
public enum RateLimitHttpHeaderEnum {
    /**
     *
     */
    X_RATELIMIT_LIMIT("X-RateLimit-Limit", "The maximum number of requests you're permitted to make per hour."),
    X_RATELIMIT_REMAINING("X-RateLimit-Remaining", "The number of requests remaining in the current rate limit window."),
    X_RATELIMIT_USED("X-RateLimit-Used", "The time at which the current rate limit window used in UTC epoch seconds."),
    X_RATELIMIT_RESET("X-RateLimit-Reset", "The time at which the current rate limit window resets in UTC epoch seconds.."),
    ;

    private final String name;
    private final String comment;

    RateLimitHttpHeaderEnum(final String name, final String comment) {
        this.name = name;
        this.comment = comment;
    }
}
