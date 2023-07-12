package org.web3soft.commons.auth.data;

import org.web3soft.commons.auth.model.TokenUserInfo;

/**
 * @param <S>
 */
public interface SessionRepository<S extends TokenUserInfo> {
    /**
     * @param seconds
     */
    void setMaxInactiveInterval(long seconds);

    /**
     * @param sessionIdKey
     * @param session
     */
    void save(String sessionIdKey, S session);

    /**
     * @param sessionIdKey
     */
    void refresh(final String sessionIdKey);

    /**
     * @param sessionIdKey
     * @return key
     */
    S findBySessionIdKey(final String sessionIdKey);

    /**
     * @param userIdKey
     * @return Key
     */
    S findByUserIdKey(final String userIdKey);

    /**
     * 更新登录用户的会话状态信息
     *
     * @param userIdKey
     * @param session
     */
    void updateByUserIdKey(final String userIdKey, final TokenUserInfo session);

    /**
     * 删除用户登录session key
     *
     * @param sessionIdKey
     */
    void delete(final String sessionIdKey);

    /**
     * 删除登录用户(会影响所有端web,android,ios等的登录态)
     *
     * @param userIdKey
     */
    void deleteSessionUser(final String userIdKey);

    /**
     * @param key
     * @param status
     */
    void setGlobalStatus(String key, Integer status);

    /**
     * @param key
     * @return status
     */
    Integer getGlobalStatus(String key);

    /**
     * @param key
     */
    void deleteGlobalStatus(String key);

    /**
     * 清除所有用户登录session
     */
    void clearAllSession();
}

