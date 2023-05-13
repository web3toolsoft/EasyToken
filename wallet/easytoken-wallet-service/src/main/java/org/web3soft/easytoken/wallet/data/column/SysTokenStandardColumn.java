package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_token_standard(链上币种协议表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:58
 */
public class SysTokenStandardColumn {

    /**
     * 链上代币协议id
     */
    public static final String ID = "id";

    /**
     * 区块链ID,对应sys_chain的ID字段
     */
    public static final String CHAIN_ID = "chain_id";

    /**
     * 协议代号 例:ERC20/TRC20/EIP20/BIP20等
     */
    public static final String CODE = "code";

    /**
     * 备注说明
     */
    public static final String MEMO = "memo";

    /**
     * 创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}