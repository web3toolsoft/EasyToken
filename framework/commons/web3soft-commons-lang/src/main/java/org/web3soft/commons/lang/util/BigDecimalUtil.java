package org.web3soft.commons.lang.util;

import org.web3soft.commons.lang.math.BigDecimalWrapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * Utility to help comparison of {@link BigDecimal}.
 * <p>
 * The only way to compare {@link BigDecimal} is to get result of compare
 * function of {@link BigDecimal} and compare the result with -1, 0 and 1.
 * <p>
 * Although it is straight forward however it lacks expressiveness and decreases
 * readability. For instance look at this line of code :
 *
 * <pre>
 * <code>
 *     if(balance.compareTo(maxAmount) < 0))
 * </code>
 * </pre>
 * <p>
 * the code above try to check condition "balance &lt; maxAmount". You
 * definitely spotted the problem. now imagine how hard it can be if you have to
 * read some code with a lot of {@link BigDecimal} comparison!! </b>
 * {@link BigDecimalUtil} makes comparison of {@link BigDecimal}s more easier
 * and more readable than the comparator method. look how above code are written
 * by the help of this library.
 *
 * <pre>
 * <code>
 *     if( is(balance).lt(maxAmount) )
 * </code>
 * </pre>
 *
 * @author adigozalpour
 */
public class BigDecimalUtil {

    private BigDecimalUtil() {
    }

    /**
     * Entry points of {@link BigDecimalUtil} <br/>
     * <br/>
     * Example usage:
     *
     * <pre>
     * <code>
     *      is(three).eq(four); //Equal
     * 		is(two).gt(two);    //Greater than
     * 		is(two).gte(one);   //Greater than equal
     * 		is(three).lt(two);  //Less than
     * 		is(three).lte(two); //Less than equal
     *
     *      is(three).notEq(four); //Not Equal
     * 		is(two).notGt(two);    //Not Greater than
     * 		is(two).notGte(one);   //Not Greater than equal
     * 		is(three).notLt(two);  //Not Less than
     * 		is(three).notLte(two); //Not Less than equal
     *
     *      is(three).isZero();
     *      is(three).notZero();
     *      is(three).isPositive(); // greater than zero
     *      is(three).isNegative(); // less than zero
     *      is(three).isNonPositive(); //less than or equal zero
     *      is(three).isNonNegative(); //greater than or equal zero
     * </code>
     * </pre>
     *
     * @param decimal your {@link BigDecimal}
     * @return {@link BigDecimalWrapper}
     * @see #is(BigDecimal)
     */
    public static BigDecimalWrapper is(final BigDecimal decimal) {
        return new BigDecimalWrapper(decimal);
    }

    /**
     * Entry points of {@link BigDecimalUtil} <br/>
     * <br/>
     * Example usage:
     *
     * <pre>
     * <code>
     *      is(three).eq(four); //Equal
     * 		is(two).gt(two);    //Greater than
     * 		is(two).gte(one);   //Greater than equal
     * 		is(three).lt(two);  //Less than
     * 		is(three).lte(two); //Less than equal
     *
     *      is(three).notEq(four); //Not Equal
     * 		is(two).notGt(two);    //Not Greater than
     * 		is(two).notGte(one);   //Not Greater than equal
     * 		is(three).notLt(two);  //Not Less than
     * 		is(three).notLte(two); //Not Less than equal
     *
     *      is(three).isZero();
     *      is(three).notZero();
     *      is(three).isPositive(); // greater than zero
     *      is(three).isNegative(); // less than zero
     *      is(three).isNonPositive(); //less than or equal zero
     *      is(three).isNonNegative(); //greater than or equal zero
     *
     *      is(three).isNullOrZero(); //is null or zero
     *      is(three).notNullOrZero(); //not null or zero
     * </code>
     * </pre>
     *
     * @param decimal your {@link BigDecimal}
     * @return {@link BigDecimalWrapper}
     * @see #is(BigDecimal)
     */
    public static BigDecimalWrapper is(final double decimal) {
        return BigDecimalUtil.is(BigDecimal.valueOf(decimal));
    }

    /**
     * setScale(8, RoundingMode.DOWN)
     *
     * @param decimal {@link BigDecimal}
     * @return to double
     */
    public static double toDouble(final BigDecimal decimal) {
        return Optional.ofNullable(decimal)
                .orElse(BigDecimal.ZERO)
                .setScale(8, RoundingMode.DOWN)
                .doubleValue();

    }

    /**
     * divisor / dividend
     * setScale(divisor / dividend,8, RoundingMode.DOWN)
     *
     * @param divisor  {@link BigDecimal}
     * @param dividend {@link BigDecimal}
     * @return BigDecimal setScale(divisor / dividend,8, RoundingMode.DOWN)
     */
    public static BigDecimal divideScale8(final BigDecimal divisor, final BigDecimal dividend) {
        if (BigDecimalUtil.is(dividend).eq(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return divisor.divide(dividend, 8, RoundingMode.DOWN);
    }

    /**
     * divisor / dividend
     * setScale(divisor / dividend,16, RoundingMode.DOWN)
     *
     * @param divisor  {@link BigDecimal}
     * @param dividend {@link BigDecimal}
     * @return BigDecimal setScale(divisor / dividend,16, RoundingMode.DOWN)
     */
    public static BigDecimal divideScale16(final BigDecimal divisor, final BigDecimal dividend) {
        if (BigDecimalUtil.is(dividend).eq(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return divisor.divide(dividend, 16, RoundingMode.DOWN);
    }

    /**
     * setScale(8, RoundingMode.DOWN)
     *
     * @param decimal {@link BigDecimal}
     * @return BigDecimal
     */
    public static BigDecimal getScale8(final BigDecimal decimal) {
        return getScaleX(8, decimal);
    }

    /**
     * setScale(16, RoundingMode.DOWN)
     *
     * @param decimal {@link BigDecimal}
     * @return BigDecimal
     */
    public static BigDecimal getScale16(final BigDecimal decimal) {
        return getScaleX(16, decimal);
    }

    /**
     * getScaleX(x, RoundingMode.DOWN)
     *
     * @param scale   scale
     * @param decimal {@link BigDecimal}
     * @return BigDecimal
     */
    public static BigDecimal getScaleX(final int scale, final BigDecimal decimal) {
        return Optional.ofNullable(decimal)
                .orElse(BigDecimal.ZERO)
                .setScale(scale, RoundingMode.DOWN);
    }
}
