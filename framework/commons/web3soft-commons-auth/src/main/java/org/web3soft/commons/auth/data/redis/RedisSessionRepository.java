package org.web3soft.commons.auth.data.redis;

import org.web3soft.commons.lang.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.web3soft.commons.auth.config.SessionConfig;
import org.web3soft.commons.auth.consts.SessionConsts;
import org.web3soft.commons.auth.data.SessionRepository;
import org.web3soft.commons.auth.model.TokenUserInfo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author web3soft-team
 */
@Slf4j
public class RedisSessionRepository
        implements SessionRepository<TokenUserInfo> {

    private final StringRedisTemplate redisTemplate;
    private final SessionConfig sessionConfig;

    public RedisSessionRepository(final StringRedisTemplate redisTemplate, final SessionConfig sessionConfig) {
        this.redisTemplate = redisTemplate;
        this.sessionConfig = sessionConfig;
    }

    @Override
    public void save(final String sessionIdKey, final TokenUserInfo session) {
        if (session == null || session.getUserId() == null) {
            return;
        }

        final String userIdKey = SessionConsts.SESSION_USER_ID_PREFIX + session.getUserId();
        this.redisTemplate.opsForValue().set(
                sessionIdKey,
                session.getUserId().toString(),
                this.getMaxInactiveInterval(),
                TimeUnit.SECONDS
        );
        this.updateByUserIdKey(userIdKey, session);
    }

    @Override
    public void refresh(final String sessionIdKey) {
        this.redisTemplate.expire(
                sessionIdKey,
                this.getMaxInactiveInterval(),
                TimeUnit.SECONDS
        );
    }

    @Override
    public TokenUserInfo findBySessionIdKey(final String sessionIdKey) {
        final String userId = this.redisTemplate.opsForValue().get(sessionIdKey);
        if (StringUtils.isNotEmpty(userId)) {
            final String userIdKey = SessionConsts.SESSION_USER_ID_PREFIX + userId;
            return this.findByUserIdKey(userIdKey);
        }
        return null;
    }

    @Override
    public TokenUserInfo findByUserIdKey(final String userIdKey) {
        final String json = this.redisTemplate.opsForValue().get(userIdKey);
        if (StringUtils.isNotEmpty(json)) {
            return JsonUtil.parseObject(json, TokenUserInfo.class);
        }
        return null;
    }

    @Override
    public void updateByUserIdKey(final String userIdKey, final TokenUserInfo session) {
        this.redisTemplate.opsForValue().set(userIdKey, JsonUtil.toJSONString(session));
    }

    @Override
    public void delete(final String sessionIdKey) {
        this.redisTemplate.delete(sessionIdKey);
    }

    @Override
    public void deleteSessionUser(final String userIdKey) {
        this.redisTemplate.delete(userIdKey);
    }

    @Override
    public void setGlobalStatus(final String key, final Integer status) {
        this.redisTemplate.opsForValue().set(key, status.toString());
    }

    @Override
    public Integer getGlobalStatus(final String key) {
        return NumberUtils.toInt(this.redisTemplate.opsForValue().get(key), 0);
    }

    @Override
    public void deleteGlobalStatus(final String key) {
        this.redisTemplate.delete(key);
    }

    @Override
    public void clearAllSession() {
        final String idKeyPattern = SessionConsts.SESSION_ID_PREFIX + "*";
        final String userIdKeyPattern = SessionConsts.SESSION_USER_ID_PREFIX + "*";

        final Set<String> idKeys = this.redisTemplate.keys(idKeyPattern);
        if (!CollectionUtils.isEmpty(idKeys)) {
            this.redisTemplate.delete(idKeys);
        }
        final Set<String> userIdKeys = this.redisTemplate.keys(userIdKeyPattern);
        if (!CollectionUtils.isEmpty(userIdKeys)) {
            this.redisTemplate.delete(userIdKeys);
        }
    }

    private long getMaxInactiveInterval() {
        final String value = this.redisTemplate.opsForValue().get(SessionConsts.SESSION_MAX_INACTIVE_INTERVAL);
        return NumberUtils.toLong(value, this.sessionConfig.getMaxInactiveInterval().getSeconds());
    }

    @Override
    public void setMaxInactiveInterval(final long seconds) {
        log.info("setMaxInactiveInterval:[{}]", seconds);
        this.redisTemplate.opsForValue().set(SessionConsts.SESSION_MAX_INACTIVE_INTERVAL, String.valueOf(seconds));
    }
}
