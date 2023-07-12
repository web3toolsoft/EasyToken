package org.web3soft.commons.lang.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * 充值与提出唯一交易号生成
 *
 * @author web3soft-team
 **/
public class TradeNoUtil {
    /**
     * 生成唯一交易号
     *
     * @return tradeNo [uuid+timeMills]
     */
    public static String generate() {
        return UUID.randomUUID().toString() + System.currentTimeMillis();
    }

    /**
     * 生成唯一交易号
     *
     * @param bizId  业务类型 {@link BizTypeEnum#getIndex()}
     * @param userId 用户id
     * @return tradeNo [biz-userId-uuid]
     */
    public static String generate(final int bizId, final long userId) {
        return generate(bizId, userId, UUID.randomUUID().toString());
    }

    /**
     * 生成唯一交易号
     *
     * @param bizId  业务类型 {@link BizTypeEnum#getIndex()}
     * @param userId 用户id
     * @param random 随机数
     * @return tradeNo [biz-userId-uuid]
     */
    public static String generate(final int bizId, final long userId, final String random) {
        return (bizId + "-" +
                userId + "-" +
                random
        );
    }

    /**
     * 生成唯一交易号
     *
     * @param bizId   业务类型 {@link BizTypeEnum#getIndex()}
     * @param userId  用户id
     * @param txHash  交易hash(txId)
     * @param address 交易地址
     * @return 生成唯一交易号
     */
    public static String generate(final int bizId, final long userId, final String txHash, final String address) {
        return (bizId + "-" +
                userId + "-" +
                DigestUtils.md5Hex(txHash + address)
        );
    }

    /**
     * 生成唯一交易号
     *
     * @param bizId      业务类型 {@link BizTypeEnum#getIndex()}
     * @param currencyId 币种id
     * @param userId     用户id
     * @param txHash     交易hash(txId)
     * @param address    交易地址
     * @return 生成唯一交易号
     */
    public static String generate(final int bizId, final Integer currencyId, final long userId, final String txHash, final String address) {
        return (bizId + "-" +
                currencyId + "-" +
                userId + "-" +
                DigestUtils.md5Hex(txHash + address)
        );
    }

    /**
     * 生成唯一交易号
     *
     * @param bizId      业务类型 {@link BizTypeEnum#getIndex()}
     * @param currencyId 币种id
     * @param txHash     交易hash(txId)
     * @param address    交易地址
     * @return 生成唯一交易号
     */
    public static String generate(final int bizId, final Integer currencyId, final String txHash, final String address) {
        return (bizId + "-" +
                currencyId + "-" +
                DigestUtils.md5Hex(txHash + address)
        );
    }

    /**
     * 生成唯一交易号
     *
     * @param bizId      业务类型 {@link BizTypeEnum#getIndex()}
     * @param currencyId 币种id
     * @param userId     用户id
     * @return 生成唯一交易号
     */
    public static String generate(final int bizId, final Integer currencyId, final long userId) {
        return (bizId + "-" +
                currencyId + "-" +
                userId + "-" +
                DigestUtils.md5Hex(UUID.randomUUID().toString())
        );
    }
}
