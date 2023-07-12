package org.web3soft.commons.mybatis.service;

import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.mybatis.data.SelectRepository;
import org.web3soft.commons.mybatis.pager.IdPageInfo;
import org.web3soft.commons.mybatis.pager.PageInfo;
import org.web3soft.commons.mybatis.sharding.ShardTable;
import org.web3soft.commons.mybatis.util.SqlInjectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @param <Type>    Key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
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
        return this.dao.selectById(id, null);
    }

    @Override
    public Po getById(final Type id, final List<String> columns) {
        return this.dao.selectById(id, columns);
    }

    @Override
    public List<Po> getByExample(final Example example) {
        return this.dao.selectByExample(example, null);
    }

    @Override
    public List<Po> getByExample(final Example example, final List<String> columns) {
        return this.dao.selectByExample(example, columns);
    }

    @Override
    public List<Po> getAll() {
        return this.dao.selectByExample(null, null);
    }

    @Override
    public List<Po> getAll(final List<String> columns) {
        return this.dao.selectByExample(null, columns);
    }

    @Override
    public Po getOneByExample(final Example example) {
        return this.dao.selectOneByExample(example, null);
    }

    @Override
    public Po getOneByExample(final Example example, final List<String> columns) {
        return this.dao.selectOneByExample(example, columns);
    }

    @Override
    public List<Po> getIn(final List<Type> ids) {
        return this.dao.selectIn(ids, null);
    }

    @Override
    public List<Po> getIn(final List<Type> ids, final List<String> columns) {
        return this.dao.selectIn(ids, columns);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo) {
        return this.getByPage(pageInfo, "", "");
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final List<String> columns) {
        return this.getByPage(pageInfo, "", "", columns);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final String fieldName, final String keyword) {
        return this.getByPage(pageInfo, fieldName, keyword, (List<String>) null);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final String fieldName, final String keyword, final List<String> columns) {
        if (StringUtils.isBlank(fieldName) || SqlInjectionUtils.check(fieldName)) {
            return this.getByPage(pageInfo, (Example) null, columns);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword), columns);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final Example example) {
        return this.getByPage(pageInfo, example, (List<String>) null);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final Example example, final List<String> columns) {
        pageInfo.setTotals(this.dao.countByPager(pageInfo, example));
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByPager(pageInfo, example, columns);
    }

    @Override
    public boolean exists(final Example example, final ShardTable shardTable) {
        return this.dao.countByExample(example, shardTable) > 0;
    }

    @Override
    public Po getById(final Type id, final ShardTable shardTable) {
        return this.dao.selectById(id, shardTable, null);
    }

    @Override
    public Po getById(final Type id, final ShardTable shardTable, final List<String> columns) {
        return this.dao.selectById(id, shardTable, columns);
    }

    @Override
    public List<Po> getByExample(final Example example, final ShardTable shardTable) {
        return this.dao.selectByExample(example, shardTable, null);
    }

    @Override
    public List<Po> getByExample(final Example example, final ShardTable shardTable, final List<String> columns) {
        return this.dao.selectByExample(example, shardTable, columns);
    }

    @Override
    public List<Po> getAll(final ShardTable shardTable) {
        return this.dao.selectByExample(null, shardTable, null);
    }

    @Override
    public List<Po> getAll(final ShardTable shardTable, final List<String> columns) {
        return this.dao.selectByExample(null, shardTable, columns);
    }

    @Override
    public Po getOneByExample(final Example example, final ShardTable shardTable) {
        return this.dao.selectOneByExample(example, shardTable, null);
    }

    @Override
    public Po getOneByExample(final Example example, final ShardTable shardTable, final List<String> columns) {
        return this.dao.selectOneByExample(example, shardTable, columns);
    }

    @Override
    public List<Po> getIn(final List<Type> ids, final ShardTable shardTable) {
        return this.dao.selectIn(ids, shardTable, null);
    }

    @Override
    public List<Po> getIn(final List<Type> ids, final ShardTable shardTable, final List<String> columns) {
        return this.dao.selectIn(ids, shardTable, columns);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final ShardTable shardTable) {
        return this.getByPage(pageInfo, "", "", shardTable);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final ShardTable shardTable, final List<String> columns) {
        return this.getByPage(pageInfo, "", "", shardTable, columns);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final String fieldName, final String keyword,
                              final ShardTable shardTable) {
        return this.getByPage(pageInfo, fieldName, keyword, shardTable, null);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final String fieldName, final String keyword, final ShardTable shardTable,
                              final List<String> columns) {
        if (StringUtils.isBlank(fieldName) || SqlInjectionUtils.check(fieldName)) {
            return this.getByPage(pageInfo, null, shardTable, columns);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword), shardTable, columns);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final Example example, final ShardTable shardTable) {
        return this.getByPage(pageInfo, example, shardTable, null);
    }

    @Override
    public List<Po> getByPage(final PageInfo pageInfo, final Example example, final ShardTable shardTable, final List<String> columns) {
        pageInfo.setTotals(this.dao.countByPager(pageInfo, example, shardTable));
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByPager(pageInfo, example, shardTable, columns);
    }

    @Override
    public IdPageInfo getIdPageInfo(final Example example) {
        final IdPageInfo pageInfo = new IdPageInfo();
        this.setIdPageInfoParams(pageInfo, example);
        pageInfo.initStartIndex();
        return pageInfo;
    }

    protected void setIdPageInfoParams(final IdPageInfo pageInfo, final Example example) {
        final Map<String, Long> cntMap = this.dao.countByIdPager(pageInfo, example);
        pageInfo.setPagerParams(
                cntMap.getOrDefault("maxId", 0L),
                cntMap.getOrDefault("minId", 0L),
                cntMap.getOrDefault("total", 0L)
        );
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo) {
        return this.getByPage(pageInfo, "", "");
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final List<String> columns) {
        return this.getByPage(pageInfo, "", "", columns);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final String fieldName, final String keyword) {
        return this.getByPage(pageInfo, fieldName, keyword, (List<String>) null);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final String fieldName, final String keyword, final List<String> columns) {
        if (StringUtils.isBlank(fieldName) || SqlInjectionUtils.check(fieldName)) {
            return this.getByPage(pageInfo, (Example) null, columns);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword), columns);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final Example example) {
        return this.getByPage(pageInfo, example, (List<String>) null);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final Example example, final List<String> columns) {
        final IdPageInfo pageInfo1 = this.getIdPageInfo(example);
        pageInfo.setPagerParams(pageInfo1.getMaxId(), pageInfo1.getMinId(), pageInfo1.getTotals());
        pageInfo.initStartIndex();
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByIdPager(pageInfo, example, columns);
    }

    @Override
    public IdPageInfo getIdPageInfo(final Example example, final ShardTable shardTable) {
        final IdPageInfo pageInfo = new IdPageInfo();
        this.setIdPageInfoParams(pageInfo, example, shardTable);
        pageInfo.initStartIndex();
        return pageInfo;
    }

    protected void setIdPageInfoParams(final IdPageInfo pageInfo, final Example example, final ShardTable shardTable) {
        final Map<String, Long> cntMap = this.dao.countByIdPager(pageInfo, example, shardTable);
        pageInfo.setPagerParams(
                cntMap.getOrDefault("maxId", 0L),
                cntMap.getOrDefault("minId", 0L),
                cntMap.getOrDefault("total", 0L)
        );
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final ShardTable shardTable) {
        return this.getByPage(pageInfo, "", "", shardTable);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final ShardTable shardTable, final List<String> columns) {
        return this.getByPage(pageInfo, "", "", shardTable, columns);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final String fieldName, final String keyword, final ShardTable shardTable) {
        return this.getByPage(pageInfo, fieldName, keyword, shardTable, null);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final String fieldName, final String keyword, final ShardTable shardTable,
                              final List<String> columns) {
        if (StringUtils.isBlank(fieldName) || SqlInjectionUtils.check(fieldName)) {
            return this.getByPage(pageInfo, null, shardTable, columns);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword), shardTable, columns);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final Example example, final ShardTable shardTable) {
        return this.getByPage(pageInfo, example, shardTable, null);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final Example example, final ShardTable shardTable, final List<String> columns) {
        final IdPageInfo pageInfo1 = this.getIdPageInfo(example, shardTable);
        pageInfo.setPagerParams(pageInfo1.getMaxId(), pageInfo1.getMinId(), pageInfo1.getTotals());
        pageInfo.initStartIndex();
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByIdPager(pageInfo, example, shardTable, columns);
    }

    protected abstract Example getPageExample(String fieldName, String keyword);
}
