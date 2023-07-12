package org.web3soft.commons.fileupload;

/**
 * @author web3soft-team
 */
public enum CannedAclEnum {
    /**
     * 指定所有者具有继承控制权限
     * 仅供设置Object ACL时使用。
     */
    Default("default"),

    /**
     * 指定只有所有者具有完全控制权限
     * 其他用户无权访问。
     */
    Private("private"),

    /**
     * 指定所有者具有完全控制权限
     * 其他用户只有只读权限
     */
    PublicRead("public-read"),

    /**
     * 指定所有者和其他用户均有完全控制权限
     * 不推荐使用。
     */
    PublicReadWrite("public-read-write");

    private final String cannedAclName;

    CannedAclEnum(final String cannedAclName) {
        this.cannedAclName = cannedAclName;
    }

    public static CannedAclEnum parse(final String name) {
        for (final var cannedAcl : CannedAclEnum.values()) {
            if (cannedAcl.toString().equals(name)) {
                return cannedAcl;
            }
        }

        throw new IllegalArgumentException("Unable to parse the provided acl " + name);
    }

    @Override
    public String toString() {
        return this.cannedAclName;
    }
}
