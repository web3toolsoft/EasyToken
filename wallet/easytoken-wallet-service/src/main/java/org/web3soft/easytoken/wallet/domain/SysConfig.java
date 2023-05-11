package org.web3soft.easytoken.wallet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 针对表【sys_config(配置表:name/value结构)】的实体类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:41
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysConfig {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 配置项(唯一)
     */
    private String configName;

    /**
     * 配置项对应值
     */
    private String configValue;

    /**
     * 配置项说明
     */
    private String configRemark;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}