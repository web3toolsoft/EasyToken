package org.web3soft.commons.security;

import java.util.Set;

/**
 * 用户权限服务外观接口
 *
 * @param <User> 用户信息对象
 * @author web3soft-team
 */
public interface MembershipFacade<User> {

    /**
     * 获取登录用户信息不包含密码等敏感数据
     *
     * @param account a {@link String} object.
     * @return a User object.
     */
    User getUserNonSensitiveInfo(String account);

    /**
     * 获取登录用户信息、包含密码等敏感数据
     *
     * @param account a {@link String} object.
     * @return a User object.
     */
    User getUser(String account);

    /**
     * <p>getRoleNames.</p>
     *
     * @param roleIds a {@link String} object.
     * @return a {@link String} object.
     */
    String getRoleNames(String roleIds);

    /**
     * 获取登录用户所有角色编号
     *
     * @param roleIds a {@link String} object.
     * @return a {@link String} object.
     */
    String getCodes(final String roleIds);

    /**
     * <p>getRoleSet.</p>
     *
     * @param roleIds a {@link String} object.
     * @return a {@link Set} object.
     */
    Set<String> getRoleSet(String roleIds);

    /**
     * <p>getPermissionSet.</p>
     *
     * @param roleIds a {@link String} object.
     * @return a {@link Set} object.
     */
    Set<String> getPermissionSet(String roleIds);

    /**
     * <p>hasPermission.</p>
     *
     * @param roleIds a {@link String} object.
     * @param codes   a {@link String} object.
     * @return a boolean.
     */
    boolean hasPermission(String roleIds, String... codes);

    /**
     * <p>isAdministrator.</p>
     *
     * @param roleIds a {@link String} object.
     * @return a boolean.
     */
    boolean isAdministrator(String roleIds);
}
