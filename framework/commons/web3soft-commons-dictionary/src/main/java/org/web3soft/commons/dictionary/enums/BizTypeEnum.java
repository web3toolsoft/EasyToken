package org.web3soft.commons.dictionary.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author web3soft-team
 */
public enum BizTypeEnum {
    /**
     * 未知
     */
    UNKNOWN(-2, "unknown"),
    /**
     * 所有(all)交易业务
     */
    ALL(-1, "all"),
    /**
     * 内部
     */
    INTERNAL(0, "internal"),
    /**
     * 现货(spot)交易业务
     */
    SPOT(1, "spot"),

    /**
     * 场外或法币(otc)交易业务
     */
    OTC(2, "otc"),

    /**
     * 交割合约(delivery)交易业务
     */
    DELIVERY(3, "delivery"),

    /**
     * 组合(portfolio)交易业务
     */
    PORTFOLIO(4, "portfolio"),

    /**
     * 资金管理(asset)交易业务
     */
    ASSET(5, "asset"),

    /**
     * 金本位永续合约(swap)交易业务
     */
    SWAP_USDT(6, "swap_usdt"),

    /**
     * 币本位永续合约(swap-coin)交易业务
     */
    SWAP_COIN(12, "swap_coin"),

    /**
     * 差价合约(Contract For Difference)交易业务
     */
    CFD(7, "cfd"),

    /**
     * 期权(options)交易业务
     */
    OPTIONS(8, "options"),

    /**
     * 开放接口(OpenAPI)业务
     */
    OPEN_API(9, "open_api"),

    /**
     * 钱包(Wallet)业务
     */
    Wallet(10, "wallet"),
    ;

    private final int index;
    private final String name;

    BizTypeEnum(final int index, final String name) {
        this.index = index;
        this.name = name;
    }

    public static BizTypeEnum forName(final String name) {
        for (final var value : BizTypeEnum.values()) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return BizTypeEnum.UNKNOWN;
    }

    public static BizTypeEnum forIndex(final int index) {
        for (final var value : BizTypeEnum.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return BizTypeEnum.UNKNOWN;
    }

    public static List<BizTypeEnum> getExchangeBizTypes() {
        return Arrays.asList(
                BizTypeEnum.SPOT,
                BizTypeEnum.OTC,
                BizTypeEnum.CFD,
                BizTypeEnum.DELIVERY,
                BizTypeEnum.SWAP_USDT,
                BizTypeEnum.SWAP_COIN,
                BizTypeEnum.OPTIONS,
                BizTypeEnum.Wallet
        );
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
}
