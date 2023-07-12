package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_chain(区块链网络表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:25
 */
public class SysChainColumn {

    /**
     * 区块链id
     */
    public static final String ID = "id";

    /**
     * 所属链ID如果没有则为0
     */
    public static final String PARENT_ID = "parent_id";

    /**
     * 区块链代号 例:BTC LTC
     */
    public static final String CODE = "code";

    /**
     * 区块链名称
     */
    public static final String NAME = "name";

    /**
     * 类型,chain表示链;standard表示协议,默认为chain
     */
    public static final String TYPE = "type";

    /**
     * 出块时间(秒)
     */
    public static final String INTERVALS = "intervals";

    /**
     * 状态:,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String STATUS = "status";

    /**
     * 网络确认数
     */
    public static final String CONFIRMATIONS = "confirmations";

    /**
     * 是否需要定时获取网络交易费(如eth gas fee等),0:不需要;1:需要;默认为1
     */
    public static final String ENABLE_TRACK_FEE = "enable_track_fee";

    /**
     * 充值/提现/分层钱包共用规范,默认为空表示使用链code对应的工作器
     */
    public static final String SPECIFICATION = "specification";

    /**
     * 区块记录查询URL
     */
    public static final String BLOCK_URL = "block_url";

    /**
     * 交易记录查询URL
     */
    public static final String TX_URL = "tx_url";

    /**
     * 交易费抓取网站URL
     */
    public static final String TX_FEE_URL = "tx_fee_url";

    /**
     * 区块链扩展属性(JSON格式)
     */
    public static final String PROPERTIES = "properties";

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