package ${example.packageName};

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】的查询条件example类
* @author ${author!}
* @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
public class ${example.fileName} {
protected String orderByClause;

protected boolean distinct;

protected List<Criteria> oredCriteria;

    public ${example.fileName}() {
    oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
    return orderByClause;
    }

    public void setDistinct(boolean distinct) {
    this.distinct = distinct;
    }

    public boolean isDistinct() {
    return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
        }

        public void or(Criteria criteria) {
        oredCriteria.add(criteria);
        }

        public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
        }

        public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
        oredCriteria.add(criteria);
        }
        return criteria;
        }

        protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
        }

        public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        }

        protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

            protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
                }

                public boolean isValid() {
                return criteria.size() > 0;
                }

                public List<Criterion> getAllCriteria() {
                    return criteria;
                    }

                    public List<Criterion> getCriteria() {
                        return criteria;
                        }

                        protected void addCriterion(String condition) {
                        if (condition == null) {
                        throw new RuntimeException("Value for condition cannot be null");
                        }
                        criteria.add(new Criterion(condition));
                        }

                        protected void addCriterion(String condition, Object value, String property) {
                        if (value == null) {
                        throw new RuntimeException("Value for " + property + " cannot be null");
                        }
                        criteria.add(new Criterion(condition, value));
                        }

                        protected void addCriterion(String condition, Object value1, Object value2, String property) {
                        if (value1 == null || value2 == null) {
                        throw new RuntimeException("Between values for " + property + " cannot be null");
                        }
                        criteria.add(new Criterion(condition, value1, value2));
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

                        <#list tableClass.allFields as field>
                            public Criteria and${field.fieldName?cap_first}IsNull() {
                            addCriterion("${field.columnName} is null");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}IsNotNull() {
                            addCriterion("${field.columnName} is not null");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}EqualTo(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} =", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}NotEqualTo(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} <>", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}In(List<${field.shortTypeName}> values) {
                            addCriterion("${field.columnName} in", values, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}NotIn(List<${field.shortTypeName}> values) {
                            addCriterion("${field.columnName} not in", values, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            <#if field.shortTypeName != "String">
                            public Criteria and${field.fieldName?cap_first}Between(${field.shortTypeName} value1, ${field.shortTypeName} value2) {
                            addCriterion("${field.columnName} between", value1, value2, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}NotBetween(${field.shortTypeName} value1, ${field.shortTypeName} value2) {
                            addCriterion("${field.columnName} not between", value1, value2, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}GreaterThan(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} >", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}GreaterThanOrEqualTo(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} >=", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}LessThan(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} <", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}LessThanOrEqualTo(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} <=", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }
                            </#if>

                            <#if field.shortTypeName == "String">
                            public Criteria and${field.fieldName?cap_first}Like(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} like", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }

                            public Criteria and${field.fieldName?cap_first}NotLike(${field.shortTypeName} value) {
                            addCriterion("${field.columnName} not like", value, "${field.fieldName?uncap_first}");
                            return (Criteria)this;
                            }
                            </#if>
                        </#list>
                        }

                        public static class Criteria extends GeneratedCriteria {

                        protected Criteria() {
                        super();
                        }

                        public Criteria andFieldLike(final String fieldName, final String keyword) {
                        addCriterion(fieldName + " like ", keyword, fieldName);
                        return this;
                        }
                        }

                        public static class Criterion {
                        private String condition;

                        private Object value;

                        private Object secondValue;

                        private boolean noValue;

                        private boolean singleValue;

                        private boolean betweenValue;

                        private boolean listValue;

                        private String typeHandler;

                        public String getCondition() {
                        return condition;
                        }

                        public Object getValue() {
                        return value;
                        }

                        public Object getSecondValue() {
                        return secondValue;
                        }

                        public boolean isNoValue() {
                        return noValue;
                        }

                        public boolean isSingleValue() {
                        return singleValue;
                        }

                        public boolean isBetweenValue() {
                        return betweenValue;
                        }

                        public boolean isListValue() {
                        return listValue;
                        }

                        public String getTypeHandler() {
                        return typeHandler;
                        }

                        protected Criterion(String condition) {
                        super();
                        this.condition = condition;
                        this.typeHandler = null;
                        this.noValue = true;
                        }

                        protected Criterion(String condition, Object value, String typeHandler) {
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

                        protected Criterion(String condition, Object value) {
                        this(condition, value, null);
                        }

                        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
                        super();
                        this.condition = condition;
                        this.value = value;
                        this.secondValue = secondValue;
                        this.typeHandler = typeHandler;
                        this.betweenValue = true;
                        }

                        protected Criterion(String condition, Object value, Object secondValue) {
                        this(condition, value, secondValue, null);
                        }
                        }
                        }