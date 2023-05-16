package org.web3soft.commons.i18n.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.web3soft.commons.i18n.I18nConsts;

import java.util.Locale;
import java.util.Objects;


/**
 * redis message repository
 *
 * @link http://redis.io/
 */
@Slf4j
public class RedisMessageSourceRepository implements MessageSourceRepository {
    private final StringRedisTemplate redisTemplate;

    public RedisMessageSourceRepository(final StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getMessage(final String code, final Locale locale) {
        final String key = I18nConsts.COMMON_CACHE_NAMESPACE_I18N_MSG + locale.toLanguageTag().toLowerCase();
        final Object value = this.redisTemplate.opsForHash().get(key, code);
        log.debug("key:{},code:{},value:{}", key, code, value);
        return Objects.toString(value, "");
    }
}
