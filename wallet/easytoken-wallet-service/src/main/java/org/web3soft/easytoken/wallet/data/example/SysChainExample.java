package org.web3soft.easytoken.wallet.data.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 针对表【sys_chain(区块链网络表)】的查询条件example类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:32
 */
public class SysChainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysChainExample() {
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

        public Criteria andParentIdIsNull() {
            this.addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            this.addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(final Integer value) {
            this.addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(final Integer value) {
            this.addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(final List<Integer> values) {
            this.addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(final List<Integer> values) {
            this.addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(final Integer value) {
            this.addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(final Integer value) {
            this.addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("parent_id <=", value, "parentId");
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

        public Criteria andTypeEqualTo(final String value) {
            this.addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(final String value) {
            this.addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(final List<String> values) {
            this.addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(final List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (Criteria) this;
        }


        public Criteria andTypeLike(final String value) {
            this.addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(final String value) {
            this.addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andIntervalsIsNull() {
            this.addCriterion("intervals is null");
            return (Criteria) this;
        }

        public Criteria andIntervalsIsNotNull() {
            this.addCriterion("intervals is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalsEqualTo(final Integer value) {
            this.addCriterion("intervals =", value, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsNotEqualTo(final Integer value) {
            this.addCriterion("intervals <>", value, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsIn(final List<Integer> values) {
            this.addCriterion("intervals in", values, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsNotIn(final List<Integer> values) {
            this.addCriterion("intervals not in", values, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsBetween(final Integer value1, final Integer value2) {
            this.addCriterion("intervals between", value1, value2, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("intervals not between", value1, value2, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsGreaterThan(final Integer value) {
            this.addCriterion("intervals >", value, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("intervals >=", value, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsLessThan(final Integer value) {
            this.addCriterion("intervals <", value, "intervals");
            return (Criteria) this;
        }

        public Criteria andIntervalsLessThanOrEqualTo(final Integer value) {
            this.addCriterion("intervals <=", value, "intervals");
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

        public Criteria andConfirmationsIsNull() {
            this.addCriterion("confirmations is null");
            return (Criteria) this;
        }

        public Criteria andConfirmationsIsNotNull() {
            this.addCriterion("confirmations is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmationsEqualTo(final Integer value) {
            this.addCriterion("confirmations =", value, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsNotEqualTo(final Integer value) {
            this.addCriterion("confirmations <>", value, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsIn(final List<Integer> values) {
            this.addCriterion("confirmations in", values, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsNotIn(final List<Integer> values) {
            this.addCriterion("confirmations not in", values, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsBetween(final Integer value1, final Integer value2) {
            this.addCriterion("confirmations between", value1, value2, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("confirmations not between", value1, value2, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsGreaterThan(final Integer value) {
            this.addCriterion("confirmations >", value, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("confirmations >=", value, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsLessThan(final Integer value) {
            this.addCriterion("confirmations <", value, "confirmations");
            return (Criteria) this;
        }

        public Criteria andConfirmationsLessThanOrEqualTo(final Integer value) {
            this.addCriterion("confirmations <=", value, "confirmations");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeIsNull() {
            this.addCriterion("enable_track_fee is null");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeIsNotNull() {
            this.addCriterion("enable_track_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeEqualTo(final Integer value) {
            this.addCriterion("enable_track_fee =", value, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeNotEqualTo(final Integer value) {
            this.addCriterion("enable_track_fee <>", value, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeIn(final List<Integer> values) {
            this.addCriterion("enable_track_fee in", values, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeNotIn(final List<Integer> values) {
            this.addCriterion("enable_track_fee not in", values, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_track_fee between", value1, value2, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("enable_track_fee not between", value1, value2, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeGreaterThan(final Integer value) {
            this.addCriterion("enable_track_fee >", value, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_track_fee >=", value, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeLessThan(final Integer value) {
            this.addCriterion("enable_track_fee <", value, "enableTrackFee");
            return (Criteria) this;
        }

        public Criteria andEnableTrackFeeLessThanOrEqualTo(final Integer value) {
            this.addCriterion("enable_track_fee <=", value, "enableTrackFee");
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

        public Criteria andBlockUrlIsNull() {
            this.addCriterion("block_url is null");
            return (Criteria) this;
        }

        public Criteria andBlockUrlIsNotNull() {
            this.addCriterion("block_url is not null");
            return (Criteria) this;
        }

        public Criteria andBlockUrlEqualTo(final String value) {
            this.addCriterion("block_url =", value, "blockUrl");
            return (Criteria) this;
        }

        public Criteria andBlockUrlNotEqualTo(final String value) {
            this.addCriterion("block_url <>", value, "blockUrl");
            return (Criteria) this;
        }

        public Criteria andBlockUrlIn(final List<String> values) {
            this.addCriterion("block_url in", values, "blockUrl");
            return (Criteria) this;
        }

        public Criteria andBlockUrlNotIn(final List<String> values) {
            this.addCriterion("block_url not in", values, "blockUrl");
            return (Criteria) this;
        }


        public Criteria andBlockUrlLike(final String value) {
            this.addCriterion("block_url like", value, "blockUrl");
            return (Criteria) this;
        }

        public Criteria andBlockUrlNotLike(final String value) {
            this.addCriterion("block_url not like", value, "blockUrl");
            return (Criteria) this;
        }

        public Criteria andTxUrlIsNull() {
            this.addCriterion("tx_url is null");
            return (Criteria) this;
        }

        public Criteria andTxUrlIsNotNull() {
            this.addCriterion("tx_url is not null");
            return (Criteria) this;
        }

        public Criteria andTxUrlEqualTo(final String value) {
            this.addCriterion("tx_url =", value, "txUrl");
            return (Criteria) this;
        }

        public Criteria andTxUrlNotEqualTo(final String value) {
            this.addCriterion("tx_url <>", value, "txUrl");
            return (Criteria) this;
        }

        public Criteria andTxUrlIn(final List<String> values) {
            this.addCriterion("tx_url in", values, "txUrl");
            return (Criteria) this;
        }

        public Criteria andTxUrlNotIn(final List<String> values) {
            this.addCriterion("tx_url not in", values, "txUrl");
            return (Criteria) this;
        }


        public Criteria andTxUrlLike(final String value) {
            this.addCriterion("tx_url like", value, "txUrl");
            return (Criteria) this;
        }

        public Criteria andTxUrlNotLike(final String value) {
            this.addCriterion("tx_url not like", value, "txUrl");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlIsNull() {
            this.addCriterion("tx_fee_url is null");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlIsNotNull() {
            this.addCriterion("tx_fee_url is not null");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlEqualTo(final String value) {
            this.addCriterion("tx_fee_url =", value, "txFeeUrl");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlNotEqualTo(final String value) {
            this.addCriterion("tx_fee_url <>", value, "txFeeUrl");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlIn(final List<String> values) {
            this.addCriterion("tx_fee_url in", values, "txFeeUrl");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlNotIn(final List<String> values) {
            this.addCriterion("tx_fee_url not in", values, "txFeeUrl");
            return (Criteria) this;
        }


        public Criteria andTxFeeUrlLike(final String value) {
            this.addCriterion("tx_fee_url like", value, "txFeeUrl");
            return (Criteria) this;
        }

        public Criteria andTxFeeUrlNotLike(final String value) {
            this.addCriterion("tx_fee_url not like", value, "txFeeUrl");
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