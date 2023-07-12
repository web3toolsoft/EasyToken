package org.web3soft.commons.ratelimiter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 基于ip请求流量限制注解
 *
 * @author web3soft-team
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IpRequestRateLimit {
    /**
     * 请求限制值(times/seconds)
     * 如:(10/2)表示2秒最多10次请求
     *
     * @return (times / seconds)
     */
    String value() default "10/1";
}
