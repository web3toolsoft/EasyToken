package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_chain_rpc_conf(链节点RPC配置表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysChainRpcConf {

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 区块链id对应sys_chain表的id
     */
    private Integer chainId;

    /**
     * 币种钱包rpc主机地址(如:ip:port)
     */
    private String host;

    /**
     * 币种钱包rpc用户名
     */
    private String username;

    /**
     * 币种钱包rpc密码
     */
    private String password;

    /**
     * 币钱rpc扩展配置(json格式)
     */
    private String properties;

    /**
     * 币种rpc配置创建时间
     */
    private Date createdAt;

    /**
     * 币种rpc配置更新时间
     */
    private Date updatedAt;

}