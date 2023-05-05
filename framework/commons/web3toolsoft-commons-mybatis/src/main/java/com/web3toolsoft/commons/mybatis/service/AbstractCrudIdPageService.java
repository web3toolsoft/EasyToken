package com.web3toolsoft.commons.mybatis.service;

import com.web3toolsoft.commons.mybatis.data.CrudIdPageRepository;
import com.web3toolsoft.commons.mybatis.pager.IdPageInfo;
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
 *
 */
public abstract class AbstractCrudIdPageService<Dao extends CrudIdPageRepository<Po, Example, Type>, Po, Example, Type>
        extends AbstractCrudService<Dao, Po, Example, Type>
        implements CrudIdPageService<Po, Example, Type> {

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
    public List<Po> getByPage(final IdPageInfo pageInfo, final String fieldName, final String keyword) {
        if (StringUtils.isBlank(fieldName)) {
            return this.getByPage(pageInfo, null);
        }
        return this.getByPage(pageInfo, this.getPageExample(fieldName, keyword));
    }

    @Override
    public List<Po> getByPage(final IdPageInfo pageInfo, final Example example) {
        final IdPageInfo pageInfo1 = this.getIdPageInfo(example);
        pageInfo.setPagerParams(pageInfo1.getMaxId(), pageInfo1.getMinId(), pageInfo1.getTotals());
        pageInfo.initStartIndex();
        if (pageInfo.getTotals() <= 0) {
            return Collections.emptyList();
        }
        return this.dao.selectByIdPager(pageInfo, example);
    }

    protected abstract Example getIdPageExample(IdPageInfo pageInfo, Example example);
}
