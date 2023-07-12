package org.web3soft.commons.dictionary.enums;

/**
 * 资金划转类型
 *
 * @author web3soft-team
 */
public enum TransferTypeEnum {
    /**
     * 充值
     */
    DEPOSIT(1, "deposit"),

    /**
     * 提现
     */
    WITHDRAW(2, "withdraw"),

    /**
     * 系统内部之间划转调用->转入
     */
    TRANSFER_IN(4, "transfer_in"),

    /**
     * 前端资金管理->资金划转(币币->法币,法币->币币等)->转出
     */
    TRANSFER_OUT(5, "transfer_out"),

    /**
     * 内部返佣
     */
    REBATE(8, "rebate"),

    /**
     * 系统内部钱包账号A与钱包账号B相互划转
     */
    TRANSFER_INNER(9, "transfer_inner"),

    /**
     * 系统转入(补偿用户)
     */
    SYSTEM_TRANSFER_IN(10, "system_transfer_in"),
    ;

    private final int code;
    private final String name;

    TransferTypeEnum(final int code, final String name) {
        this.code = code;
        this.name = name;
    }

    public static TransferTypeEnum convert(final int code) {
        for (final var type : TransferTypeEnum.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    public static TransferTypeEnum convert(final String name) {
        for (final var type : TransferTypeEnum.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
