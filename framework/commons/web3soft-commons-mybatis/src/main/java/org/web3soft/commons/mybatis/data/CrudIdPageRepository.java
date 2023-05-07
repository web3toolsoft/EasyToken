package org.web3soft.commons.mybatis.data;

/**
 * 基本增删改查(CRUD)+IdPage数据访问接口
 *
 * @param <T> Po
 * @param <U> Example
 * @param <K> Key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 *
 */
public interface CrudIdPageRepository<T, U, K> extends
        CrudRepository<T, U, K>,
        IdPageRepository<T, U> {
}
