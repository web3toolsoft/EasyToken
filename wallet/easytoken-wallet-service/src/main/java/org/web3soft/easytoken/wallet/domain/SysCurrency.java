package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_currency(币种表)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysCurrency {

    /**
     * 币种唯一id
     */
    private Integer id;

    /**
     * 币种代号 例:BTC LTC
     */
    private String code;

    /**
     * 币种符号
     */
    private String symbol;

    /**
     * 币种名称
     */
    private String name;

    /**
     * 状态:,0:禁用;1:启用;其他保留，默认为1
     */
    private Integer status;

    /**
     * 类型0表示链上币种;1表示非链上币种;默认为0
     */
    private Integer type;

    /**
     * 币种LOGO图地址
     */
    private String logoUrl;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}