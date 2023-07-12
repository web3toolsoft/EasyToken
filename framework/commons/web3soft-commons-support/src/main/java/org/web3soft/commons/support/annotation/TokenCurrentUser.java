package org.web3soft.commons.support.annotation;

import org.web3soft.commons.dictionary.consts.UserAuthConsts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 绑定当前JWT登录的用户
 *
 * @author web3soft-team
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenCurrentUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default UserAuthConsts.TOKEN_CURRENT_USER;

}
