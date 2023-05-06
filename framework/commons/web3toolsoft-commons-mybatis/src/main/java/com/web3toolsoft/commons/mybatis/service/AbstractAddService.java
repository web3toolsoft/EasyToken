package com.web3toolsoft.commons.mybatis.service;

import com.web3toolsoft.commons.mybatis.data.InsertRepository;
import com.web3toolsoft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <Dao>
 * @param <Po>
 * @author Tom Deng
 */
public abstract class AbstractAddService<Dao extends InsertRepository<Po>, Po> implements AddService<Po> {

    protected Dao dao;

    protected AbstractAddService(final Dao dao) {
        this.dao = dao;
    }

    @Override
    public int add(final Po record) {
        return this.dao.insert(record);
    }

    @Override
    public int batchAdd(final List<Po> records) {
        return this.dao.batchInsert(records);
    }

    @Override
    public int batchAddOnDuplicateKey(final List<Po> records) {
        return this.dao.batchInsertOnDuplicateKey(records);
    }

    @Override
    public int add(final Po record, final ShardTable shardTable) {
        return this.dao.insert(record, shardTable);
    }

    @Override
    public int batchAdd(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchInsert(records, shardTable);
    }

    @Override
    public int batchAddOnDuplicateKey(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchInsertOnDuplicateKey(records, shardTable);
    }
}
