package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> key字段数据类型(Integer,Long,String等)
 * @author web3soft-team
 *
 */
public interface RemoveService<T, U, K> {
    /**
     * @param id
     * @return
     */
    int removeById(K id);

    /**
     * @param example
     * @return
     */
    int removeByExample(U example);

    /**
     * @param ids
     * @return
     */
    int removeIn(List<K> ids);

    /**
     * @param id         id
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int removeById(K id, ShardTable shardTable);

    /**
     * @param example    pojo记录
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int removeByExample(U example, ShardTable shardTable);

    /**
     * @param ids        id列表
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int removeIn(List<K> ids, ShardTable shardTable);
}
