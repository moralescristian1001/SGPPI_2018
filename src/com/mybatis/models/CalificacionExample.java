package com.mybatis.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalificacionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public CalificacionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
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
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
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

        public Criteria andIdCalificacionIsNull() {
            addCriterion("id_calificacion is null");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionIsNotNull() {
            addCriterion("id_calificacion is not null");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionEqualTo(Integer value) {
            addCriterion("id_calificacion =", value, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionNotEqualTo(Integer value) {
            addCriterion("id_calificacion <>", value, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionGreaterThan(Integer value) {
            addCriterion("id_calificacion >", value, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_calificacion >=", value, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionLessThan(Integer value) {
            addCriterion("id_calificacion <", value, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionLessThanOrEqualTo(Integer value) {
            addCriterion("id_calificacion <=", value, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionIn(List<Integer> values) {
            addCriterion("id_calificacion in", values, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionNotIn(List<Integer> values) {
            addCriterion("id_calificacion not in", values, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionBetween(Integer value1, Integer value2) {
            addCriterion("id_calificacion between", value1, value2, "idCalificacion");
            return (Criteria) this;
        }

        public Criteria andIdCalificacionNotBetween(Integer value1, Integer value2) {
            addCriterion("id_calificacion not between", value1, value2, "idCalificacion");
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

        public Criteria andIdEventoIsNull() {
            addCriterion("id_evento is null");
            return (Criteria) this;
        }

        public Criteria andIdEventoIsNotNull() {
            addCriterion("id_evento is not null");
            return (Criteria) this;
        }

        public Criteria andIdEventoEqualTo(Integer value) {
            addCriterion("id_evento =", value, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoNotEqualTo(Integer value) {
            addCriterion("id_evento <>", value, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoGreaterThan(Integer value) {
            addCriterion("id_evento >", value, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_evento >=", value, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoLessThan(Integer value) {
            addCriterion("id_evento <", value, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoLessThanOrEqualTo(Integer value) {
            addCriterion("id_evento <=", value, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoIn(List<Integer> values) {
            addCriterion("id_evento in", values, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoNotIn(List<Integer> values) {
            addCriterion("id_evento not in", values, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoBetween(Integer value1, Integer value2) {
            addCriterion("id_evento between", value1, value2, "idEvento");
            return (Criteria) this;
        }

        public Criteria andIdEventoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_evento not between", value1, value2, "idEvento");
            return (Criteria) this;
        }

        public Criteria andFechaIsNull() {
            addCriterion("fecha is null");
            return (Criteria) this;
        }

        public Criteria andFechaIsNotNull() {
            addCriterion("fecha is not null");
            return (Criteria) this;
        }

        public Criteria andFechaEqualTo(Date value) {
            addCriterion("fecha =", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotEqualTo(Date value) {
            addCriterion("fecha <>", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThan(Date value) {
            addCriterion("fecha >", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThanOrEqualTo(Date value) {
            addCriterion("fecha >=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThan(Date value) {
            addCriterion("fecha <", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThanOrEqualTo(Date value) {
            addCriterion("fecha <=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaIn(List<Date> values) {
            addCriterion("fecha in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotIn(List<Date> values) {
            addCriterion("fecha not in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaBetween(Date value1, Date value2) {
            addCriterion("fecha between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotBetween(Date value1, Date value2) {
            addCriterion("fecha not between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andComentariosIsNull() {
            addCriterion("comentarios is null");
            return (Criteria) this;
        }

        public Criteria andComentariosIsNotNull() {
            addCriterion("comentarios is not null");
            return (Criteria) this;
        }

        public Criteria andComentariosEqualTo(String value) {
            addCriterion("comentarios =", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosNotEqualTo(String value) {
            addCriterion("comentarios <>", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosGreaterThan(String value) {
            addCriterion("comentarios >", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosGreaterThanOrEqualTo(String value) {
            addCriterion("comentarios >=", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosLessThan(String value) {
            addCriterion("comentarios <", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosLessThanOrEqualTo(String value) {
            addCriterion("comentarios <=", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosLike(String value) {
            addCriterion("comentarios like", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosNotLike(String value) {
            addCriterion("comentarios not like", value, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosIn(List<String> values) {
            addCriterion("comentarios in", values, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosNotIn(List<String> values) {
            addCriterion("comentarios not in", values, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosBetween(String value1, String value2) {
            addCriterion("comentarios between", value1, value2, "comentarios");
            return (Criteria) this;
        }

        public Criteria andComentariosNotBetween(String value1, String value2) {
            addCriterion("comentarios not between", value1, value2, "comentarios");
            return (Criteria) this;
        }

        public Criteria andNotaIsNull() {
            addCriterion("nota is null");
            return (Criteria) this;
        }

        public Criteria andNotaIsNotNull() {
            addCriterion("nota is not null");
            return (Criteria) this;
        }

        public Criteria andNotaEqualTo(Float value) {
            addCriterion("nota =", value, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaNotEqualTo(Float value) {
            addCriterion("nota <>", value, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaGreaterThan(Float value) {
            addCriterion("nota >", value, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaGreaterThanOrEqualTo(Float value) {
            addCriterion("nota >=", value, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaLessThan(Float value) {
            addCriterion("nota <", value, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaLessThanOrEqualTo(Float value) {
            addCriterion("nota <=", value, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaIn(List<Float> values) {
            addCriterion("nota in", values, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaNotIn(List<Float> values) {
            addCriterion("nota not in", values, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaBetween(Float value1, Float value2) {
            addCriterion("nota between", value1, value2, "nota");
            return (Criteria) this;
        }

        public Criteria andNotaNotBetween(Float value1, Float value2) {
            addCriterion("nota not between", value1, value2, "nota");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table calificacion
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 26 14:46:53 COT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table calificacion
     *
     * @mbg.generated Mon Mar 26 14:46:53 COT 2018
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