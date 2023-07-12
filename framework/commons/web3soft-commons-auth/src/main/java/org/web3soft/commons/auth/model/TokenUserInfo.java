package org.web3soft.commons.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author web3soft-team
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenUserInfo  {
    /**
     * 父id
     */
    @Builder.Default
    private final Long parentId = 0L;
    /**
     * 直接上级合伙人ID
     */
    @Builder.Default
    private final Long partnerId = 0L;
    /**
     * 登录唯一序号uuid
     */
    @JsonIgnore
    private String sid;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 登录用户名(手机号或邮箱地址)
     */
    private String username;
    /**
     * 登录ip地址
     */
    private Long ip;
    /**
     * 登录设备id
     */
    private String devId;
    /**
     * 用户状态0为开启，1为禁用，其他保留，默认为0
     */
    private Integer status;
    /**
     * 是否禁用提币 1表示是,0表示否，默认为0
     */
    private Integer withdraw;
    /**
     * 用户账号全局冻结状态 1已冻结;0未冻结 默认为0
     */
    private Integer frozenAll;
    /**
     * 登录时间
     */
    private Date created;
    /**
     * 过期时间
     */
    private Date expired;
    /**
     * 0表示普通用户,1表示一级合伙人,2表示普通合伙人
     */
    private Integer type;

    /**
     * 当前用户是否不存在
     *
     * @return true|false
     */
    @JsonIgnore
    public boolean isNotExists() {
        return Integer.valueOf(-1).equals(this.status);
    }

    /**
     * 当前用户是否被禁用
     *
     * @return true|false
     */
    @JsonIgnore
    public boolean isForbidden() {
        return Integer.valueOf(1).equals(this.status);
    }

    /**
     * 当前用户是否被禁用提币
     *
     * @return true|false
     */
    @JsonIgnore
    public boolean isDisableWithdraw() {
        return Integer.valueOf(1).equals(this.withdraw);
    }

    /**
     * 当前用户所有的交易业务是否被冻结
     *
     * @return true|false
     */
    @JsonIgnore
    public boolean isFrozenAll() {
        return Integer.valueOf(1).equals(this.frozenAll);
    }

    /**
     * 当前登录用户是否来自同一IP请求
     *
     * @param currentIp 当前请求IP地址
     * @return true|false
     */
    @JsonIgnore
    public boolean isNotFromSameIp(final long currentIp) {
        return !Long.valueOf(currentIp).equals(this.ip);
    }

    /**
     * 当前登录用户是否来自同一设备请求
     *
     * @param currentDevId 当前请求设备号
     * @return true|false
     */
    @JsonIgnore
    public boolean isNotFromSameDevice(final String currentDevId) {
        return !StringUtils.equals(this.devId, currentDevId);
    }
}
