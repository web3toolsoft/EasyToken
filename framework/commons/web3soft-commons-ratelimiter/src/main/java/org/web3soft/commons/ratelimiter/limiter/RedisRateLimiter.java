package org.web3soft.commons.ratelimiter.limiter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.web3soft.commons.ratelimiter.AbstractRateLimiter;
import org.web3soft.commons.ratelimiter.RateLimitParameter;
import org.web3soft.commons.ratelimiter.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author web3soft-team
 */
@Slf4j
public class RedisRateLimiter
        extends AbstractRateLimiter implements RateLimiter {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean canAcquire(final RateLimitParameter parameter) {
        final String key = parameter.getRateLimitKey();
        final long seconds = parameter.getSeconds();
        final long max = parameter.getMaxRequestTimes();

        final long current = NumberUtils.toLong(this.stringRedisTemplate.opsForValue().get(key), 0);
        if (current >= max) {
            return false;
        }

        final Long incr = this.stringRedisTemplate.opsForValue().increment(key, 1);
        parameter.setUsed(ObjectUtils.defaultIfNull(incr, 0L));
        if (parameter.getUsed() == 1) {
            this.stringRedisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        }
        return true;
    }

    @Override
    public void clear(final String key) {
        this.stringRedisTemplate.delete(key);
    }
}
