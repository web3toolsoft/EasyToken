package org.web3soft.commons.security.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.web3soft.commons.dictionary.consts.AppEnvConsts;
import org.web3soft.commons.support.enums.HttpStatusCode;
import org.web3soft.commons.support.model.ResultEntity;
import org.web3soft.commons.support.util.ResultUtils;

/**
 * 全局安全相关异常处理器
 *
 * @author web3soft-team
 **/
@Slf4j
@Order(2)
@RestControllerAdvice
public class SecurityExceptionAdvice {

    /**
     * 认证异常,未授权
     */
    @Order(4)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ResultEntity<?> handleAuthenticationException(final AuthenticationException e,
                                                      final HttpServletRequest request,
                                                      final HttpServletResponse response) {
        log.warn("AuthenticationException App:{},Url:{},Reason:{},Message:{}", AppEnvConsts.APP_NAME,
                request.getRequestURL(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), e.getMessage());
        return ResultUtils.failure(HttpStatusCode.UNAUTHORIZED);
    }

    /**
     * 访问拒绝
     */
    @Order(5)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResultEntity<?> handleAccessDeniedException(final AccessDeniedException e,
                                                    final HttpServletRequest request,
                                                    final HttpServletResponse response) {
        log.warn("AccessDeniedException App:{},Url:{},Reason:{},Message:{}", AppEnvConsts.APP_NAME,
                request.getRequestURL(), HttpStatus.FORBIDDEN.getReasonPhrase(), e.getMessage());
        return ResultUtils.failure(HttpStatusCode.FORBIDDEN);
    }

}