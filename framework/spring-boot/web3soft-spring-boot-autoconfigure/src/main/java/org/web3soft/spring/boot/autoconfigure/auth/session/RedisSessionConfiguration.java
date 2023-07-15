package org.web3soft.spring.boot.autoconfigure.auth.session;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.web3soft.commons.auth.config.SessionConfig;
import org.web3soft.commons.auth.data.SessionRepository;
import org.web3soft.commons.auth.data.redis.RedisSessionRepository;
import org.web3soft.commons.auth.model.TokenUserInfo;

/**
 * @author web3soft-team
 */
@ConditionalOnClass(RedisSessionRepository.class)
public class RedisSessionConfiguration {
    private final StringRedisTemplate stringRedisTemplate;
    private final SessionConfig sessionConfig;

    public RedisSessionConfiguration(final StringRedisTemplate stringRedisTemplate, final SessionConfig sessionConfig) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.sessionConfig = sessionConfig;
    }

    @Primary
    @Bean(name = "redisSessionRepository")
    @ConditionalOnProperty(name = "web3soft.auth.session.cache", havingValue = "redis", matchIfMissing = true)
    public SessionRepository<TokenUserInfo> createRedisSessionRepository() {
        return new RedisSessionRepository(this.stringRedisTemplate, this.sessionConfig);
    }
}
