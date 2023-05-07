package org.web3soft.commons.mybatis.data;

import org.apache.ibatis.annotations.Param;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> Key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 *
 */
public interface DeleteRepository<T, U, K> {
    /**
     * 根据主键删除记录
     *
     * @param id id主键值
     * @return 影响的记录数
     */
    int deleteById(@Param("id") K id);

    /**
     * 根据条件删除记录
     *
     * @param example 查询Example条件参数
     * @return 影响的记录数
     */
    int deleteByExample(@Param("example") U example);

    /**
     * @param ids id列表
     * @return
     */
    int deleteIn(@Param("ids") List<K> ids);

    /**
     * 根据主键删除记录
     *
     * @param id         id主键值
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int deleteById(@Param("id") K id, @Param("shardTable") ShardTable shardTable);

    /**
     * 根据条件删除记录
     *
     * @param example    查询Example条件参数
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int deleteByExample(@Param("example") U example, @Param("shardTable") ShardTable shardTable);

    /**
     * @param ids        id列表
     * @param shardTable 分表对象
     * @return 影响的记录数
     */
    int deleteIn(@Param("ids") List<K> ids, @Param("shardTable") ShardTable shardTable);
}

