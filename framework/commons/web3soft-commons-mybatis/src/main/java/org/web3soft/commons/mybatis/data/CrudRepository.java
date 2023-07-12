package org.web3soft.commons.mybatis.data;

/**
 * 基本增删改查(CRUD)数据访问接口
 *
 * @param <T> Po
 * @param <U> Example
 * @param <K> Key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 *
 */
public interface CrudRepository<T, U, K> extends
        InsertRepository<T>,
        DeleteRepository<T, U, K>,
        UpdateRepository<T, U>,
        SelectRepository<T, U, K> {
}
