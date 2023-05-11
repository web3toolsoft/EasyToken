package org.web3soft.easytoken.wallet.data.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 针对表【sys_server_node(钱包部署服务节点表)】的查询条件example类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:46
 */
public class SysServerNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysServerNodeExample() {
        this.oredCriteria = new ArrayList<>();
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setOrderByClause(final String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public void setDistinct(final boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(final Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        final Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        final Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        final Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            this.criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(final String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            this.criteria.add(new Criterion(condition));
        }

        protected void addCriterion(final String condition, final Object value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(final String condition, final Object value1, final Object value2, final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFieldIsNull(final String fieldName) {
            this.addCriterion(fieldName + " is null");
            return (Criteria) this;
        }

        public Criteria andFieldIsNotNull(final String fieldName) {
            this.addCriterion(fieldName + " is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEqualTo(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " =", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNotEqualTo(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " <>", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThan(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " >", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThanOrEqualTo(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " >=", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldLessThan(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " <", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldLessThanOrEqualTo(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " <=", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldLike(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " like", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNotLike(final String fieldName, final Object fieldValue) {
            this.addCriterion(fieldName + " not like", fieldValue, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldIn(final String fieldName, final List<Object> fieldValues) {
            this.addCriterion(fieldName + " in", fieldValues, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNotIn(final String fieldName, final List<Object> fieldValues) {
            this.addCriterion(fieldName + " not in", fieldValues, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldBetween(final String fieldName, final Object fieldValue1, final Object fieldValue2) {
            this.addCriterion(fieldName + " between", fieldValue1, fieldValue2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNotBetween(final String fieldName, final Object fieldValue1, final Object fieldValue2) {
            this.addCriterion(fieldName + " not between", fieldValue1, fieldValue2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(final Integer value) {
            this.addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(final Integer value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(final List<Integer> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(final List<Integer> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(final Integer value) {
            this.addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(final Integer value) {
            this.addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            this.addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            this.addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(final String value) {
            this.addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(final String value) {
            this.addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(final List<String> values) {
            this.addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(final List<String> values) {
            this.addCriterion("code not in", values, "code");
            return (Criteria) this;
        }


        public Criteria andCodeLike(final String value) {
            this.addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(final String value) {
            this.addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(final String value) {
            this.addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(final String value) {
            this.addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(final List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(final List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria) this;
        }


        public Criteria andNameLike(final String value) {
            this.addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(final String value) {
            this.addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            this.addCriterion("host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            this.addCriterion("host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(final String value) {
            this.addCriterion("host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(final String value) {
            this.addCriterion("host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(final List<String> values) {
            this.addCriterion("host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(final List<String> values) {
            this.addCriterion("host not in", values, "host");
            return (Criteria) this;
        }


        public Criteria andHostLike(final String value) {
            this.addCriterion("host like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(final String value) {
            this.addCriterion("host not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andEnableDepositIsNull() {
            this.addCriterion("enable_deposit is null");
            return (Criteria) this;
        }

        public Criteria andEnableDepositIsNotNull() {
            this.addCriterion("enable_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andEnableDepositEqualTo(final Integer value) {
            this.addCriterion("enable_deposit =", value, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositNotEqualTo(final Integer value) {
            this.addCriterion("enable_deposit <>", value, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositIn(final List<Integer> values) {
            this.addCriterion("enable_deposit in", values, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositNotIn(final List<Integer> values) {
            this.addCriterion("enable_deposit not in", values, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_deposit between", value1, value2, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_deposit not between", value1, value2, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositGreaterThan(final Integer value) {
            this.addCriterion("enable_deposit >", value, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_deposit >=", value, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositLessThan(final Integer value) {
            this.addCriterion("enable_deposit <", value, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableDepositLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_deposit <=", value, "enableDeposit");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateIsNull() {
            this.addCriterion("enable_aggregate is null");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateIsNotNull() {
            this.addCriterion("enable_aggregate is not null");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateEqualTo(final Integer value) {
            this.addCriterion("enable_aggregate =", value, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateNotEqualTo(final Integer value) {
            this.addCriterion("enable_aggregate <>", value, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateIn(final List<Integer> values) {
            this.addCriterion("enable_aggregate in", values, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateNotIn(final List<Integer> values) {
            this.addCriterion("enable_aggregate not in", values, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_aggregate between", value1, value2, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_aggregate not between", value1, value2, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateGreaterThan(final Integer value) {
            this.addCriterion("enable_aggregate >", value, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_aggregate >=", value, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateLessThan(final Integer value) {
            this.addCriterion("enable_aggregate <", value, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableAggregateLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_aggregate <=", value, "enableAggregate");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawIsNull() {
            this.addCriterion("enable_withdraw is null");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawIsNotNull() {
            this.addCriterion("enable_withdraw is not null");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawEqualTo(final Integer value) {
            this.addCriterion("enable_withdraw =", value, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawNotEqualTo(final Integer value) {
            this.addCriterion("enable_withdraw <>", value, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawIn(final List<Integer> values) {
            this.addCriterion("enable_withdraw in", values, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawNotIn(final List<Integer> values) {
            this.addCriterion("enable_withdraw not in", values, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_withdraw between", value1, value2, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_withdraw not between", value1, value2, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawGreaterThan(final Integer value) {
            this.addCriterion("enable_withdraw >", value, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_withdraw >=", value, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawLessThan(final Integer value) {
            this.addCriterion("enable_withdraw <", value, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableWithdrawLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_withdraw <=", value, "enableWithdraw");
            return (Criteria) this;
        }

        public Criteria andEnableSignIsNull() {
            this.addCriterion("enable_sign is null");
            return (Criteria) this;
        }

        public Criteria andEnableSignIsNotNull() {
            this.addCriterion("enable_sign is not null");
            return (Criteria) this;
        }

        public Criteria andEnableSignEqualTo(final Integer value) {
            this.addCriterion("enable_sign =", value, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignNotEqualTo(final Integer value) {
            this.addCriterion("enable_sign <>", value, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignIn(final List<Integer> values) {
            this.addCriterion("enable_sign in", values, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignNotIn(final List<Integer> values) {
            this.addCriterion("enable_sign not in", values, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_sign between", value1, value2, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_sign not between", value1, value2, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignGreaterThan(final Integer value) {
            this.addCriterion("enable_sign >", value, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_sign >=", value, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignLessThan(final Integer value) {
            this.addCriterion("enable_sign <", value, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableSignLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_sign <=", value, "enableSign");
            return (Criteria) this;
        }

        public Criteria andEnableStatIsNull() {
            this.addCriterion("enable_stat is null");
            return (Criteria) this;
        }

        public Criteria andEnableStatIsNotNull() {
            this.addCriterion("enable_stat is not null");
            return (Criteria) this;
        }

        public Criteria andEnableStatEqualTo(final Integer value) {
            this.addCriterion("enable_stat =", value, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatNotEqualTo(final Integer value) {
            this.addCriterion("enable_stat <>", value, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatIn(final List<Integer> values) {
            this.addCriterion("enable_stat in", values, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatNotIn(final List<Integer> values) {
            this.addCriterion("enable_stat not in", values, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_stat between", value1, value2, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_stat not between", value1, value2, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatGreaterThan(final Integer value) {
            this.addCriterion("enable_stat >", value, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_stat >=", value, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatLessThan(final Integer value) {
            this.addCriterion("enable_stat <", value, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableStatLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_stat <=", value, "enableStat");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerIsNull() {
            this.addCriterion("enable_crawler is null");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerIsNotNull() {
            this.addCriterion("enable_crawler is not null");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerEqualTo(final Integer value) {
            this.addCriterion("enable_crawler =", value, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerNotEqualTo(final Integer value) {
            this.addCriterion("enable_crawler <>", value, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerIn(final List<Integer> values) {
            this.addCriterion("enable_crawler in", values, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerNotIn(final List<Integer> values) {
            this.addCriterion("enable_crawler not in", values, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_crawler between", value1, value2, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_crawler not between", value1, value2, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerGreaterThan(final Integer value) {
            this.addCriterion("enable_crawler >", value, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_crawler >=", value, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerLessThan(final Integer value) {
            this.addCriterion("enable_crawler <", value, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableCrawlerLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_crawler <=", value, "enableCrawler");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheIsNull() {
            this.addCriterion("enable_reload_cache is null");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheIsNotNull() {
            this.addCriterion("enable_reload_cache is not null");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheEqualTo(final Integer value) {
            this.addCriterion("enable_reload_cache =", value, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheNotEqualTo(final Integer value) {
            this.addCriterion("enable_reload_cache <>", value, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheIn(final List<Integer> values) {
            this.addCriterion("enable_reload_cache in", values, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheNotIn(final List<Integer> values) {
            this.addCriterion("enable_reload_cache not in", values, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_reload_cache between", value1, value2, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_reload_cache not between", value1, value2, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheGreaterThan(final Integer value) {
            this.addCriterion("enable_reload_cache >", value, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_reload_cache >=", value, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheLessThan(final Integer value) {
            this.addCriterion("enable_reload_cache <", value, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andEnableReloadCacheLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_reload_cache <=", value, "enableReloadCache");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(final Integer value) {
            this.addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(final Integer value) {
            this.addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(final List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(final List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(final Integer value1, final Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(final Integer value) {
            this.addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(final Integer value) {
            this.addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(final Integer value) {
            this.addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            this.addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            this.addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(final String value) {
            this.addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(final String value) {
            this.addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(final List<String> values) {
            this.addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(final List<String> values) {
            this.addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }


        public Criteria andMemoLike(final String value) {
            this.addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(final String value) {
            this.addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            this.addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            this.addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(final Date value) {
            this.addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(final Date value) {
            this.addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(final List<Date> values) {
            this.addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(final List<Date> values) {
            this.addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(final Date value1, final Date value2) {
            this.addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(final Date value1, final Date value2) {
            this.addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(final Date value) {
            this.addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(final Date value) {
            this.addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(final Date value) {
            this.addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            this.addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            this.addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(final Date value) {
            this.addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(final Date value) {
            this.addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(final List<Date> values) {
            this.addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(final List<Date> values) {
            this.addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(final Date value1, final Date value2) {
            this.addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(final Date value1, final Date value2) {
            this.addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(final Date value) {
            this.addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(final Date value) {
            this.addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(final Date value) {
            this.addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andFieldLike(final String fieldName, final String keyword) {
            this.addCriterion(fieldName + " like ", keyword, fieldName);
            return this;
        }
    }

    public static class Criterion {
        private final String condition;
        private final String typeHandler;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;

        protected Criterion(final String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(final String condition, final Object value, final String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(final String condition, final Object value) {
            this(condition, value, null);
        }

        protected Criterion(final String condition, final Object value, final Object secondValue, final String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(final String condition, final Object value, final Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }
    }
}