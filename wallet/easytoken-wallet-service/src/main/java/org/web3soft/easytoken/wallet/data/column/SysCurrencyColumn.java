package org.web3soft.easytoken.wallet.data.column;

/**
 * 针对表【sys_currency(币种表)】列名类
 *
 * @author Tom Deng
 * @date 2023-05-13 20:56:45
 */
public class SysCurrencyColumn {

    /**
     * 币种唯一id
     */
    public static final String ID = "id";

    /**
     * 币种代号 例:BTC LTC
     */
    public static final String CODE = "code";

    /**
     * 币种符号
     */
    public static final String SYMBOL = "symbol";

    /**
     * 币种名称
     */
    public static final String NAME = "name";

    /**
     * 状态:,0:禁用;1:启用;其他保留，默认为1
     */
    public static final String STATUS = "status";

    /**
     * 类型0表示链上币种;1表示非链上币种;默认为0
     */
    public static final String TYPE = "type";

    /**
     * 币种LOGO图地址
     */
    public static final String LOGO_URL = "logo_url";

    /**
     * 创建时间
     */
    public static final String CREATED_AT = "created_at";

    /**
     * 更新时间
     */
    public static final String UPDATED_AT = "updated_at";

}