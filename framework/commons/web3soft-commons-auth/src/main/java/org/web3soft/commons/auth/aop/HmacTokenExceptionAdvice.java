package org.web3soft.commons.auth.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.web3soft.commons.auth.enums.AuthErrorCode;
import org.web3soft.commons.auth.exception.AbnormalAccessException;
import org.web3soft.commons.auth.exception.BizFrozenException;
import org.web3soft.commons.auth.exception.SessionExpiredException;
import org.web3soft.commons.auth.exception.TokenNotFoundException;
import org.web3soft.commons.auth.exception.UserForbiddenException;
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
@Order(1)
@RestControllerAdvice
//@ConditionalOnProperty(
//        prefix = "web3soft.auth.hmac.exception-advice", name = "enabled", matchIfMissing = true
//)
public class HmacTokenExceptionAdvice {
    /**
     * 没有找到token,未授权
     */
    @Order(1)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenNotFoundException.class)
    public ResultEntity<?> handleTokenNotFoundException(final TokenNotFoundException e,
                                                        final HttpServletRequest request,
                                                        final HttpServletResponse response) {
        log.warn("TokenNotFoundException App:{},Url:{},Message:{}",
                AppEnvConsts.APP_NAME, request.getRequestURL(), e.getMessage());
        return ResultUtils.failure(HttpStatusCode.UNAUTHORIZED);
    }

    /**
     * 登录session过期
     */
    @Order(2)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(SessionExpiredException.class)
    public ResultEntity<?> handleSessionExpiredException(final SessionExpiredException e,
                                                      final HttpServletRequest request,
                                                      final HttpServletResponse response) {
        log.warn("SessionExpiredException App:{},Url:{},Message:{}",
                AppEnvConsts.APP_NAME, request.getRequestURL(), e.getMessage());
        return ResultUtils.failure(AuthErrorCode.EXPIRATION);
    }

    /**
     * token被禁用
     */
    @Order(5)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UserForbiddenException.class)
    public ResultEntity<?> handleUserForbiddenException(final UserForbiddenException e,
                                                     final HttpServletRequest request,
                                                     final HttpServletResponse response) {
        log.warn("UserForbiddenException App:{},Url:{},Message:{}",
                AppEnvConsts.APP_NAME, request.getRequestURL(), e.getMessage());
        return ResultUtils.failure(AuthErrorCode.FORBIDDEN);
    }

    /**
     * 非正常访问
     */
    @Order(6)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AbnormalAccessException.class)
    public ResultEntity<?> handleAbnormalAccessException(final AbnormalAccessException e,
                                                      final HttpServletRequest request,
                                                      final HttpServletResponse response) {
        log.warn("AbnormalAccessException App:{},Url:{},Message:{}",
                AppEnvConsts.APP_NAME, request.getRequestURL(), e.getMessage());
        return ResultUtils.failure(AuthErrorCode.ABNORMAL_ACCESS);
    }

    /**
     * 业务已经冻结
     */
    @Order(7)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(BizFrozenException.class)
    public ResultEntity<?> handleBizFrozenException(final BizFrozenException e,
                                                 final HttpServletRequest request,
                                                 final HttpServletResponse response) {
        log.warn("BizFrozenException App:{},Url:{},Message:{}",
                AppEnvConsts.APP_NAME, request.getRequestURL(), e.getMessage());
        return ResultUtils.failure(AuthErrorCode.BIZ_FROZEN);
    }
}