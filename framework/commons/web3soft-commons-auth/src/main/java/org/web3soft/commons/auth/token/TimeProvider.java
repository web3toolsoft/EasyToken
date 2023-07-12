package org.web3soft.commons.auth.token;

import java.util.Date;

/**
 * @author web3soft-team
 */
public class TimeProvider {
    public static Date now() {
        return new Date();
    }
}
