package org.web3soft.commons.mybatis.data;

import org.apache.ibatis.annotations.Param;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <T>
 * @author web3soft-team
 *
 */
public interface InsertRepository<T> {
    /**
     * 插入一条数据，忽略record中的ID(自增主键)
     *
     * @param record
     * @return 影响的记录数
     */
    int insert(@Param("record") T record);

    /**
     * 插入一条数据且手动创建Id主键
     *
     * @param record
     * @return 影响的记录数
     */
    int insertWithId(@Param("record") T record);

    /**
     * 忽略record中的ID(自增主键)
     *
     * @param records
     * @return 影响的记录数
     */
    int batchInsert(@Param("records") List<T> records);

    /**
     * 手动创建Id主键
     *
     * @param records
     * @return 影响的记录数
     */
    int batchInsertWithId(@Param("records") List<T> records);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     *
     * @param records pojo记录集
     * @return 影响的记录数
     */
    int batchInsertOnDuplicateKey(@Param("records") List<T> records);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     * 手动创建Id主键
     *
     * @param records pojo记录集
     * @return 影响的记录数
     */
    int batchInsertWithIdOnDuplicateKey(@Param("records") List<T> records);

    /**
     * 插入一条数据，忽略record中的ID(自增主键)
     *
     * @param record     pojo对象
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int insert(@Param("record") T record, @Param("shardTable") ShardTable shardTable);

    /**
     * 插入一条数据，手动创建Id主键
     *
     * @param record     pojo对象
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int insertWithId(@Param("record") T record, @Param("shardTable") ShardTable shardTable);

    /**
     * 忽略record中的ID(自增主键)
     *
     * @param records    pojo记录集
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int batchInsert(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable);

    /**
     * 手动创建Id主键
     *
     * @param records    pojo记录集
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int batchInsertWithId(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     *
     * @param records    pojo记录集
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int batchInsertOnDuplicateKey(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable);

    /**
     * 使用mysql on duplicate key 语句插入与修改
     * 手动创建Id主键
     *
     * @param records    pojo记录集
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int batchInsertWithIdOnDuplicateKey(@Param("records") List<T> records, @Param("shardTable") ShardTable shardTable);
}
