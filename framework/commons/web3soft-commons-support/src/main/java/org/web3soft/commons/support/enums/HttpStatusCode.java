package org.web3soft.commons.support.enums;

import org.web3soft.commons.i18n.MessageSourceUtils;

import java.util.Arrays;

/**
 * @author web3soft-team
 **/
public enum HttpStatusCode implements ErrorCode {
    /**
     * http status code:400
     */
    BAD_REQUEST(400),
    /**
     * http status code:401
     */
    UNAUTHORIZED(401),
    /**
     * http status code:403
     */
    FORBIDDEN(403),
    /**
     * http status code:404
     */
    NOT_FOUND(404),
    /**
     * http status code:405
     */
    METHOD_NOT_ALLOWED(405),
    /**
     * http status code:415
     */
    UNSUPPORTED_MEDIA_TYPE(415),
    /**
     * http status code:500
     */
    INTERNAL_SERVER_ERROR(500),
    ;

    private final int code;
    private Object[] args;

    HttpStatusCode(final int code) {
        this.code = code;
    }

    public static HttpStatusCode valueOf(final int code) {
        return Arrays.stream(HttpStatusCode.values())
                .filter(x -> x.getCode() == code)
                .findFirst()
                .orElse(HttpStatusCode.INTERNAL_SERVER_ERROR);
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
        return MessageSourceUtils.getMessage("commons.httpstatus." + this.code, args);
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
