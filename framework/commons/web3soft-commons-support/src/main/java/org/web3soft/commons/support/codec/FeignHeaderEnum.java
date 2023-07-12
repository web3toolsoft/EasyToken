package org.web3soft.commons.support.codec;

import lombok.Getter;

@Getter
public enum FeignHeaderEnum {

    /**
     *
     */
    ACCESS_KEY("FEIGN-ACCESS-KEY", "The access key as a string"),
    /**
     *
     */
    ACCESS_SIGN("FEIGN-ACCESS-SIGN", "The hmac256 signature"),
    /**
     *
     */
    ACCESS_TIMESTAMP("FEIGN-ACCESS-TIMESTAMP", "A timestamp for your request"),
    ;

    private final String name;
    private final String comment;

    FeignHeaderEnum(final String name, final String comment) {
        this.name = name;
        this.comment = comment;
    }
}
