package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_token_standard(链上币种协议表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysTokenStandard {

    /**
     * 链上代币协议id
     */
    private Integer id;

    /**
     * 区块链ID,对应sys_chain的ID字段
     */
    private Integer chainId;

    /**
     * 协议代号 例:ERC20/TRC20/EIP20/BIP20等
     */
    private String code;

    /**
     * 备注说明
     */
    private String memo;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}