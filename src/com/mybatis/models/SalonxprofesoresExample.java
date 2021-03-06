package com.mybatis.models;

import java.util.ArrayList;
import java.util.List;

public class SalonxprofesoresExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public SalonxprofesoresExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
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

        public Criteria andIdSalonxprofesoresIsNull() {
            addCriterion("id_salonxprofesores is null");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresIsNotNull() {
            addCriterion("id_salonxprofesores is not null");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresEqualTo(Integer value) {
            addCriterion("id_salonxprofesores =", value, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresNotEqualTo(Integer value) {
            addCriterion("id_salonxprofesores <>", value, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresGreaterThan(Integer value) {
            addCriterion("id_salonxprofesores >", value, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_salonxprofesores >=", value, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresLessThan(Integer value) {
            addCriterion("id_salonxprofesores <", value, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresLessThanOrEqualTo(Integer value) {
            addCriterion("id_salonxprofesores <=", value, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresIn(List<Integer> values) {
            addCriterion("id_salonxprofesores in", values, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresNotIn(List<Integer> values) {
            addCriterion("id_salonxprofesores not in", values, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresBetween(Integer value1, Integer value2) {
            addCriterion("id_salonxprofesores between", value1, value2, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonxprofesoresNotBetween(Integer value1, Integer value2) {
            addCriterion("id_salonxprofesores not between", value1, value2, "idSalonxprofesores");
            return (Criteria) this;
        }

        public Criteria andIdSalonIsNull() {
            addCriterion("id_salon is null");
            return (Criteria) this;
        }

        public Criteria andIdSalonIsNotNull() {
            addCriterion("id_salon is not null");
            return (Criteria) this;
        }

        public Criteria andIdSalonEqualTo(Integer value) {
            addCriterion("id_salon =", value, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonNotEqualTo(Integer value) {
            addCriterion("id_salon <>", value, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonGreaterThan(Integer value) {
            addCriterion("id_salon >", value, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_salon >=", value, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonLessThan(Integer value) {
            addCriterion("id_salon <", value, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonLessThanOrEqualTo(Integer value) {
            addCriterion("id_salon <=", value, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonIn(List<Integer> values) {
            addCriterion("id_salon in", values, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonNotIn(List<Integer> values) {
            addCriterion("id_salon not in", values, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonBetween(Integer value1, Integer value2) {
            addCriterion("id_salon between", value1, value2, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSalonNotBetween(Integer value1, Integer value2) {
            addCriterion("id_salon not between", value1, value2, "idSalon");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionIsNull() {
            addCriterion("id_socializacion is null");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionIsNotNull() {
            addCriterion("id_socializacion is not null");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionEqualTo(Integer value) {
            addCriterion("id_socializacion =", value, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionNotEqualTo(Integer value) {
            addCriterion("id_socializacion <>", value, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionGreaterThan(Integer value) {
            addCriterion("id_socializacion >", value, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_socializacion >=", value, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionLessThan(Integer value) {
            addCriterion("id_socializacion <", value, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionLessThanOrEqualTo(Integer value) {
            addCriterion("id_socializacion <=", value, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionIn(List<Integer> values) {
            addCriterion("id_socializacion in", values, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionNotIn(List<Integer> values) {
            addCriterion("id_socializacion not in", values, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionBetween(Integer value1, Integer value2) {
            addCriterion("id_socializacion between", value1, value2, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdSocializacionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_socializacion not between", value1, value2, "idSocializacion");
            return (Criteria) this;
        }

        public Criteria andIdProfesorIsNull() {
            addCriterion("id_profesor is null");
            return (Criteria) this;
        }

        public Criteria andIdProfesorIsNotNull() {
            addCriterion("id_profesor is not null");
            return (Criteria) this;
        }

        public Criteria andIdProfesorEqualTo(Integer value) {
            addCriterion("id_profesor =", value, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorNotEqualTo(Integer value) {
            addCriterion("id_profesor <>", value, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorGreaterThan(Integer value) {
            addCriterion("id_profesor >", value, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_profesor >=", value, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorLessThan(Integer value) {
            addCriterion("id_profesor <", value, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorLessThanOrEqualTo(Integer value) {
            addCriterion("id_profesor <=", value, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorIn(List<Integer> values) {
            addCriterion("id_profesor in", values, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorNotIn(List<Integer> values) {
            addCriterion("id_profesor not in", values, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorBetween(Integer value1, Integer value2) {
            addCriterion("id_profesor between", value1, value2, "idProfesor");
            return (Criteria) this;
        }

        public Criteria andIdProfesorNotBetween(Integer value1, Integer value2) {
            addCriterion("id_profesor not between", value1, value2, "idProfesor");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table salonxprofesores
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 26 14:59:51 COT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table salonxprofesores
     *
     * @mbg.generated Mon Mar 26 14:59:51 COT 2018
     */
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