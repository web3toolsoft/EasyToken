package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.data.DeleteRepository;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @param <Type>    Key字段数据类型(Integer,Long,String等)
 * @author web3soft-team
 *
 */
public abstract class AbstractRemoveService<Dao extends DeleteRepository<Po, Example, Type>, Po, Example, Type>
        implements RemoveService<Po, Example, Type> {
    protected Dao dao;

    protected AbstractRemoveService(final Dao dao) {
        this.dao = dao;
    }

    @Override
    public int removeById(final Type id) {
        return this.dao.deleteById(id);
    }

    @Override
    public int removeByExample(final Example example) {
        return this.dao.deleteByExample(example);
    }

    @Override
    public int removeIn(final List<Type> ids) {
        return this.dao.deleteIn(ids);
    }

    @Override
    public int removeById(final Type id, final ShardTable shardTable) {
        return this.dao.deleteById(id, shardTable);
    }

    @Override
    public int removeByExample(final Example example, final ShardTable shardTable) {
        return this.dao.deleteByExample(example, shardTable);
    }

    @Override
    public int removeIn(final List<Type> ids, final ShardTable shardTable) {
        return this.dao.deleteIn(ids, shardTable);
    }
}
