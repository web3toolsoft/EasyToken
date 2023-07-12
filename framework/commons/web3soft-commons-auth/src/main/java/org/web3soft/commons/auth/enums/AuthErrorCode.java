package org.web3soft.commons.auth.enums;

import org.web3soft.commons.i18n.MessageSourceUtils;
import org.web3soft.commons.support.enums.ErrorCode;

/**
 * @author web3soft-team
 */
public enum AuthErrorCode implements ErrorCode {
    /**
     *
     */
    EXPIRATION(800),
    /**
     *
     */
    INVALID(801),
    /**
     *
     */
    FORBIDDEN(803),
    /**
     *
     */
    ABNORMAL_ACCESS(804),
    /**
     *
     */
    BIZ_FROZEN(805),
    ;

    private final int code;
    private Object[] args;

    AuthErrorCode(final int code) {
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
        return MessageSourceUtils.getMessage("commons.auth." + this.code, args);
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
