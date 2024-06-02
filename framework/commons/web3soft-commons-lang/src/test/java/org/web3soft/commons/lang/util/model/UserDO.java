package org.web3soft.commons.lang.util.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author web3soft-team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    private String firstName;
    private String lastName;
    private Integer weight;
    private Integer height;
    private String sex;
    private Integer age;
    private BigDecimal assets;
}
