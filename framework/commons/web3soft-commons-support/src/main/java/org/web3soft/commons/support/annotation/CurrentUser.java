package org.web3soft.commons.support.annotation;

import org.web3soft.commons.dictionary.consts.UserAuthConsts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 绑定当前登录的用户
 *
 * @author web3soft-team
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字
     *
     * @return {@link UserAuthConsts#CURRENT_USER}
     */
    String value() default UserAuthConsts.CURRENT_USER;

}
