package org.web3soft.commons.mybatis.data;

import org.apache.ibatis.annotations.Param;
import org.web3soft.commons.mybatis.pager.IdPageInfo;
import org.web3soft.commons.mybatis.pager.PageInfo;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;
import java.util.Map;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> Key字段数据类型(Integer,Long,String等)
 * @author web3soft-team
 */
public interface SelectRepository<T, U, K> {
    /**
     * 通过主键找出一条数据
     *
     * @param id      主键id值
     * @param columns filter columns
     * @return
     */
    T selectById(@Param("id") K id, @Param("columns") List<String> columns);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example 查询条件参数
     * @param columns filter columns
     * @return 记录列表
     */
    List<T> selectByExample(@Param("example") U example, @Param("columns") List<String> columns);

    /**
     * 根据条件查询一条数据
     *
     * @param example 查询条件参数
     * @param columns filter columns
     * @return 分页记录列表
     */
    T selectOneByExample(@Param("example") U example, @Param("columns") List<String> columns);

    /**
     * @param ids     id列表
     * @param columns filter columns
     * @return
     */
    List<T> selectIn(@Param("ids") List<K> ids, @Param("columns") List<String> columns);

    /**
     * 获取当前分页查询的总记录数
     *
     * @param pager
     * @param example 查询条件参数
     * @return 总记录数
     */
    int countByPager(@Param("pager") PageInfo pager, @Param("example") U example);

    /**
     * 分页查询
     *
     * @param pager
     * @param example 查询条件参数
     * @param columns filter columns
     * @return 分页记录列表
     */
    List<T> selectByPager(@Param("pager") PageInfo pager, @Param("example") U example, @Param("columns") List<String> columns);

    /**
     * 根据条件获取查询的总记录数
     *
     * @param example 查询条件参数
     * @return 总记录数
     */
    int countByExample(@Param("example") U example);

    /**
     * 通过主键找出一条数据
     *
     * @param id         主键id值
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return
     */
    T selectById(@Param("id") K id, @Param("shardTable") ShardTable shardTable, @Param("columns") List<String> columns);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 记录列表
     */
    List<T> selectByExample(@Param("example") U example, @Param("shardTable") ShardTable shardTable, @Param("columns") List<String> columns);

    /**
     * 根据条件查询一条数据
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    T selectOneByExample(@Param("example") U example, @Param("shardTable") ShardTable shardTable, @Param("columns") List<String> columns);

    /**
     * @param ids        id列表
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return
     */
    List<T> selectIn(@Param("ids") List<K> ids, @Param("shardTable") ShardTable shardTable, @Param("columns") List<String> columns);

    /**
     * 获取当前分页查询的总记录数
     *
     * @param pager      分页
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @return 总记录数
     */
    int countByPager(@Param("pager") PageInfo pager, @Param("example") U example, @Param("shardTable") ShardTable shardTable);

    /**
     * 分页查询
     *
     * @param pager      分页对象
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> selectByPager(@Param("pager") PageInfo pager, @Param("example") U example, @Param("shardTable") ShardTable shardTable,
                          @Param("columns") List<String> columns);

    /**
     * 根据条件获取查询的总记录数
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @return 总记录数
     */
    int countByExample(@Param("example") U example, @Param("shardTable") ShardTable shardTable);

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
     * @param columns filter columns
     * @return 分页记录列表
     */
    List<T> selectByIdPager(@Param("pager") IdPageInfo pager, @Param("example") U example, @Param("columns") List<String> columns);

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
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> selectByIdPager(@Param("pager") IdPageInfo pager, @Param("example") U example, @Param("shardTable") ShardTable shardTable,
                            @Param("columns") List<String> columns);
}
