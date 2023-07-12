package org.web3soft.commons.auth.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

/**
 * @author web3soft-team
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionConfig {
    private Duration maxInactiveInterval;
}
