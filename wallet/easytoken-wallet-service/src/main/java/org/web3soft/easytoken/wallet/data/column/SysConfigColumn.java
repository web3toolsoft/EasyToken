package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_config(配置表:name/value结构)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:42
 */
public class SysConfigColumn {

    /**
     * 自增ID
     */
    public static final String ID = "id";

    /**
     * 配置项(唯一)
     */
    public static final String CONFIG_NAME = "config_name";

    /**
     * 配置项对应值
     */
    public static final String CONFIG_VALUE = "config_value";

    /**
     * 配置项说明
     */
    public static final String CONFIG_REMARK = "config_remark";

    /**
     * 创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}