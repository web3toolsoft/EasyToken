package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.pager.IdPageInfo;
import org.web3soft.commons.mybatis.pager.PageInfo;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 */
public interface GetService<T, U, K> {
    /**
     * @param example
     * @return
     */
    boolean exists(U example);

    /**
     * 通过主键找出一条数据
     *
     * @param id 主键id值
     * @return
     */
    T getById(K id);

    /**
     * 通过主键找出一条数据
     *
     * @param id      主键id值
     * @param columns filter columns
     * @return
     */
    T getById(K id, List<String> columns);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example 查询条件参数
     * @return 记录列表
     */
    List<T> getByExample(U example);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example 查询条件参数
     * @param columns filter columns
     * @return 记录列表
     */
    List<T> getByExample(U example, List<String> columns);

    /**
     * 根据条件查询所有记录
     *
     * @return 记录列表
     */
    List<T> getAll();

    /**
     * 根据条件查询所有记录
     *
     * @param columns filter columns
     * @return 记录列表
     */
    List<T> getAll(List<String> columns);

    /**
     * 根据条件查询一条数据
     *
     * @param example 查询条件参数
     * @return 分页记录列表
     */
    T getOneByExample(U example);

    /**
     * 根据条件查询一条数据
     *
     * @param example 查询条件参数
     * @param columns filter columns
     * @return 分页记录列表
     */
    T getOneByExample(U example, List<String> columns);

    /**
     * select in(ids) 查询
     *
     * @param ids
     * @return
     */
    List<T> getIn(List<K> ids);

    /**
     * select in() 查询
     *
     * @param ids
     * @param columns filter columns
     * @return
     */
    List<T> getIn(List<K> ids, List<String> columns);

    /**
     * 分页查询
     *
     * @param pageInfo 分页参数
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo);

    /**
     * 分页查询
     *
     * @param pageInfo 分页参数
     * @param columns  filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, List<String> columns);

    /**
     * 分页查询
     *
     * @param pageInfo  分页参数
     * @param fieldName where 筛选字段名
     * @param keyword   where 筛选字段模糊匹配关键字
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, String fieldName, String keyword);

    /**
     * 分页查询
     *
     * @param pageInfo  分页参数
     * @param fieldName where 筛选字段名
     * @param keyword   where 筛选字段模糊匹配关键字
     * @param columns   filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, String fieldName, String keyword, List<String> columns);

    /**
     * 分页查询
     *
     * @param pageInfo 分页参数
     * @param example  where条件参数
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, U example);

    /**
     * 分页查询
     *
     * @param pageInfo 分页参数
     * @param example  where条件参数
     * @param columns  filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, U example, List<String> columns);

    /**
     * @param example
     * @return
     */
    boolean exists(U example, ShardTable shardTable);

    /**
     * 通过主键找出一条数据
     *
     * @param id         主键id值
     * @param shardTable 分表对象
     * @return 当前id对象的记录
     */
    T getById(K id, ShardTable shardTable);

    /**
     * 通过主键找出一条数据
     *
     * @param id         主键id值
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 当前id对象的记录
     */
    T getById(K id, ShardTable shardTable, List<String> columns);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @return 记录列表
     */
    List<T> getByExample(U example, ShardTable shardTable);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 记录列表
     */
    List<T> getByExample(U example, ShardTable shardTable, List<String> columns);

    /**
     * 根据条件查询所有记录
     *
     * @param shardTable 分表对象
     * @return 记录列表
     */
    List<T> getAll(ShardTable shardTable);

    /**
     * 根据条件查询所有记录
     *
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 记录列表
     */
    List<T> getAll(ShardTable shardTable, List<String> columns);

    /**
     * 根据条件查询一条数据
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    T getOneByExample(U example, ShardTable shardTable);

    /**
     * 根据条件查询一条数据
     *
     * @param example    查询条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    T getOneByExample(U example, ShardTable shardTable, List<String> columns);

    /**
     * select in() 查询
     *
     * @param ids
     * @param shardTable 分表对象
     * @return 记录列表
     */
    List<T> getIn(List<K> ids, ShardTable shardTable);

