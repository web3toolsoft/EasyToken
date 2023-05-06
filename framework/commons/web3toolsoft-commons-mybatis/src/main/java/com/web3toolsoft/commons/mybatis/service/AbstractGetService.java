package com.web3toolsoft.commons.mybatis.service;

import com.web3toolsoft.commons.mybatis.data.SelectRepository;
import com.web3toolsoft.commons.mybatis.pager.PageInfo;
import com.web3toolsoft.commons.mybatis.sharding.ShardTable;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @param <Type>    Key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 *
 */
public abstract class AbstractGetService<Dao extends SelectRepository<Po, Example, Type>, Po, Example, Type>
        implements GetService<Po, Example, Type> {

    protected Dao dao;

    protected AbstractGetService(final Dao dao) {
        this.dao = dao;
    }

    @Override
    public boolean exists(final Example example) {
        return this.dao.countByExample(example) > 0;
    }

    @Override
    public Po getById(final Type id) {
        return this.dao.selectById(id);
    }

    @Override
    public List<Po> getByExample(final Example example) {
        return this.dao.selectByExample(example);
    }

    @Override
    public List<Po> getAll() {
        return this.dao.selectByExample(null);
    }

    @Override
    public Po getOneByExample(final Example example) {
        return this.dao.selectOneByExample(example);
    }

    @Override
    public List<Po> getIn(final List<Po> records) {
        return this.dao.selectIn(records);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo) {
        return this.getByPage(pageInfo, "", "");
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final String fieldName, final String keyword) {
        if (StringUtils.isBlank(fieldName)) {
            return this.getByPage(pageInfo, (Example) null);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword));
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final Example example) {
        pageInfo.setTotals(this.dao.countByPager(pageInfo, example));
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByPager(pageInfo, example);
    }

    @Override
    public boolean exists(final Example example, final ShardTable shardTable) {
        return this.dao.countByExample(example, shardTable) > 0;
    }

    @Override
    public Po getById(final Type id, final ShardTable shardTable) {
        return this.dao.selectById(id, shardTable);
    }

    @Override
    public List<Po> getByExample(final Example example, final ShardTable shardTable) {
        return this.dao.selectByExample(example, shardTable);
    }

    @Override
    public List<Po> getAll(final ShardTable shardTable) {
        return this.dao.selectByExample(null, shardTable);
    }

    @Override
    public Po getOneByExample(final Example example, final ShardTable shardTable) {
        return this.dao.selectOneByExample(example, shardTable);
    }

    @Override
    public List<Po> getIn(final List<Po> records, final ShardTable shardTable) {
        return this.dao.selectIn(records, shardTable);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final ShardTable shardTable) {
        return this.getByPage(pageInfo, "", "", shardTable);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final String fieldName, final String keyword,
                              final ShardTable shardTable) {
        if (StringUtils.isBlank(fieldName)) {
            return this.getByPage(pageInfo, null, shardTable);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword), shardTable);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final Example example, final ShardTable shardTable) {
        pageInfo.setTotals(this.dao.countByPager(pageInfo, example, shardTable));
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByPager(pageInfo, example, shardTable);
    }

    protected abstract Example getPageExample(String fieldName, String keyword);
}
