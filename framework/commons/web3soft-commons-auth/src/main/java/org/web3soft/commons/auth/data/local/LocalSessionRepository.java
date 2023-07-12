package org.web3soft.commons.auth.data.local;

import org.web3soft.commons.lang.util.JsonUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.web3soft.commons.auth.config.SessionConfig;
import org.web3soft.commons.auth.consts.SessionConsts;
import org.web3soft.commons.auth.data.SessionRepository;
import org.web3soft.commons.auth.model.TokenUserInfo;

import java.util.Map;
import java.util.Objects;

/**
 * @author web3soft-team
 */
public class LocalSessionRepository
        implements SessionRepository<TokenUserInfo> {

    private final Map<String, String> sessionMap;
    private final SessionConfig sessionConfig;

    public LocalSessionRepository(final Map<String, String> sessionMap, final SessionConfig sessionConfig) {
        this.sessionMap = sessionMap;
        this.sessionConfig = sessionConfig;
    }

    @Override
    public void save(final String sessionIdKey, final TokenUserInfo session) {
        if (session == null || session.getUserId() == null) {
            return;
        }

        final String userIdKey = SessionConsts.SESSION_USER_ID_PREFIX + session.getUserId();
        this.sessionMap.put(
                sessionIdKey,
                session.getUserId().toString()
        );
        this.updateByUserIdKey(userIdKey, session);
    }

    @Override
    public void refresh(final String sessionIdKey) {
        final TokenUserInfo session = this.findBySessionIdKey(sessionIdKey);
        if (Objects.nonNull(session)) {
            this.save(sessionIdKey, session);
        }
    }

    @Override
    public TokenUserInfo findBySessionIdKey(final String sessionIdKey) {
        final Object value = this.sessionMap.get(sessionIdKey);
        if (Objects.nonNull(value)) {
            final String userIdKey = SessionConsts.SESSION_USER_ID_PREFIX + value.toString();
            return this.findByUserIdKey(userIdKey);
        }
        return null;
    }

    @Override
    public TokenUserInfo findByUserIdKey(final String userIdKey) {
        final Object value = this.sessionMap.get(userIdKey);
        if (Objects.nonNull(value)) {
            return JsonUtil.parseObject(value.toString(), TokenUserInfo.class);
        }
        return null;
    }

    @Override
    public void updateByUserIdKey(final String userIdKey, final TokenUserInfo session) {
        this.sessionMap.put(
                userIdKey,
                JsonUtil.toJSONString(session)
        );
    }

    @Override
    public void delete(final String sessionIdKey) {
        this.sessionMap.remove(sessionIdKey);
    }

    @Override
    public void deleteSessionUser(final String userIdKey) {
        this.sessionMap.remove(userIdKey);
    }

    @Override
    public void setGlobalStatus(final String key, final Integer status) {
        this.sessionMap.put(key, String.valueOf(status));
    }

    @Override
    public Integer getGlobalStatus(final String key) {
        return Integer.valueOf(this.sessionMap.get(key));
    }

    @Override
    public void deleteGlobalStatus(final String key) {
        this.sessionMap.remove(key);
    }

    @Override
    public void clearAllSession() {
        this.sessionMap.clear();
    }

    private long getMaxInactiveInterval() {
        final Object value = this.sessionMap.get(SessionConsts.SESSION_MAX_INACTIVE_INTERVAL);
        if (value == null) {
            return this.sessionConfig.getMaxInactiveInterval().getSeconds();
        }
        return NumberUtils.toLong(value.toString(), this.sessionConfig.getMaxInactiveInterval().getSeconds());
    }

    @Override
    public void setMaxInactiveInterval(final long seconds) {
        this.sessionMap.put(SessionConsts.SESSION_MAX_INACTIVE_INTERVAL, String.valueOf(seconds));
    }
}
