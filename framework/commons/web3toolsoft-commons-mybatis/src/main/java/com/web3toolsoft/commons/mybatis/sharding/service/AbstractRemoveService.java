package com.web3toolsoft.commons.mybatis.sharding.service;

import com.web3toolsoft.commons.mybatis.sharding.ShardTable;
import com.web3toolsoft.commons.mybatis.sharding.data.DeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @param <Type>    Key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 *
 */
public abstract class AbstractRemoveService<Dao extends DeleteRepository<Po, Example, Type>, Po, Example, Type>
        implements RemoveService<Po, Example, Type> {
    @Autowired
    protected Dao dao;

    @Override
    public int removeById(final Type id, final ShardTable shardTable) {
        return this.dao.deleteById(id, shardTable);
    }

    @Override
    public int removeByExample(final Example example, final ShardTable shardTable) {
        return this.dao.deleteByExample(example, shardTable);
    }

    @Override
    public int removeIn(final List<Po> records, final ShardTable shardTable) {
        return this.dao.deleteIn(records, shardTable);
    }
}
