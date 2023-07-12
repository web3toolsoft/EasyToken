package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_token(链上代币表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:52
 */
public class SysTokenColumn {

    /**
     * 区块链代币ID
     */
    public static final String ID = "id";

    /**
     * 所属币种,sys_currency的id字段
     */
    public static final String CURRENCY_ID = "currency_id";

    /**
     * 所属区块链,对应sys_chain的id字段
     */
    public static final String CHAIN_ID = "chain_id";

    /**
     * 所属代币协议(如:ERC20等),对应sys_chain_standard的id字段
     */
    public static final String STANDARD_ID = "standard_id";

    /**
     * 所属钱包服务节点,对应sys_server_node的id字段
     */
    public static final String SERVER_NODE_ID = "server_node_id";

    /**
     * 链上代币代号(唯一) 例:BTC/BTC_ERC20/ LTC/USDT_TRC20等
     */
    public static final String CODE = "code";

    /**
     * 代号名称(唯一)
     */
    public static final String NAME = "name";

    /**
     * 链上币种类型:1:主币;2:代币；其他保留
     */
    public static final String TYPE = "type";

    /**
     * 币种精度
     */
    public static final String DECIMALS = "decimals";

    /**
     * 代币地址正则表达式
     */
    public static final String ADDRESS_REGEX = "address_regex";

    /**
     * 共用地址代币代号(对应当前表的code字段)表示此币与它共用同一个充值地址，不单独创建新地址(如erc20的币种都共用eth币的地址)
     */
    public static final String ADDRESS_TOKEN_CODE = "address_token_code";

    /**
     * 链的主代币(如ETH/BNB/MATIC等）
     */
    public static final String MAIN_TOKEN_CODE = "main_token_code";

    /**
     * 代币充值/提现/分层钱包共用规范,默认为空表示使用token.code对应的工作器
     */
    public static final String SPECIFICATION = "specification";

    /**
     * 最小充值金额
     */
    public static final String MIN_DEPOSIT_AMOUNT = "min_deposit_amount";

    /**
     * 最小提现金额
     */
    public static final String MIN_WITHDRAW_AMOUNT = "min_withdraw_amount";

    /**
     * 最大提现金额
     */
    public static final String MAX_WITHDRAW_AMOUNT = "max_withdraw_amount";

    /**
     * 最小保留金额,防止Account交易模型(eth/bnb等)的币提现手续费不够
     */
    public static final String MIN_RESERVED_AMOUNT = "min_reserved_amount";

    /**
     * 提现手续费
     */
    public static final String WITHDRAW_FEES = "withdraw_fees";

    /**
     * 代币智能合约地址
     */
    public static final String CONTRACT_ADDRESS = "contract_address";

    /**
     * 是否当前币种的默认代币1表示是true;0表示否false)默认为0
     */
    public static final String ENABLE_DEFAULT = "enable_default";

    /**
     * 是否需要归集(1表示是true;0表示否false)默认为1
     */
    public static final String ENABLE_AGGREGATE = "enable_aggregate";

    /**
     * 交易签名类型1:单签;2:多签(2-3);其他保留.默认为单签
     */
    public static final String SIGN_TYPE = "sign_type";

    /**
     * 状态:0:禁用;1:启用;其他保留，默认为1
     */
    public static final String STATUS = "status";

    /**
     * 对应的表结构规范(account/utxo/omni等)
     */
    public static final String TABLE_SPECS = "table_specs";

    /**
     * 扩展属性(JSON格式)
     */
    public static final String PROPERTIES = "properties";

    /**
     * 创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}