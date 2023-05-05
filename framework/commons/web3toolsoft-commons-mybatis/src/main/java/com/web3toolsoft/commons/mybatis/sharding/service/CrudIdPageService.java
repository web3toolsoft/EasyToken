package com.web3toolsoft.commons.mybatis.sharding.service;

import com.web3toolsoft.commons.mybatis.pager.IdPageInfo;
import com.web3toolsoft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * 基本增删改查(CRUD)+IdPage数据访问服务接口
 *
 * @param <T> Po
 * @param <U> Example
 * @param <K> key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 */
public interface CrudIdPageService<T, U, K> extends CrudService<T, U, K> {

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
     * @param example    where条件参数
     * @param shardTable 分表对象
     * @return 分页记录列表
     */
    List<T> getByPage(IdPageInfo pageInfo, U example, ShardTable shardTable);
}
