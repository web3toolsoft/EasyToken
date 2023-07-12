package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_chain_latest_block(链当前扫描的最新区块高度记录表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:28
 */
public class SysChainLatestBlockColumn {

    /**
     * 自增ID
     */
    public static final String ID = "id";

    /**
     * 钱包服务节点Id,对应sys_server_node的id字段
     */
    public static final String SERVER_NODE_ID = "server_node_id";

    /**
     * 区块链id对应sys_chain表的id
     */
    public static final String CHAIN_ID = "chain_id";

    /**
     * 当前钱包扫描区块高度
     */
    public static final String HEIGHT = "height";

    /**
     * 创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}