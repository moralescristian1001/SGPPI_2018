package com.mybatis.models;

import java.util.ArrayList;
import java.util.List;

public class BonificacionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public BonificacionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
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
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
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

        public Criteria andIdBonificacionIsNull() {
            addCriterion("id_bonificacion is null");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionIsNotNull() {
            addCriterion("id_bonificacion is not null");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionEqualTo(Integer value) {
            addCriterion("id_bonificacion =", value, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionNotEqualTo(Integer value) {
            addCriterion("id_bonificacion <>", value, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionGreaterThan(Integer value) {
            addCriterion("id_bonificacion >", value, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_bonificacion >=", value, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionLessThan(Integer value) {
            addCriterion("id_bonificacion <", value, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionLessThanOrEqualTo(Integer value) {
            addCriterion("id_bonificacion <=", value, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionIn(List<Integer> values) {
            addCriterion("id_bonificacion in", values, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionNotIn(List<Integer> values) {
            addCriterion("id_bonificacion not in", values, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionBetween(Integer value1, Integer value2) {
            addCriterion("id_bonificacion between", value1, value2, "idBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdBonificacionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_bonificacion not between", value1, value2, "idBonificacion");
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

        public Criteria andIdTipoBonificacionIsNull() {
            addCriterion("id_tipo_bonificacion is null");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionIsNotNull() {
            addCriterion("id_tipo_bonificacion is not null");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionEqualTo(Integer value) {
            addCriterion("id_tipo_bonificacion =", value, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionNotEqualTo(Integer value) {
            addCriterion("id_tipo_bonificacion <>", value, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionGreaterThan(Integer value) {
            addCriterion("id_tipo_bonificacion >", value, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_bonificacion >=", value, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionLessThan(Integer value) {
            addCriterion("id_tipo_bonificacion <", value, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_bonificacion <=", value, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionIn(List<Integer> values) {
            addCriterion("id_tipo_bonificacion in", values, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionNotIn(List<Integer> values) {
            addCriterion("id_tipo_bonificacion not in", values, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_bonificacion between", value1, value2, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdTipoBonificacionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_bonificacion not between", value1, value2, "idTipoBonificacion");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIsNull() {
            addCriterion("id_equipo is null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIsNotNull() {
            addCriterion("id_equipo is not null");
            return (Criteria) this;
        }

        public Criteria andIdEquipoEqualTo(Integer value) {
            addCriterion("id_equipo =", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotEqualTo(Integer value) {
            addCriterion("id_equipo <>", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoGreaterThan(Integer value) {
            addCriterion("id_equipo >", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_equipo >=", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoLessThan(Integer value) {
            addCriterion("id_equipo <", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoLessThanOrEqualTo(Integer value) {
            addCriterion("id_equipo <=", value, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoIn(List<Integer> values) {
            addCriterion("id_equipo in", values, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotIn(List<Integer> values) {
            addCriterion("id_equipo not in", values, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoBetween(Integer value1, Integer value2) {
            addCriterion("id_equipo between", value1, value2, "idEquipo");
            return (Criteria) this;
        }

        public Criteria andIdEquipoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_equipo not between", value1, value2, "idEquipo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bonificacion
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 26 14:46:04 COT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
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