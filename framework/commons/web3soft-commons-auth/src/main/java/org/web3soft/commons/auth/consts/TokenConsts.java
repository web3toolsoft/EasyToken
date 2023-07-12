package org.web3soft.commons.auth.consts;

public class TokenConsts {
    /**
     * cookie中存储token的属性名
     */
    public static final String TOKEN = "token";
    /**
     * http header中存储设备唯一编号的属性名
     */
    public static final String X_DEV_ID = "x-dev-id";
    /**
     * 用户状态为:不存在的用户
     */
    public static final Integer STATUS_NOT_EXISTS = -1;
    /**
     * 用户状态为:正常登录状用户
     */
    public static final Integer STATUS_NORMAL = 0;
    /**
     * 用户状态为:禁用 表示所有系统都不能登录
     */
    public static final int STATUS_FORBIDDEN = 1;
    /**
     * 用户状态为:需要二次验证
     */
    public static final Integer STATUS_TWO_FACTOR = 2;

}
