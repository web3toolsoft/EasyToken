package org.web3soft.commons.lang.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author web3soft-team
 */
public class NumberUtil {

    public static String regularBigDecimalFromStr(final String data) {
        if (StringUtils.isEmpty(data)) {
            return data;
        }
        return regularBigDecimalFromBigDecimal(new BigDecimal(data));
    }

    public static String regularBigDecimalFromBigDecimal(final BigDecimal data) {
        return data.stripTrailingZeros().toPlainString();
    }

    public static String toBigDecimalPlan(final BigDecimal value) {
        if (value == null) {
            return "0";
        }
        return value.stripTrailingZeros().toPlainString();
    }

    //------------------ equals -----------------------------------

    public static boolean eq(final Byte object, final byte value) {
        return eq(object, (byte) 0, value);
    }

    public static boolean eq(final Short object, final short value) {
        return eq(object, (short) 0, value);
    }

    public static boolean eq(final Integer object, final int value) {
        return eq(object, 0, value);
    }

    public static boolean eq(final Long object, final long value) {
        return eq(object, 0L, value);
    }

    //------------------greater than -----------------------------------

    public static boolean gt(final Byte object, final byte value) {
        return gt(object, (byte) 0, value);
    }

    public static boolean gt(final Short object, final short value) {
        return gt(object, (short) 0, value);
    }

    public static boolean gt(final Integer object, final int value) {
        return gt(object, 0, value);
    }

    public static boolean gt(final Long object, final long value) {
        return gt(object, 0L, value);
    }


    //------------------greater than equals -----------------------------------

    public static boolean gte(final Byte object, final byte value) {
        return gte(object, (byte) 0, value);
    }

    public static boolean gte(final Short object, final short value) {
        return gte(object, (short) 0, value);
    }

    public static boolean gte(final Integer object, final int value) {
        return gte(object, 0, value);
    }

    public static boolean gte(final Long object, final long value) {
        return gte(object, 0L, value);
    }


    //------------------less than -----------------------------------

    public static boolean lt(final Byte object, final byte value) {
        return lt(object, (byte) 0, value);
    }

    public static boolean lt(final Short object, final short value) {
        return lt(object, (short) 0, value);
    }

    public static boolean lt(final Integer object, final int value) {
        return lt(object, 0, value);
    }

    public static boolean lt(final Long object, final long value) {
        return lt(object, 0L, value);
    }


    //------------------less than equals -----------------------------------

    public static boolean lte(final Byte object, final byte value) {
        return lte(object, (byte) 0, value);
    }

    public static boolean lte(final Short object, final short value) {
        return lte(object, (short) 0, value);
    }

    public static boolean lte(final Integer object, final int value) {
        return lte(object, 0, value);
    }

    public static boolean lte(final Long object, final long value) {
        return lte(object, 0L, value);
    }


    //------------------equals default -----------------------------------

    public static boolean eq(final Byte object, final byte defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) == value;
    }

    public static boolean eq(final Short object, final short defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) == value;
    }

    public static boolean eq(final Integer object, final int defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) == value;
    }

    public static boolean eq(final Long object, final long defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) == value;
    }

    //------------------greater than default -----------------------------------

    public static boolean gt(final Byte object, final byte defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) > value;
    }

    public static boolean gt(final Short object, final short defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) > value;
    }

    public static boolean gt(final Integer object, final int defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) > value;
    }

    public static boolean gt(final Long object, final long defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) > value;
    }

    //------------------greater than equals default -----------------------------------

    public static boolean gte(final Byte object, final byte defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) >= value;
    }

    public static boolean gte(final Short object, final short defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) >= value;
    }

    public static boolean gte(final Integer object, final int defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) >= value;
    }

    public static boolean gte(final Long object, final long defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) >= value;
    }


    //------------------less equals default -----------------------------------

    public static boolean lt(final Byte object, final byte defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) < value;
    }

    public static boolean lt(final Short object, final short defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) < value;
    }

    public static boolean lt(final Integer object, final int defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) < value;
    }

    public static boolean lt(final Long object, final long defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) < value;
    }

    //------------------less than equals default -----------------------------------

    public static boolean lte(final Byte object, final byte defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) <= value;
    }

    public static boolean lte(final Short object, final short defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) <= value;
    }

    public static boolean lte(final Integer object, final int defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) <= value;
    }

    public static boolean lte(final Long object, final long defaultValue, final long value) {
        return ObjectUtils.defaultIfNull(object, defaultValue) <= value;
    }
}

