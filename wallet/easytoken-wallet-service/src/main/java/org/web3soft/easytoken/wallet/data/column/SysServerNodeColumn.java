package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_server_node(钱包部署服务节点表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:49
 */
public class SysServerNodeColumn {

    /**
     * 钱包服务节点ID
     */
    public static final String ID = "id";

    /**
     * 钱包服务节点代号
     */
    public static final String CODE = "code";

    /**
     * 钱包服务节点名称
     */
    public static final String NAME = "name";

    /**
     * 钱包服务节点主机ip或名称
     */
    public static final String HOST = "host";

    /**
     * 是否开启充值任务,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String ENABLE_DEPOSIT = "enable_deposit";

    /**
     * 是否开启归集任务,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String ENABLE_AGGREGATE = "enable_aggregate";

    /**
     * 是否开启提现任务,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String ENABLE_WITHDRAW = "enable_withdraw";

    /**
     * 是否开启交易签名任务,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String ENABLE_SIGN = "enable_sign";

    /**
     * 是否开启统计任务,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String ENABLE_STAT = "enable_stat";

    /**
     * 是否开启数据抓取任务(如链上交易费eth gas等)0:禁用;1:启用;其他保留，默认为1
     */
    public static final String ENABLE_CRAWLER = "enable_crawler";

    /**
     * 是否需要更新节点缓存,0:禁用;1:启用;其他保留，默认为0
     */
    public static final String ENABLE_RELOAD_CACHE = "enable_reload_cache";

    /**
     * 节点状态0为禁用;1:启用;其他保留
     */
    public static final String STATUS = "status";

    /**
     * 节点备注说明
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