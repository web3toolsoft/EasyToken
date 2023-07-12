package org.web3soft.commons.support.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * api是否启用
 *
 * @author web3soft-team
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiEnabledFor {
    /**
     * 应用名称
     *
     * @return 应用名称
     */
    String value() default "";
}
