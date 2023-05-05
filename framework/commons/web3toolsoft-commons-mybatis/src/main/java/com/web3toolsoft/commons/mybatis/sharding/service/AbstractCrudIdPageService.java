package com.web3toolsoft.commons.mybatis.sharding.service;

import com.web3toolsoft.commons.mybatis.pager.IdPageInfo;
import com.web3toolsoft.commons.mybatis.sharding.ShardTable;
import com.web3toolsoft.commons.mybatis.sharding.data.CrudIdPageRepository;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 基本增删改查(CRUD)+IdPage数据访问服务基类
 *
 * @param <Dao>
 * @param <Po>
 * @param <Example>
 * @author Tom Deng
 */
public abstract class AbstractCrudIdPageService<Dao extends CrudIdPageRepository<Po, Example, Type>, Po, Example, Type>
        extends AbstractCrudService<Dao, Po, Example, Type>
        implements CrudIdPageService<Po, Example, Type> {

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
    public List<Po> getByPage(final IdPageInfo pageInfo, final String fieldName, final String keyword,
                              final ShardTable shardTable) {
        if (StringUtils.isBlank(fieldName)) {
            return this.getByPage(pageInfo, null, shardTable);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword), shardTable);
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final Example example, final ShardTable shardTable) {
        final IdPageInfo pageInfo1 = this.getIdPageInfo(example, shardTable);
        pageInfo.setPagerParams(pageInfo1.getMaxId(), pageInfo1.getMinId(), pageInfo1.getTotals());
        pageInfo.initStartIndex();
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByIdPager(pageInfo, example, shardTable);
    }

    protected abstract Example getIdPageExample(IdPageInfo pageInfo, Example example);
}
