package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 针对表【sys_token_balance(链上代币余额统计表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysTokenBalance {

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 区块链币种id对应sys_token表的id
     */
    private Integer tokenId;

    /**
     * 币种在当前钱包中的余额
     */
    private BigDecimal balance;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}