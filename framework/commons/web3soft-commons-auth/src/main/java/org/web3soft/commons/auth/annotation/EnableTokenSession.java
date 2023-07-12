package org.web3soft.commons.auth.annotation;


import org.web3soft.commons.auth.consts.SessionConsts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author web3soft-team
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableTokenSession {
    /**
     * The session timeout in seconds. By default, it is set to 600 seconds (10 minutes).
     * This should be a non-negative integer.
     *
     * @return the seconds a session can be inactive before expiring
     */
    int maxInactiveIntervalInSeconds() default SessionConsts.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS;
}
