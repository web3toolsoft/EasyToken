package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 针对表【sys_token(链上代币表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysToken {

    /**
     * 区块链代币ID
     */
    private Integer id;

    /**
     * 所属币种,sys_currency的id字段
     */
    private Integer currencyId;

    /**
     * 所属区块链,对应sys_chain的id字段
     */
    private Integer chainId;

    /**
     * 所属代币协议(如:ERC20等),对应sys_chain_standard的id字段
     */
    private Integer standardId;

    /**
     * 所属钱包服务节点,对应sys_server_node的id字段
     */
    private Integer serverNodeId;

    /**
     * 链上代币代号(唯一) 例:BTC/BTC_ERC20/ LTC/USDT_TRC20等
     */
    private String code;

    /**
     * 代号名称(唯一)
     */
    private String name;

    /**
     * 链上币种类型:1:主币;2:代币；其他保留
     */
    private Integer type;

    /**
     * 币种精度
     */
    private Integer decimals;

    /**
     * 代币地址正则表达式
     */
    private String addressRegex;

    /**
     * 共用地址代币代号(对应当前表的code字段)表示此币与它共用同一个充值地址，不单独创建新地址(如erc20的币种都共用eth币的地址)
     */
    private String addressTokenCode;

    /**
     * 链的主代币(如ETH/BNB/MATIC等）
     */
    private String mainTokenCode;

    /**
     * 代币充值/提现/分层钱包共用规范,默认为空表示使用token.code对应的工作器
     */
    private String specification;

    /**
     * 最小充值金额
     */
    private BigDecimal minDepositAmount;

    /**
     * 最小提现金额
     */
    private BigDecimal minWithdrawAmount;

    /**
     * 最大提现金额
     */
    private BigDecimal maxWithdrawAmount;

    /**
     * 最小保留金额,防止Account交易模型(eth/bnb等)的币提现手续费不够
     */
    private BigDecimal minReservedAmount;

    /**
     * 提现手续费
     */
    private BigDecimal withdrawFees;

    /**
     * 代币智能合约地址
     */
    private String contractAddress;

    /**
     * 是否当前币种的默认代币1表示是true;0表示否false)默认为0
     */
    private Integer enableDefault;

    /**
     * 是否需要归集(1表示是true;0表示否false)默认为1
     */
    private Integer enableAggregate;

    /**
     * 交易签名类型1:单签;2:多签(2-3);其他保留.默认为单签
     */
    private Integer signType;

    /**
     * 状态:0:禁用;1:启用;其他保留，默认为1
     */
    private Integer status;

    /**
     * 对应的表结构规范(account/utxo/omni等)
     */
    private String tableSpecs;

    /**
     * 扩展属性(JSON格式)
     */
    private String properties;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}