package org.web3soft.commons.web.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3soft.commons.support.annotation.SignMethod;
import org.web3soft.commons.support.codec.DigestCryptService;
import org.web3soft.commons.support.codec.FeignHeaderEnum;
import org.web3soft.commons.support.enums.SystemErrorCode;
import org.web3soft.commons.support.util.ResultUtils;

import java.time.Instant;

/**
 * @author web3soft-team
 */
@Slf4j
@Aspect
@Component
public class SignMethodAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private DigestCryptService digestCryptService;

    @Pointcut(value = "@annotation(org.web3soft.commons.support.annotation.SignMethod)")
    private void pointcut() {
    }

    @Around(value = "pointcut() && @annotation(signMethod)")
    public Object around(final ProceedingJoinPoint point, final SignMethod signMethod) {
        try {
            if (this.digestCryptService.isEnableSignMethod()) {
                final String accessSign = this.request.getHeader(FeignHeaderEnum.ACCESS_SIGN.getName());
                final long accessTimestamp = NumberUtils.toLong(this.request.getHeader(FeignHeaderEnum.ACCESS_TIMESTAMP.getName()), 0L);
                if (this.checkTimestamp(accessTimestamp)) {
                    return ResultUtils.failure(SystemErrorCode.EXPIRED_METHOD_ACCESS_SIGN);
                }
                final String currSign = this.digestCryptService.generateSignature(accessTimestamp);
                final boolean matches = this.digestCryptService.validateSignature(accessSign, currSign);
                log.debug("access-sign:[{}],curr sign:[{}],matches:[{}]", accessSign, currSign, matches);
                return matches ? point.proceed() : ResultUtils.failure(SystemErrorCode.INVALID_METHOD_ACCESS_SIGN);
            }
            return point.proceed();
        } catch (final Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkTimestamp(final long accessTimestamp) {
        final long currTimestamp = Instant.now().getEpochSecond();
        final long sub = Math.abs(currTimestamp - accessTimestamp);
        final long expired = this.digestCryptService.getSignMethodExpired().getSeconds();
        log.debug("access timestamp:[{}],current:[{}],expired:[{}],sub:[{}]", accessTimestamp, currTimestamp, expired, sub);
        return sub > expired;
    }
}

