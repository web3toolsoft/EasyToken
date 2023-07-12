package org.web3soft.commons.support.transaction;

/**
 * @author web3soft-team
 */
@FunctionalInterface
public interface Transaction<T> {

    /**
     *
     * @return T
     */
    T execute();
}
