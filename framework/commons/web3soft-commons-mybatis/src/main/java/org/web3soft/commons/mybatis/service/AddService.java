package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <T> Po
 * @author Tom Deng
 *
 */
public interface AddService<T> {
    /**
     * @param record
     * @return
     */
    int add(T record);

    /**
     * @param record
     * @return
     */
    int addWithId(T record);

    /**
     * @param records
     * @return
     */
    int batchAdd(List<T> records);

    /**
     * @param records
     * @return
     */
    int batchAddWithId(List<T> records);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     *
     * @param records
     * @return
     */
    int batchAddOnDuplicateKey(List<T> records);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     *
     * @param records
     * @return
     */
    int batchAddWithIdOnDuplicateKey(List<T> records);

    /**
     * @param record     pojo记录
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int add(T record, ShardTable shardTable);

    /**
     * @param record     pojo记录
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int addWithId(T record, ShardTable shardTable);

    /**
     * @param records    pojo记录集
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int batchAdd(List<T> records, ShardTable shardTable);

    /**
     * @param records    pojo记录集
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int batchAddWithId(List<T> records, ShardTable shardTable);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     *
     * @param records
     * @param shardTable 分表对象
     * @return
     */
    int batchAddOnDuplicateKey(List<T> records, ShardTable shardTable);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     *
     * @param records
     * @param shardTable 分表对象
     * @return
     */
    int batchAddWithIdOnDuplicateKey(List<T> records, ShardTable shardTable);
}
