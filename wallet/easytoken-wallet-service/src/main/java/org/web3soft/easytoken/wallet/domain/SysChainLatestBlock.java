package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_chain_latest_block(链当前扫描的最新区块高度记录表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysChainLatestBlock {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 钱包服务节点Id,对应sys_server_node的id字段
     */
    private Integer serverNodeId;

    /**
     * 区块链id对应sys_chain表的id
     */
    private Object chainId;

    /**
     * 当前钱包扫描区块高度
     */
    private Long height;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}