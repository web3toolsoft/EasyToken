package org.web3soft.commons.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3soft.commons.auth.consts.SessionConsts;
import org.web3soft.commons.auth.data.SessionRepository;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;

import java.util.Objects;

/**
 * @author web3soft-team
 */
@Slf4j
public class SessionServiceImpl implements SessionService<TokenUserInfo> {
    @Autowired
    private SessionRepository<TokenUserInfo> sessionRepository;

    @Override
    public void setMaxInactiveInterval(final long seconds) {
        this.sessionRepository.setMaxInactiveInterval(seconds);
    }

    @Override
    public void save(final String token, final TokenUserInfo session) {
        Validate.notNull(session);
        final String sessionIdKey = this.getSessionIdKey(token);
        this.sessionRepository.save(sessionIdKey, session);
    }

    @Override
    public void updateByUserId(final TokenUserInfo newTokenUserInfo) {
        Validate.notNull(newTokenUserInfo);
        Validate.notNull(newTokenUserInfo.getUserId());

        final String userIdKey = this.getUserIdKey(newTokenUserInfo.getUserId());
        final TokenUserInfo oldTokenUserInfo = this.getByUserId(newTokenUserInfo.getUserId());
        if (Objects.nonNull(oldTokenUserInfo)) {
            oldTokenUserInfo.setStatus(ObjectUtils.defaultIfNull(newTokenUserInfo.getStatus(), oldTokenUserInfo.getStatus()));
            oldTokenUserInfo.setFrozenAll(ObjectUtils.defaultIfNull(newTokenUserInfo.getFrozenAll(), oldTokenUserInfo.getFrozenAll()));
            this.sessionRepository.updateByUserIdKey(userIdKey, oldTokenUserInfo);
        } else {
            log.warn("userId:{} session not found", newTokenUserInfo.getUserId());
        }
    }

    @Override
    public void refresh(final String token) {
        final String sessionIdKey = this.getSessionIdKey(token);
        this.sessionRepository.refresh(sessionIdKey);
    }

    @Override
    public TokenUserInfo getByToken(final String token) {
        final String sessionIdKey = this.getSessionIdKey(token);
        return this.sessionRepository.findBySessionIdKey(sessionIdKey);
    }

    @Override
    public TokenUserInfo getByUserId(final long userId) {
        return this.sessionRepository.findByUserIdKey(this.getUserIdKey(userId));
    }

    @Override
    public void remove(final String token) {
        final String sessionIdKey = this.getSessionIdKey(token);
        this.sessionRepository.delete(sessionIdKey);
    }

    @Override
    public void removeSessionUser(final long userId) {
        final String userIdKey = this.getUserIdKey(userId);
        this.sessionRepository.deleteSessionUser(userIdKey);
    }

    @Override
    public String getSessionIdKey(final String token) {
        return SessionConsts.SESSION_ID_PREFIX + token;
    }

    @Override
    public String getUserIdKey(final long userId) {
        return SessionConsts.SESSION_USER_ID_PREFIX + userId;
    }

    @Override
    public void setGlobalStatus(final String key, final Integer status) {
        this.sessionRepository.setGlobalStatus(key, status);
    }

    @Override
    public Integer getGlobalStatus(final String key) {
        return this.sessionRepository.getGlobalStatus(key);
    }

    @Override
    public void deleteGlobalStatus(final String key) {
        this.sessionRepository.deleteGlobalStatus(key);
    }

    @Override
    public void clearAllSession() {
        this.sessionRepository.clearAllSession();
    }
}
