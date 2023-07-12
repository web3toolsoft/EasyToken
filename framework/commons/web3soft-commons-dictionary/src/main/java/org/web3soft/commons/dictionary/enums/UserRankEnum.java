package org.web3soft.commons.dictionary.enums;

/**
 * 用户在系统中的等级,不同的等级将来有不同的权益(如提限限额,手续费优惠等)
 *
 * @author web3soft-team
 */
public enum UserRankEnum {
    /**
     * 等级0
     */
    R0("r0"),
    /**
     * 等级1
     */
    R1("r1"),
    /**
     * 等级2
     */
    R2("r2"),
    /**
     * 等级3
     */
    R3("r3"),
    /**
     * 等级4
     */
    R4("r4"),
    /**
     * 等级5
     */
    R5("r5"),
    /**
     * VIP1
     */
    VIP1("vip1"),
    /**
     * VIP2
     */
    VIP2("vip2"),
    ;

    private final String name;

    UserRankEnum(final String name) {
        this.name = name;
    }

    public static UserRankEnum forName(final String name) {
        for (final var value : UserRankEnum.values()) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return UserRankEnum.R0;
    }

    public String getName() {
        return this.name;
    }
}
