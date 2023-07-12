package org.web3soft.commons.dictionary.enums;

/**
 * 开/关状态枚举
 *
 * @author web3soft-team
 * @date 2023/08/08
 */
public enum SwitchEnum {
    /**
     * 开
     */
    enabled(0, "enabled"),
    /**
     * 关
     */
    disabled(1, "disabled"),
    ;

    private final int id;
    private final String name;

    SwitchEnum(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static SwitchEnum fromId(final int id) {
        for (final var e : SwitchEnum.values()) {
            if (e.id == id) {
                return e;
            }
        }
        return disabled;
    }

    public static SwitchEnum fromName(final String name) {
        for (final var e : SwitchEnum.values()) {
            if (e.name.equalsIgnoreCase(name)) {
                return e;
            }
        }
        return disabled;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
