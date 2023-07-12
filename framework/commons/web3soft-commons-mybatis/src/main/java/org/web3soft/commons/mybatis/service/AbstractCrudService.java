package org.web3soft.commons.mybatis.service;

import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.List;

/**
 * 基本增删改查(CRUD)数据访问服务基类
 *
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @author Tom Deng
 *
 */
public abstract class AbstractCrudService<Dao extends CrudRepository<Po, Example, Type>, Po, Example, Type>
        extends AbstractGetService<Dao, Po, Example, Type>
        implements CrudService<Po, Example, Type> {

    protected AbstractCrudService(final Dao dao) {
        super(dao);
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
