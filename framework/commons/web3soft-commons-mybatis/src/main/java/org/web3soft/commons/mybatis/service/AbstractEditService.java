package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.data.UpdateRepository;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @author Tom Deng
 *
 */
public abstract class AbstractEditService<Dao extends UpdateRepository<Po, Example>, Po, Example>
        implements EditService<Po, Example> {

    protected Dao dao;

    protected AbstractEditService(final Dao dao) {
        this.dao = dao;
    }

    @Override
    public int editById(final Po record) {
        return this.dao.updateById(record);
    }

    @Override
    public int editByExample(final Po record, final Example example) {
        return this.dao.updateByExample(record, example);
    }

    @Override
    public int batchEditById(final List<Po> records) {
        return this.dao.batchUpdateById(records);
    }

    @Override
    public int editById(final Po record, final ShardTable shardTable) {
        return this.dao.updateById(record, shardTable);
    }

    @Override
    public int editByExample(final Po record, final Example example, final ShardTable shardTable) {
        return this.dao.updateByExample(record, example, shardTable);
    }

    @Override
    public int batchEditById(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchUpdateById(records, shardTable);
    }
}
