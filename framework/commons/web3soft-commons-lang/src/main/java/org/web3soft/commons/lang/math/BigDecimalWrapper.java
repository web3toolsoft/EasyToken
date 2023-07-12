package org.web3soft.commons.lang.math;

import java.math.BigDecimal;

/**
 * wrapper of {@link BigDecimal} simplifies {@link BigDecimal} comparison
 *
 * @author adigozalpour
 */
public final class BigDecimalWrapper {

    private static final int ZERO = 0;
    private final BigDecimal bigDecimal;

    public BigDecimalWrapper(final BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    /**
     * Checks whether input argument is <i><b> equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} true if two are equal.
     */
    public boolean eq(final BigDecimal decimal) {
        return this.bigDecimal.compareTo(decimal) == BigDecimalWrapper.ZERO;
    }

    /**
     * Checks whether input argument is <i><b> equal </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} true if two are equal.
     */
    public boolean eq(final double decimal) {
        return this.eq(BigDecimal.valueOf(decimal));
    }

    /**
     * Checks whether input argument is <i><b> greater than </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean gt(final BigDecimal decimal) {
        return this.bigDecimal.compareTo(decimal) > BigDecimalWrapper.ZERO;
    }

    /**
     * Checks whether input argument is <i><b> greater than </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean gt(final double decimal) {
        return this.gt(BigDecimal.valueOf(decimal));
    }

    /**
     * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean gte(final BigDecimal decimal) {
        return this.bigDecimal.compareTo(decimal) >= BigDecimalWrapper.ZERO;
    }

    /**
     * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean gte(final double decimal) {
        return this.gte(BigDecimal.valueOf(decimal));
    }

    /**
     * Checks whether input argument is <i><b> less than </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean lt(final BigDecimal decimal) {
        return this.bigDecimal.compareTo(decimal) < BigDecimalWrapper.ZERO;
    }

    /**
     * Checks whether input argument is <i><b> less than </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean lt(final double decimal) {
        return this.lt(BigDecimal.valueOf(decimal));
    }

    /**
     * Checks whether input argument is <i><b> less than equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean lte(final BigDecimal decimal) {
        return this.bigDecimal.compareTo(decimal) <= BigDecimalWrapper.ZERO;
    }

    /**
     * Checks whether input argument is <i><b> less than equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean lte(final double decimal) {
        return this.lte(BigDecimal.valueOf(decimal));
    }

    /**
     * Checks whether input argument is <i><b> not equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} true if two are not equal.
     */
    public boolean notEq(final BigDecimal decimal) {
        return !this.eq(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not equal </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} true if two are not equal.
     */
    public boolean notEq(final double decimal) {
        return !this.eq(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not greater than </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notGt(final BigDecimal decimal) {
        return !this.gt(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not greater than </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notGt(final double decimal) {
        return !this.gt(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not greater than or equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notGte(final BigDecimal decimal) {
        return !this.gte(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not greater than or equal </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notGte(final double decimal) {
        return !this.gte(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not less than </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notLt(final BigDecimal decimal) {
        return !this.lt(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not less than </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notLt(final double decimal) {
        return !this.lt(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not less than equal </b></i> to the provided
     * {@link BigDecimal} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notLte(final BigDecimal decimal) {
        return !this.lte(decimal);
    }

    /**
     * Checks whether input argument is <i><b> not less than equal </b></i> to the provided
     * {@link Double} or not;
     *
     * @param decimal value to compare
     * @return {@link Boolean} value
     */
    public boolean notLte(final double decimal) {
        return !this.lte(decimal);
    }

    /**
     * @return true if the value is greater than zero
     */
    public boolean isPositive() {
        return this.gt(BigDecimalWrapper.ZERO);
    }

    /**
     * @return true if the value is less than zero
     */
    public boolean isNegative() {
        return this.lt(BigDecimalWrapper.ZERO);
    }

    /**
     * @return true if the value is less than or equal with zero
     */
    public boolean isNonPositive() {
        return this.lte(BigDecimalWrapper.ZERO);
    }

    /**
     * @return true if the value is greater than or equal with zero
     */
    public boolean isNonNegative() {
        return this.gte(BigDecimalWrapper.ZERO);
    }

    /**
     * @return true if the value is equal with zero
     */
    public boolean isZero() {
        return this.eq(BigDecimalWrapper.ZERO);
    }

    /**
     * @return true if the value is greater than or less than zero
     */
    public boolean isNotZero() {
        return this.notEq(BigDecimalWrapper.ZERO);
    }

    /**
     * @return true if the value is null or zero
     */
    public boolean isNullOrZero() {
        return this.bigDecimal == null || this.isZero();
    }

    /**
     * @return true if the value is not null nor zero
     */
    public boolean notNullOrZero() {
        return this.bigDecimal != null && this.isNotZero();
    }

}