    /**
     * select in() 查询
     *
     * @param ids
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 记录列表
     */
    List<T> getIn(List<K> ids, ShardTable shardTable, List<String> columns);

    /**
     * 分页查询
     *
     * @param pageInfo   分页参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, ShardTable shardTable);

    /**
     * 分页查询
     *
     * @param pageInfo   分页参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, ShardTable shardTable, List<String> columns);

    /**
     * 分页查询
     *
     * @param pageInfo   分页参数
     * @param fieldName  where 筛选字段名
     * @param keyword    where 筛选字段模糊匹配关键字
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, String fieldName, String keyword, ShardTable shardTable);

    /**
     * 分页查询
     *
     * @param pageInfo   分页参数
     * @param fieldName  where 筛选字段名
     * @param keyword    where 筛选字段模糊匹配关键字
     * @param columns    filter columns
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, String fieldName, String keyword, ShardTable shardTable, List<String> columns);

    /**
     * 分页查询
     *
     * @param pageInfo   分页参数
     * @param example    where条件参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, U example, ShardTable shardTable);

    /**
     * 分页查询
     *
     * @param pageInfo   分页参数
     * @param example    where条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(PageInfo pageInfo, U example, ShardTable shardTable, List<String> columns);

    /**
     * 获取分页参数对象
     *
     * @param example where条件参数
     * @return 分页参数 {@link IdPageInfo}
     */
    IdPageInfo getIdPageInfo(U example);

    /**
     * 按Id分页查询
     *
     * @param pageInfo 分页参数
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo);

    /**
     * 按Id分页查询
     *
     * @param pageInfo 分页参数
     * @param columns  filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, List<String> columns);

    /**
     * 按Id分页查询
     *
     * @param pageInfo  分页参数
     * @param fieldName where 筛选字段名
     * @param keyword   where 筛选字段模糊匹配关键字
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, String fieldName, String keyword);

    /**
     * 按Id分页查询
     *
     * @param pageInfo  分页参数
     * @param fieldName where 筛选字段名
     * @param keyword   where 筛选字段模糊匹配关键字
     * @param columns   filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, String fieldName, String keyword, List<String> columns);

    /**
     * 按Id分页查询
     *
     * @param pageInfo 分页参数
     * @param example  where条件参数
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, U example);

    /**
     * 按Id分页查询
     *
     * @param pageInfo 分页参数
     * @param example  where条件参数
     * @param columns  filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, U example, List<String> columns);

    /**
     * 获取分页参数对象
     *
     * @param example    where条件参数
     * @param shardTable 分表对象
     * @return 分页参数 {@link IdPageInfo}
     */
    IdPageInfo getIdPageInfo(U example, ShardTable shardTable);

    /**
     * 按Id分页查询
     *
     * @param pageInfo   分页参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, ShardTable shardTable);

    /**
     * 按Id分页查询
     *
     * @param pageInfo   分页参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, ShardTable shardTable, List<String> columns);

    /**
     * 按Id分页查询
     *
     * @param pageInfo   分页参数
     * @param fieldName  where 筛选字段名
     * @param keyword    where 筛选字段模糊匹配关键字
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, String fieldName, String keyword, ShardTable shardTable);

    /**
     * 按Id分页查询
     *
     * @param pageInfo   分页参数
     * @param fieldName  where 筛选字段名
     * @param keyword    where 筛选字段模糊匹配关键字
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, String fieldName, String keyword, ShardTable shardTable, List<String> columns);

    /**
     * 按Id分页查询
     *
     * @param pageInfo   分页参数
     * @param example    where条件参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, U example, ShardTable shardTable);

    /**
     * 按Id分页查询
     *
     * @param pageInfo   分页参数
     * @param example    where条件参数
     * @param shardTable 分表对象
     * @param columns    filter columns
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, U example, ShardTable shardTable, List<String> columns);
}
