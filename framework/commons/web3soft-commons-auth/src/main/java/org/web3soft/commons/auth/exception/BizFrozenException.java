package org.web3soft.commons.auth.exception;

import java.io.Serial;

/**
 * @author web3soft-team
 */
public class BizFrozenException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -620974336081301813L;

    public BizFrozenException() {
        this("Business is frozen");
    }

    /**
     * @param msg
     */
    public BizFrozenException(final String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param t
     */
    public BizFrozenException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
