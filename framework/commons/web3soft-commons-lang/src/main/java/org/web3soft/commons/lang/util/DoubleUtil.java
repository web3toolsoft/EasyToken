package org.web3soft.commons.lang.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author web3soft-team
 * @since 0.0.1
 **/
public class DoubleUtil {
    /**
     * 根据scale的值动态格式化double类型数据
     *
     * @param value double数据
     * @param scale 精度位数(保留的小数位数)
     * @return 格式化后的数据
     */
    public static String format(final double value, final int scale) {
        final String pattern = StringUtils.appendIfMissing("0.", StringUtils.repeat('0', scale));
        return new DecimalFormat(pattern).format(value);
    }

    /**
     * 对double数据进行取精度.
     *
     * @param value double数据.
     * @param scale 精度位数(保留的小数位数).
     * @return 精度计算后的数据.
     */
    public static double round(final double value, final int scale) {
        final int n = (int) Math.pow(10, scale);
        return divide(Math.floor(multiply(value, n)), n, scale);
    }

    /**
     * 小数向上进位
     *
     * @param value double数据.
     * @param scale 精度位数(保留的小数位数).
     * @return
     */
    public static double roundUp(final double value, final int scale) {
        final int n = (int) Math.pow(10, scale);
        return divide(Math.ceil(multiply(value, n)), n, scale);
    }

    /**
     * double 相加
     *
     * @param d1
     * @param d2s
     * @return
     */
    public static double add(final double d1, final double... d2s) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        for (final double d2 : d2s) {
            final BigDecimal bd2 = new BigDecimal(Double.toString(d2));
            bd1 = bd1.add(bd2);
        }
        return bd1.doubleValue();
    }

    /**
     * double 相减
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double subtract(final double d1, final double d2) {
        final BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        final BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * double 乘法
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double multiply(final double d1, final double d2) {
        final BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        final BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    /**
     * double 多数乘法
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double multiply(final double d1, final double... d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        for (final double d : d2) {
            bd1 = bd1.multiply(new BigDecimal(Double.toString(d)));
        }
        return bd1.doubleValue();
    }

    /**
     * double 除法并四舍五入，在此之前，你要判断分母是否为0，
     *
     * @param d1    除数
     * @param d2    被除数
     * @param scale 精度位数(保留的小数位数).
     * @return
     */
    public static double divide(final double d1, final double d2, final int scale) {
        final BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        final BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide(bd2, scale, RoundingMode.HALF_UP).doubleValue();
    }

}
