package org.web3soft.commons.mybatis.sample.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Where条件Criteria类，代码生成工具生成
 *
 * @author Tom Deng
 *
 */
public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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
        return new Criteria();
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

        protected void addCriterion(final String condition, final Object value1, final Object value2,
                                    final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value1, value2));
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

        public Criteria andRolesIsNull() {
            this.addCriterion("roles is null");
            return (Criteria) this;
        }

        public Criteria andRolesIsNotNull() {
            this.addCriterion("roles is not null");
            return (Criteria) this;
        }

        public Criteria andRolesEqualTo(final String value) {
            this.addCriterion("roles =", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotEqualTo(final String value) {
            this.addCriterion("roles <>", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesGreaterThan(final String value) {
            this.addCriterion("roles >", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesGreaterThanOrEqualTo(final String value) {
            this.addCriterion("roles >=", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesLessThan(final String value) {
            this.addCriterion("roles <", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesLessThanOrEqualTo(final String value) {
            this.addCriterion("roles <=", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesLike(final String value) {
            this.addCriterion("roles like", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotLike(final String value) {
            this.addCriterion("roles not like", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesIn(final List<String> values) {
            this.addCriterion("roles in", values, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotIn(final List<String> values) {
            this.addCriterion("roles not in", values, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesBetween(final String value1, final String value2) {
            this.addCriterion("roles between", value1, value2, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotBetween(final String value1, final String value2) {
            this.addCriterion("roles not between", value1, value2, "roles");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            this.addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            this.addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(final String value) {
            this.addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(final String value) {
            this.addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(final String value) {
            this.addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(final String value) {
            this.addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(final String value) {
            this.addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(final String value) {
            this.addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(final String value) {
            this.addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(final String value) {
            this.addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(final List<String> values) {
            this.addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(final List<String> values) {
            this.addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(final String value1, final String value2) {
            this.addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(final String value1, final String value2) {
            this.addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            this.addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            this.addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(final String value) {
            this.addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(final String value) {
            this.addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(final String value) {
            this.addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(final String value) {
            this.addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(final String value) {
            this.addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(final String value) {
            this.addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(final String value) {
            this.addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(final String value) {
            this.addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(final List<String> values) {
            this.addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(final List<String> values) {
            this.addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(final String value1, final String value2) {
            this.addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(final String value1, final String value2) {
            this.addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            this.addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            this.addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(final String value) {
            this.addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(final String value) {
            this.addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(final String value) {
            this.addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(final String value) {
            this.addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(final String value) {
            this.addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(final String value) {
            this.addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(final String value) {
            this.addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(final String value) {
            this.addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(final List<String> values) {
            this.addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(final List<String> values) {
            this.addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(final String value1, final String value2) {
            this.addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(final String value1, final String value2) {
            this.addCriterion("salt not between", value1, value2, "salt");
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

        public Criteria andNameGreaterThan(final String value) {
            this.addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(final String value) {
            this.addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(final String value) {
            this.addCriterion("name <=", value, "name");
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

        public Criteria andNameIn(final List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(final List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(final String value1, final String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(final String value1, final String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(final String value) {
            this.addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(final String value) {
            this.addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(final String value) {
            this.addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(final String value) {
            this.addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(final String value) {
            this.addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(final String value) {
            this.addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(final String value) {
            this.addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(final String value) {
            this.addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(final List<String> values) {
            this.addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(final List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(final String value1, final String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(final String value1, final String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(final String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(final String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(final String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(final String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(final String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(final String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(final String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(final String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(final List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(final List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(final String value1, final String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(final String value1, final String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
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

        public Criteria andStatusEqualTo(final Byte value) {
            this.addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(final Byte value) {
            this.addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(final Byte value) {
            this.addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(final Byte value) {
            this.addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(final Byte value) {
            this.addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(final Byte value) {
            this.addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(final List<Byte> values) {
            this.addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(final List<Byte> values) {
            this.addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(final Byte value1, final Byte value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(final Byte value1, final Byte value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            this.addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            this.addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(final String value) {
            this.addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(final String value) {
            this.addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(final String value) {
            this.addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(final String value) {
            this.addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(final String value) {
            this.addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(final String value) {
            this.addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(final String value) {
            this.addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(final String value) {
            this.addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(final List<String> values) {
            this.addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(final List<String> values) {
            this.addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(final String value1, final String value2) {
            this.addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(final String value1, final String value2) {
            this.addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            this.addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            this.addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(final Date value) {
            this.addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(final Date value) {
            this.addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(final Date value) {
            this.addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(final Date value) {
            this.addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(final Date value) {
            this.addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(final List<Date> values) {
            this.addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(final List<Date> values) {
            this.addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(final Date value1, final Date value2) {
            this.addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(final Date value1, final Date value2) {
            this.addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            this.addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            this.addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(final Date value) {
            this.addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(final Date value) {
            this.addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(final Date value) {
            this.addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(final Date value) {
            this.addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(final Date value) {
            this.addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(final List<Date> values) {
            this.addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(final List<Date> values) {
            this.addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(final Date value1, final Date value2) {
            this.addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(final Date value1, final Date value2) {
            this.addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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

        protected Criterion(final String condition, final Object value, final Object secondValue,
                            final String typeHandler) {
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