package org.web3soft.commons.mybatis.sample.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 持久化类
 *
 * @author web3soft-team
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -6467828739697732856L;
    /**
     * 系统用户标识
     */
    private Integer id;
    /**
     * 系统用户所属角色集合(role_id以英文逗号分隔)
     */
    @Length(max = 20, message = "{member.user.roles.Length}")
    private String roles;
    /**
     * 系统用户账号
     */
    @Length(min = 8, max = 20, message = "{member.user.account.Length}")
    private String account;
    /**
     * 系统用户密码
     */
    @Length(max = 64)
    private String password;
    /**
     * 加盐
     */
    private String salt;
    /**
     * 系统用户姓名
     */

    @Length(max = 20)
    private String name;
    /**
     * 系统用户电子邮箱
     */
    @Email
    private String email;
    /**
     * 系统用户用户电话号码,多个用英文逗号分开
     */
    @Length(max = 13)
    private String telephone;
    /**
     * 系统用户的状态,1表示启用,0表示禁用,默认为1,其他保留
     */
    @NotNull
    private Byte status;
    /**
     * 系统用户备注
     */
    @NotNull
    private String comment;
    /**
     * 系统用户记录创建时间
     */
    private Date gmtCreated;
    /**
     * 系统用户记录更新时间戳
     */
    private Date gmtModified;

}
