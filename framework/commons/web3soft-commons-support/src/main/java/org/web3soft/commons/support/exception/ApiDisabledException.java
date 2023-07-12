package org.web3soft.commons.support.exception;

import lombok.Getter;
import org.web3soft.commons.support.enums.ErrorCode;

import java.io.Serial;

/**
 * API不可用异常
 *
 * @author web3soft-team
 */
@Getter
public class ApiDisabledException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 234122996006267330L;
    private int code;

    public ApiDisabledException() {
        super();
    }

    public ApiDisabledException(final String msg) {
        super(msg);
    }

    public ApiDisabledException(final ErrorCode errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    public ApiDisabledException(final ErrorCode errorCodeEnum, final Throwable cause) {
        super(errorCodeEnum.getMessage(), cause);
    }
}
