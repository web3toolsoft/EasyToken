package org.web3soft.commons.mybatis.data;

import org.web3soft.commons.mybatis.pager.IdPageInfo;
import org.web3soft.commons.mybatis.sharding.ShardTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基于主键ID的分页查询(由于MySQL limit分页在大记录表存在性能问题)
 *
 * @param <T> Po
 * @param <U> Example
 * @author Tom Deng
 *
 */
public interface IdPageRepository<T, U> {

    /**
     * 获取当前分页查询的总记录数
     *
     * @param pager   {@link IdPageInfo}
     * @param example 查询条件参数
     * @return 总记录数
     */
    Map<String, Long> countByIdPager(@Param("pager") IdPageInfo pager, @Param("example") U example);

    /**
     * 分页查询
     *
     * @param pager   {@link IdPageInfo}
     * @param example 查询条件参数
     * @return 分页记录列表
     */
    List<T> selectByIdPager(@Param("pager") IdPageInfo pager, @Param("example") U example);

    /**
     * 获取当前分页查询的总记录数
     *
     * @param pager      {@link IdPageInfo}
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @return 总记录数
     */
    Map<String, Long> countByIdPager(@Param("pager") IdPageInfo pager, @Param("example") U example, @Param("shardTable") ShardTable shardTable);

    /**
     * 分页查询
     *
     * @param pager      {@link IdPageInfo}
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> selectByIdPager(@Param("pager") IdPageInfo pager, @Param("example") U example, @Param("shardTable") ShardTable shardTable);

}
