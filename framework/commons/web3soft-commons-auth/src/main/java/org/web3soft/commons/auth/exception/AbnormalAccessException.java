package org.web3soft.commons.auth.exception;

import java.io.Serial;

/**
 * @author web3soft-team
 */
public class AbnormalAccessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5185175162192557575L;

    public AbnormalAccessException() {
        this("abnormal access,current request's ip or device id is changed");
    }

    public AbnormalAccessException(final String msg) {
        super(msg);
    }

    public AbnormalAccessException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
