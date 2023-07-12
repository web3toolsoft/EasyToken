package org.web3soft.commons.auth.token.jwt.exception;

import java.io.Serial;

/**
 * jwt token 过期异常
 *
 * @author web3soft-team
 */
public class JwtTokenExpiredException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5702621486887269225L;

    public JwtTokenExpiredException() {
        this("Token is Expired");
    }

    /**
     * @param msg
     */
    public JwtTokenExpiredException(final String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param t
     */
    public JwtTokenExpiredException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
