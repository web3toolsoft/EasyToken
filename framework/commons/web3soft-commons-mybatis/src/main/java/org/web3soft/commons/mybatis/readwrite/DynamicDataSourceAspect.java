package org.web3soft.commons.mybatis.readwrite;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 读写分离数据源切面
 *
 * @author Tom Deng
 *
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {
    @Pointcut("@annotation(org.web3soft.commons.mybatis.readwrite.ReadWriteDataSource)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(final JoinPoint point) {
        final Object target = point.getTarget();
        final String methodName = point.getSignature().getName();
        final Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            final Method method = target.getClass().getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(ReadWriteDataSource.class)) {
                final ReadWriteDataSource data = method.getAnnotation(ReadWriteDataSource.class);
                DynamicDataSourceHolder.putDataSource(data.value());
                DynamicDataSourceAspect.log.debug("Choose DataSource: {},Class:{}, Method:{}",
                        data.value(), target.getClass().getName(), methodName);
            }
        } catch (final Exception e) {
            DynamicDataSourceAspect.log.error("Choose DataSource error, method:{}, msg:{}", methodName, e.getMessage());
        }
    }

    @After("pointcut()")
    public void after(final JoinPoint point) {
        DynamicDataSourceHolder.clearDataSource();
    }
}
