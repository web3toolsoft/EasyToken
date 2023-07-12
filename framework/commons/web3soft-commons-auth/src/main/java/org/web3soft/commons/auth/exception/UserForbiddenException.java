package org.web3soft.commons.auth.exception;

import java.io.Serial;

/**
 * @author web3soft-team
 */
public class UserForbiddenException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5096667470021263802L;

    public UserForbiddenException() {
        this("User status is forbidden");
    }

    /**
     * @param msg
     */
    public UserForbiddenException(final String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param t
     */
    public UserForbiddenException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
