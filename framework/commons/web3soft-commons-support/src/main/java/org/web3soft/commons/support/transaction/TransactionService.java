package org.web3soft.commons.support.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author web3soft-team
 */
@Slf4j
public class TransactionService {
    private final PlatformTransactionManager transactionManager;

    public TransactionService(final PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public <T> T run(final Transaction<T> transaction) {
        return this.run(transaction, new DefaultTransactionDefinition());
    }

    public <T> T run(final Transaction<T> transaction, final TransactionDefinition definition) {
        final TransactionStatus status = this.transactionManager.getTransaction(definition);
        try {
            final T v = transaction.execute();
            this.transactionManager.commit(status);
            return v;
        } catch (final Exception e) {
            this.transactionManager.rollback(status);
            log.error("TransactionService error", e);
            return null;
        }
    }
}