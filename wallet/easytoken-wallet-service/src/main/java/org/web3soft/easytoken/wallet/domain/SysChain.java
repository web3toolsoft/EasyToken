package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_chain(区块链网络表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysChain {

    /**
     * 区块链id
     */
    private Integer id;

    /**
     * 所属链ID如果没有则为0
     */
    private Integer parentId;

    /**
     * 区块链代号 例:BTC LTC
     */
    private String code;

    /**
     * 区块链名称
     */
    private String name;

    /**
     * 类型,chain表示链;standard表示协议,默认为chain
     */
    private String type;

    /**
     * 出块时间(秒)
     */
    private Integer intervals;

    /**
     * 状态:,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer status;

    /**
     * 网络确认数
     */
    private Integer confirmations;

    /**
     * 是否需要定时获取网络交易费(如eth gas fee等),0:不需要;1:需要;默认为1
     */
    private Integer enableTrackFee;

    /**
     * 充值/提现/分层钱包共用规范,默认为空表示使用链code对应的工作器
     */
    private String specification;

    /**
     * 区块记录查询URL
     */
    private String blockUrl;

    /**
     * 交易记录查询URL
     */
    private String txUrl;

    /**
     * 交易费抓取网站URL
     */
    private String txFeeUrl;

    /**
     * 区块链扩展属性(JSON格式)
     */
    private String properties;

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