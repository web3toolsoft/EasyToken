package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.data.InsertRepository;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * @param <Dao>
 * @param <Po>
 * @author web3soft-team
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
    public int addWithId(final Po record) {
        return this.dao.insertWithId(record);
    }

    @Override
    public int batchAdd(final List<Po> records) {
        return this.dao.batchInsert(records);
    }

    @Override
    public int batchAddWithId(final List<Po> records) {
        return this.dao.batchInsertWithId(records);
    }

    @Override
    public int batchAddOnDuplicateKey(final List<Po> records) {
        return this.dao.batchInsertOnDuplicateKey(records);
    }

    @Override
    public int batchAddWithIdOnDuplicateKey(final List<Po> records) {
        return this.dao.batchInsertWithIdOnDuplicateKey(records);
    }

    @Override
    public int add(final Po record, final ShardTable shardTable) {
        return this.dao.insert(record, shardTable);
    }

    @Override
    public int addWithId(final Po record, final ShardTable shardTable) {
        return this.dao.insertWithId(record, shardTable);
    }

    @Override
    public int batchAdd(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchInsert(records, shardTable);
    }

    @Override
    public int batchAddWithId(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchInsertWithId(records, shardTable);
    }

    @Override
    public int batchAddOnDuplicateKey(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchInsertOnDuplicateKey(records, shardTable);
    }

    @Override
    public int batchAddWithIdOnDuplicateKey(final List<Po> records, final ShardTable shardTable) {
        return this.dao.batchInsertWithIdOnDuplicateKey(records, shardTable);
    }
}
