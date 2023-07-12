package org.web3soft.commons.auth.consts;

import org.web3soft.commons.dictionary.cache.CacheNamespaces;

/**
 * @author web3soft-team
 */
public class SessionConsts {
    /**
     * Default 10 minutes expired
     */
    public static final int DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS = 604800;

    /**
     * Session expired max inactive interval (default 30 seconds)
     */
    public static final String SESSION_MAX_INACTIVE_INTERVAL = CacheNamespaces.SESSION_CACHE_NAMESPACE + "max_inactive_interval";

    /**
     * Prefix of Session Id("web3soft:session:id:${token}")
     */
    public static final String SESSION_ID_PREFIX = CacheNamespaces.SESSION_CACHE_NAMESPACE + "id:";

    /**
     * Prefix of Session User Id ("web3soft:session:user_id:${user_id}")
     */
    public static final String SESSION_USER_ID_PREFIX = CacheNamespaces.SESSION_CACHE_NAMESPACE + "user_id:";

    /**
     * Prefix of Temp Session("web3soft:session:temp:${token}")
     */
    public static final String SESSION_ID_TMP_PREFIX = CacheNamespaces.SESSION_CACHE_NAMESPACE + "tmp:";
}
