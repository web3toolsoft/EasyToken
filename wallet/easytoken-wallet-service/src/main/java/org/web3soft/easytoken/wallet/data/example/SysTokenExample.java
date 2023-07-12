package org.web3soft.easytoken.wallet.data.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 针对表【sys_token(链上代币表)】的查询条件example类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:49
 */
public class SysTokenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysTokenExample() {
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

        public Criteria andCurrencyIdIsNull() {
            this.addCriterion("currency_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIsNotNull() {
            this.addCriterion("currency_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdEqualTo(final Integer value) {
            this.addCriterion("currency_id =", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotEqualTo(final Integer value) {
            this.addCriterion("currency_id <>", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIn(final List<Integer> values) {
            this.addCriterion("currency_id in", values, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotIn(final List<Integer> values) {
            this.addCriterion("currency_id not in", values, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("currency_id between", value1, value2, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("currency_id not between", value1, value2, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdGreaterThan(final Integer value) {
            this.addCriterion("currency_id >", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("currency_id >=", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdLessThan(final Integer value) {
            this.addCriterion("currency_id <", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("currency_id <=", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNull() {
            this.addCriterion("chain_id is null");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNotNull() {
            this.addCriterion("chain_id is not null");
            return (Criteria) this;
        }

        public Criteria andChainIdEqualTo(final Integer value) {
            this.addCriterion("chain_id =", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotEqualTo(final Integer value) {
            this.addCriterion("chain_id <>", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdIn(final List<Integer> values) {
            this.addCriterion("chain_id in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotIn(final List<Integer> values) {
            this.addCriterion("chain_id not in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("chain_id between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("chain_id not between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThan(final Integer value) {
            this.addCriterion("chain_id >", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("chain_id >=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThan(final Integer value) {
            this.addCriterion("chain_id <", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("chain_id <=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andStandardIdIsNull() {
            this.addCriterion("standard_id is null");
            return (Criteria) this;
        }

        public Criteria andStandardIdIsNotNull() {
            this.addCriterion("standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andStandardIdEqualTo(final Integer value) {
            this.addCriterion("standard_id =", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdNotEqualTo(final Integer value) {
            this.addCriterion("standard_id <>", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdIn(final List<Integer> values) {
            this.addCriterion("standard_id in", values, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdNotIn(final List<Integer> values) {
            this.addCriterion("standard_id not in", values, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("standard_id between", value1, value2, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("standard_id not between", value1, value2, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdGreaterThan(final Integer value) {
            this.addCriterion("standard_id >", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("standard_id >=", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdLessThan(final Integer value) {
            this.addCriterion("standard_id <", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("standard_id <=", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdIsNull() {
            this.addCriterion("server_node_id is null");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdIsNotNull() {
            this.addCriterion("server_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdEqualTo(final Integer value) {
            this.addCriterion("server_node_id =", value, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdNotEqualTo(final Integer value) {
            this.addCriterion("server_node_id <>", value, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdIn(final List<Integer> values) {
            this.addCriterion("server_node_id in", values, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdNotIn(final List<Integer> values) {
            this.addCriterion("server_node_id not in", values, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("server_node_id between", value1, value2, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("server_node_id not between", value1, value2, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdGreaterThan(final Integer value) {
            this.addCriterion("server_node_id >", value, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("server_node_id >=", value, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdLessThan(final Integer value) {
            this.addCriterion("server_node_id <", value, "serverNodeId");
            return (Criteria) this;
        }

        public Criteria andServerNodeIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("server_node_id <=", value, "serverNodeId");
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

        public Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(final Integer value) {
            this.addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(final Integer value) {
            this.addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(final List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(final List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(final Integer value1, final Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(final Integer value) {
            this.addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(final Integer value) {
            this.addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(final Integer value) {
            this.addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andDecimalsIsNull() {
            this.addCriterion("decimals is null");
            return (Criteria) this;
        }

        public Criteria andDecimalsIsNotNull() {
            this.addCriterion("decimals is not null");
            return (Criteria) this;
        }

        public Criteria andDecimalsEqualTo(final Integer value) {
            this.addCriterion("decimals =", value, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsNotEqualTo(final Integer value) {
            this.addCriterion("decimals <>", value, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsIn(final List<Integer> values) {
            this.addCriterion("decimals in", values, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsNotIn(final List<Integer> values) {
            this.addCriterion("decimals not in", values, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsBetween(final Integer value1, final Integer value2) {
            this.addCriterion("decimals between", value1, value2, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("decimals not between", value1, value2, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsGreaterThan(final Integer value) {
            this.addCriterion("decimals >", value, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("decimals >=", value, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsLessThan(final Integer value) {
            this.addCriterion("decimals <", value, "decimals");
            return (Criteria) this;
        }

        public Criteria andDecimalsLessThanOrEqualTo(final Integer value) {
            this.addCriterion("decimals <=", value, "decimals");
            return (Criteria) this;
        }

        public Criteria andAddressRegexIsNull() {
            this.addCriterion("address_regex is null");
            return (Criteria) this;
        }

        public Criteria andAddressRegexIsNotNull() {
            this.addCriterion("address_regex is not null");
            return (Criteria) this;
        }

        public Criteria andAddressRegexEqualTo(final String value) {
            this.addCriterion("address_regex =", value, "addressRegex");
            return (Criteria) this;
        }

        public Criteria andAddressRegexNotEqualTo(final String value) {
            this.addCriterion("address_regex <>", value, "addressRegex");
            return (Criteria) this;
        }

        public Criteria andAddressRegexIn(final List<String> values) {
            this.addCriterion("address_regex in", values, "addressRegex");
            return (Criteria) this;
        }

        public Criteria andAddressRegexNotIn(final List<String> values) {
            this.addCriterion("address_regex not in", values, "addressRegex");
            return (Criteria) this;
        }


        public Criteria andAddressRegexLike(final String value) {
            this.addCriterion("address_regex like", value, "addressRegex");
            return (Criteria) this;
        }

        public Criteria andAddressRegexNotLike(final String value) {
            this.addCriterion("address_regex not like", value, "addressRegex");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeIsNull() {
            this.addCriterion("address_token_code is null");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeIsNotNull() {
            this.addCriterion("address_token_code is not null");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeEqualTo(final String value) {
            this.addCriterion("address_token_code =", value, "addressTokenCode");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeNotEqualTo(final String value) {
            this.addCriterion("address_token_code <>", value, "addressTokenCode");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeIn(final List<String> values) {
            this.addCriterion("address_token_code in", values, "addressTokenCode");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeNotIn(final List<String> values) {
            this.addCriterion("address_token_code not in", values, "addressTokenCode");
            return (Criteria) this;
        }


        public Criteria andAddressTokenCodeLike(final String value) {
            this.addCriterion("address_token_code like", value, "addressTokenCode");
            return (Criteria) this;
        }

        public Criteria andAddressTokenCodeNotLike(final String value) {
            this.addCriterion("address_token_code not like", value, "addressTokenCode");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeIsNull() {
            this.addCriterion("main_token_code is null");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeIsNotNull() {
            this.addCriterion("main_token_code is not null");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeEqualTo(final String value) {
            this.addCriterion("main_token_code =", value, "mainTokenCode");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeNotEqualTo(final String value) {
            this.addCriterion("main_token_code <>", value, "mainTokenCode");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeIn(final List<String> values) {
            this.addCriterion("main_token_code in", values, "mainTokenCode");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeNotIn(final List<String> values) {
            this.addCriterion("main_token_code not in", values, "mainTokenCode");
            return (Criteria) this;
        }


        public Criteria andMainTokenCodeLike(final String value) {
            this.addCriterion("main_token_code like", value, "mainTokenCode");
            return (Criteria) this;
        }

        public Criteria andMainTokenCodeNotLike(final String value) {
            this.addCriterion("main_token_code not like", value, "mainTokenCode");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            this.addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            this.addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(final String value) {
            this.addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(final String value) {
            this.addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(final List<String> values) {
            this.addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(final List<String> values) {
            this.addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }


        public Criteria andSpecificationLike(final String value) {
            this.addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(final String value) {
            this.addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountIsNull() {
            this.addCriterion("min_deposit_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountIsNotNull() {
            this.addCriterion("min_deposit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountEqualTo(final BigDecimal value) {
            this.addCriterion("min_deposit_amount =", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountNotEqualTo(final BigDecimal value) {
            this.addCriterion("min_deposit_amount <>", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountIn(final List<BigDecimal> values) {
            this.addCriterion("min_deposit_amount in", values, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountNotIn(final List<BigDecimal> values) {
            this.addCriterion("min_deposit_amount not in", values, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("min_deposit_amount between", value1, value2, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountNotBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("min_deposit_amount not between", value1, value2, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountGreaterThan(final BigDecimal value) {
            this.addCriterion("min_deposit_amount >", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountGreaterThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("min_deposit_amount >=", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountLessThan(final BigDecimal value) {
            this.addCriterion("min_deposit_amount <", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountLessThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("min_deposit_amount <=", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountIsNull() {
            this.addCriterion("min_withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountIsNotNull() {
            this.addCriterion("min_withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountEqualTo(final BigDecimal value) {
            this.addCriterion("min_withdraw_amount =", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountNotEqualTo(final BigDecimal value) {
            this.addCriterion("min_withdraw_amount <>", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountIn(final List<BigDecimal> values) {
            this.addCriterion("min_withdraw_amount in", values, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountNotIn(final List<BigDecimal> values) {
            this.addCriterion("min_withdraw_amount not in", values, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("min_withdraw_amount between", value1, value2, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountNotBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("min_withdraw_amount not between", value1, value2, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountGreaterThan(final BigDecimal value) {
            this.addCriterion("min_withdraw_amount >", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountGreaterThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("min_withdraw_amount >=", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountLessThan(final BigDecimal value) {
            this.addCriterion("min_withdraw_amount <", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountLessThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("min_withdraw_amount <=", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountIsNull() {
            this.addCriterion("max_withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountIsNotNull() {
            this.addCriterion("max_withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountEqualTo(final BigDecimal value) {
            this.addCriterion("max_withdraw_amount =", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountNotEqualTo(final BigDecimal value) {
            this.addCriterion("max_withdraw_amount <>", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountIn(final List<BigDecimal> values) {
            this.addCriterion("max_withdraw_amount in", values, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountNotIn(final List<BigDecimal> values) {
            this.addCriterion("max_withdraw_amount not in", values, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("max_withdraw_amount between", value1, value2, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountNotBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("max_withdraw_amount not between", value1, value2, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountGreaterThan(final BigDecimal value) {
            this.addCriterion("max_withdraw_amount >", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountGreaterThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("max_withdraw_amount >=", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountLessThan(final BigDecimal value) {
            this.addCriterion("max_withdraw_amount <", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountLessThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("max_withdraw_amount <=", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountIsNull() {
            this.addCriterion("min_reserved_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountIsNotNull() {
            this.addCriterion("min_reserved_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountEqualTo(final BigDecimal value) {
            this.addCriterion("min_reserved_amount =", value, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountNotEqualTo(final BigDecimal value) {
            this.addCriterion("min_reserved_amount <>", value, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountIn(final List<BigDecimal> values) {
            this.addCriterion("min_reserved_amount in", values, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountNotIn(final List<BigDecimal> values) {
            this.addCriterion("min_reserved_amount not in", values, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("min_reserved_amount between", value1, value2, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountNotBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("min_reserved_amount not between", value1, value2, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountGreaterThan(final BigDecimal value) {
            this.addCriterion("min_reserved_amount >", value, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountGreaterThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("min_reserved_amount >=", value, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountLessThan(final BigDecimal value) {
            this.addCriterion("min_reserved_amount <", value, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andMinReservedAmountLessThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("min_reserved_amount <=", value, "minReservedAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesIsNull() {
            this.addCriterion("withdraw_fees is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesIsNotNull() {
            this.addCriterion("withdraw_fees is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesEqualTo(final BigDecimal value) {
            this.addCriterion("withdraw_fees =", value, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesNotEqualTo(final BigDecimal value) {
            this.addCriterion("withdraw_fees <>", value, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesIn(final List<BigDecimal> values) {
            this.addCriterion("withdraw_fees in", values, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesNotIn(final List<BigDecimal> values) {
            this.addCriterion("withdraw_fees not in", values, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("withdraw_fees between", value1, value2, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesNotBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("withdraw_fees not between", value1, value2, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesGreaterThan(final BigDecimal value) {
            this.addCriterion("withdraw_fees >", value, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesGreaterThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("withdraw_fees >=", value, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesLessThan(final BigDecimal value) {
            this.addCriterion("withdraw_fees <", value, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeesLessThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("withdraw_fees <=", value, "withdrawFees");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNull() {
            this.addCriterion("contract_address is null");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNotNull() {
            this.addCriterion("contract_address is not null");
            return (Criteria) this;
        }

        public Criteria andContractAddressEqualTo(final String value) {
            this.addCriterion("contract_address =", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotEqualTo(final String value) {
            this.addCriterion("contract_address <>", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressIn(final List<String> values) {
            this.addCriterion("contract_address in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotIn(final List<String> values) {
            this.addCriterion("contract_address not in", values, "contractAddress");
            return (Criteria) this;
        }


        public Criteria andContractAddressLike(final String value) {
            this.addCriterion("contract_address like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotLike(final String value) {
            this.addCriterion("contract_address not like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultIsNull() {
            this.addCriterion("enable_default is null");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultIsNotNull() {
            this.addCriterion("enable_default is not null");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultEqualTo(final Integer value) {
            this.addCriterion("enable_default =", value, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultNotEqualTo(final Integer value) {
            this.addCriterion("enable_default <>", value, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultIn(final List<Integer> values) {
            this.addCriterion("enable_default in", values, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultNotIn(final List<Integer> values) {
            this.addCriterion("enable_default not in", values, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_default between", value1, value2, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_default not between", value1, value2, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultGreaterThan(final Integer value) {
            this.addCriterion("enable_default >", value, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_default >=", value, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultLessThan(final Integer value) {
            this.addCriterion("enable_default <", value, "enableDefault");
            return (Criteria) this;
        }

        public Criteria andEnableDefaultLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_default <=", value, "enableDefault");
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

        public Criteria andSignTypeIsNull() {
            this.addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            this.addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(final Integer value) {
            this.addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(final Integer value) {
            this.addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(final List<Integer> values) {
            this.addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(final List<Integer> values) {
            this.addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(final Integer value1, final Integer value2) {
            this.addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("sign_type not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(final Integer value) {
            this.addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(final Integer value) {
            this.addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(final Integer value) {
            this.addCriterion("sign_type <=", value, "signType");
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

        public Criteria andTableSpecsIsNull() {
            this.addCriterion("table_specs is null");
            return (Criteria) this;
        }

        public Criteria andTableSpecsIsNotNull() {
            this.addCriterion("table_specs is not null");
            return (Criteria) this;
        }

        public Criteria andTableSpecsEqualTo(final String value) {
            this.addCriterion("table_specs =", value, "tableSpecs");
            return (Criteria) this;
        }

        public Criteria andTableSpecsNotEqualTo(final String value) {
            this.addCriterion("table_specs <>", value, "tableSpecs");
            return (Criteria) this;
        }

        public Criteria andTableSpecsIn(final List<String> values) {
            this.addCriterion("table_specs in", values, "tableSpecs");
            return (Criteria) this;
        }

        public Criteria andTableSpecsNotIn(final List<String> values) {
            this.addCriterion("table_specs not in", values, "tableSpecs");
            return (Criteria) this;
        }


        public Criteria andTableSpecsLike(final String value) {
            this.addCriterion("table_specs like", value, "tableSpecs");
            return (Criteria) this;
        }

        public Criteria andTableSpecsNotLike(final String value) {
            this.addCriterion("table_specs not like", value, "tableSpecs");
            return (Criteria) this;
        }

        public Criteria andPropertiesIsNull() {
            this.addCriterion("properties is null");
            return (Criteria) this;
        }

        public Criteria andPropertiesIsNotNull() {
            this.addCriterion("properties is not null");
            return (Criteria) this;
        }

        public Criteria andPropertiesEqualTo(final String value) {
            this.addCriterion("properties =", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotEqualTo(final String value) {
            this.addCriterion("properties <>", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesIn(final List<String> values) {
            this.addCriterion("properties in", values, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotIn(final List<String> values) {
            this.addCriterion("properties not in", values, "properties");
            return (Criteria) this;
        }


        public Criteria andPropertiesLike(final String value) {
            this.addCriterion("properties like", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotLike(final String value) {
            this.addCriterion("properties not like", value, "properties");
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