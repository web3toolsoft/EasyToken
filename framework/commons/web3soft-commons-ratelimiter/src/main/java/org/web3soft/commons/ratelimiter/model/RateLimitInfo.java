package org.web3soft.commons.ratelimiter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author web3soft-team
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RateLimitInfo {

    private int maxRequestTimes;

    private int seconds;

}
