package org.web3soft.commons.auth.exception;

import java.io.Serial;

/**
 * Session过期异常
 *
 * @author web3soft-team
 */
public class SessionExpiredException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3304219758406296703L;

    public SessionExpiredException() {
        this("Session is Expired");
    }

    public SessionExpiredException(final String msg) {
        super(msg);
    }

    public SessionExpiredException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
