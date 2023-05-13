package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_token_balance(链上代币余额统计表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:55
 */
public class SysTokenBalanceColumn {

    /**
     * 自增id
     */
    public static final String ID = "id";

    /**
     * 区块链币种id对应sys_token表的id
     */
    public static final String TOKEN_ID = "token_id";

    /**
     * 币种在当前钱包中的余额
     */
    public static final String BALANCE = "balance";

    /**
     * 创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}