package org.web3soft.commons.auth.exception;

import java.io.Serial;

/**
 * @author web3soft-team
 */
public class TokenInvalidException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5261538038358898537L;

    public TokenInvalidException() {
        this("Token is invalid");
    }

    /**
     * @param msg
     */
    public TokenInvalidException(final String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param t
     */
    public TokenInvalidException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
