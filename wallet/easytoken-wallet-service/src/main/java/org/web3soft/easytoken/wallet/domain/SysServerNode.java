package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_server_node(钱包部署服务节点表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysServerNode {

    /**
     * 钱包服务节点ID
     */
    private Integer id;

    /**
     * 钱包服务节点代号
     */
    private String code;

    /**
     * 钱包服务节点名称
     */
    private String name;

    /**
     * 钱包服务节点主机ip或名称
     */
    private String host;

    /**
     * 是否开启充值任务,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer enableDeposit;

    /**
     * 是否开启归集任务,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer enableAggregate;

    /**
     * 是否开启提现任务,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer enableWithdraw;

    /**
     * 是否开启交易签名任务,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer enableSign;

    /**
     * 是否开启统计任务,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer enableStat;

    /**
     * 是否开启数据抓取任务(如链上交易费eth gas等)0:禁用;1:启用;其他保留，默认为1
     */
    private Integer enableCrawler;

    /**
     * 是否需要更新节点缓存,0:禁用;1:启用;其他保留，默认为0
     */
    private Integer enableReloadCache;

    /**
     * 节点状态0为禁用;1:启用;其他保留
     */
    private Integer status;

    /**
     * 节点备注说明
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