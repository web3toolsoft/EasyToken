package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_chain_rpc_conf(链节点RPC配置表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:31
 */
public class SysChainRpcConfColumn {

    /**
     * 自增id
     */
    public static final String ID = "id";

    /**
     * 区块链id对应sys_chain表的id
     */
    public static final String CHAIN_ID = "chain_id";

    /**
     * 币种钱包rpc主机地址(如:ip:port)
     */
    public static final String HOST = "host";

    /**
     * 币种钱包rpc用户名
     */
    public static final String USERNAME = "username";

    /**
     * 币种钱包rpc密码
     */
    public static final String PASSWORD = "password";

    /**
     * 币钱rpc扩展配置(json格式)
     */
    public static final String PROPERTIES = "properties";

    /**
     * 币种rpc配置创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 币种rpc配置更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}