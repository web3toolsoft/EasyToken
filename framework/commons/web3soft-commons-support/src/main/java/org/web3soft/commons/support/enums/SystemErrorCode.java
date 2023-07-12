package org.web3soft.commons.support.enums;

import org.web3soft.commons.i18n.MessageSourceUtils;

/**
 * @author web3soft-team
 **/
public enum SystemErrorCode implements ErrorCode {
    /**
     *
     */
    SUCCESS(0),
    /**
     *
     */
    SYSTEM_ERROR(1),
    /**
     *
     */
    UNKNOWN_ERROR(2),
    /**
     *
     */
    HTTP_MESSAGE_NOT_READABLE(900),
    /**
     *
     */
    DATA_VALIDATION_FAILURE(901),
    /**
     *
     */
    DATA_BIND_VALIDATION_FAILURE(902),
    /**
     *
     */
    SQL_EXECUTE_FAILURE(903),
    /**
     *
     */
    METHOD_ARGUMENT_NOT_VALID(904),
    /**
     * API Disabled
     */
    API_DISABLED(905),
    /**
     * feign error
     */
    FEIGN_EXCEPTION(906),
    /**
     * hystrix error
     */
    HYSTRIX_EXCEPTION(907),
    /**
     * 无效feign调用签名
     */
    INVALID_METHOD_ACCESS_SIGN(908),
    /**
     * feign调用签名已经过期
     */
    EXPIRED_METHOD_ACCESS_SIGN(909),
    ;

    private final int code;
    private Object[] args;

    SystemErrorCode(final int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.getMessage(this.args);
    }

    @Override
    public String getMessage(final Object... args) {
        return MessageSourceUtils.getMessage("commons.sys." + this.code, args);
    }

    @Override
    public ErrorCode arguments(final Object... args) {
        this.args = args;
        return this;
    }

    @Override
    public String toString() {
        return "[" + this.getCode() + "]" + this.getMessage();
    }
}
