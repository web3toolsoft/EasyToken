package org.web3soft.commons.web.aop;

import com.google.common.collect.Maps;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.web3soft.commons.lang.util.JsonUtil;
import org.web3soft.commons.support.annotation.OpLog;

import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.Objects;

/**
 * @author web3soft-team
 **/
@Slf4j
public class OpLogAspect {
    @Pointcut("@annotation(org.web3soft.commons.support.annotation.OpLog)")
    public void pointcut() {
    }

    @After(value = "pointcut() && @annotation(opLog)")
    public void doAfter(final JoinPoint joinPoint, final OpLog opLog) {
        try {
            this.logEvent(joinPoint, "INFO", "", opLog.name(), opLog.desc(), opLog.type());
        } catch (final Exception e) {
            log.error("异常信息", e);
        }
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void doAfterThrowing(final JoinPoint joinPoint, final Throwable e) {
        try {
            this.logEvent(joinPoint, "ERROR", ExceptionUtils.getStackTrace(e), "System ERROR", "", "");
        } catch (final Exception ex) {
            log.error("异常信息:{}", ex.getMessage());
        }
    }

    protected void logEvent(final JoinPoint joinPoint,
                            final String level, final String message, final String logName, final String logDesc, final String logType) {
        try {
            final EventParameter eventParameter = this.getEventParameter(joinPoint, level, message, logName, logDesc, logType);
            this.logEvent(eventParameter);
        } catch (final Exception e) {
            log.error("记录系统事件出错", e);
        }
    }

    protected void logEvent(final EventParameter eventParameter) {
        final HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        eventParameter.setUrl(req.getRequestURL().toString());
        log.info("OpLog:{}", eventParameter);
    }

    protected EventParameter getEventParameter(final JoinPoint joinPoint,
                                               final String level,
                                               final String message,
                                               final String logName,
                                               final String logDesc,
                                               final String logType) {
        final EventParameter eventParameter = new EventParameter();
        final String targetName = joinPoint.getTarget().getClass().getName();
        final String methodName = joinPoint.getSignature().getName();

        final Map<String, Object> paramMap = this.getMethodParameters(joinPoint);
        eventParameter.setSource(targetName + ":" + methodName);
        eventParameter.setLevel(level);
        eventParameter.setMessage(message);
        eventParameter.setName(logName);
        eventParameter.setDesc(logDesc);
        eventParameter.setType(logType);
        eventParameter.setArguments(JsonUtil.toJSONString(paramMap));

        return eventParameter;
    }

    private Map<String, Object> getMethodParameters(final JoinPoint joinPoint) {
        final Object[] args = joinPoint.getArgs();
        final Map<String, Object> paramMap = Maps.newHashMapWithExpectedSize(16);
        final String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        final Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameters();
        for (int i = 0; i < parameters.length; i++) {
            final String paramName = names[i];
            final Object paramValue = args[i];
            if ((paramValue instanceof HttpServletRequest) || (paramValue instanceof HttpServletResponse)) {
                continue;
            }
            paramMap.put(paramName, paramValue);
        }
        return paramMap;
    }

    /**
     * 事件参数类
     */
    @Data
    public static class EventParameter {
        /**
         * 事件来源
         */
        private String source;
        /**
         * 事件级别
         */
        private String level;
        /**
         * 事件名称
         */
        private String name;
        /**
         * 事件说明
         */
        private String desc;
        /**
         * 事件类型
         */
        private String type;
        /**
         * 事件调用方法参数
         */
        private String arguments;
        /**
         * 事件信息
         */
        private String message;
        /**
         * 事件请求url
         */
        private String url;
        /**
         * 登录用户id
         */
        private Long loginUserId;
    }
}

