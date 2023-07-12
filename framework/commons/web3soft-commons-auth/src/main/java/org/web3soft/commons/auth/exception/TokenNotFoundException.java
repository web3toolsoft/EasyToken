package org.web3soft.commons.auth.exception;

import java.io.Serial;

/**
 * @author web3soft-team
 */
public class TokenNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6799382702035533201L;

    public TokenNotFoundException() {
        this("Access token not found");
    }

    public TokenNotFoundException(final String msg) {
        super(msg);
    }
}
