package com.mybatis.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public EventoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
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

		public Criteria andIdTipoEventoIsNull() {
			addCriterion("id_tipo_evento is null");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoIsNotNull() {
			addCriterion("id_tipo_evento is not null");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoEqualTo(Integer value) {
			addCriterion("id_tipo_evento =", value, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoNotEqualTo(Integer value) {
			addCriterion("id_tipo_evento <>", value, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoGreaterThan(Integer value) {
			addCriterion("id_tipo_evento >", value, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_tipo_evento >=", value, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoLessThan(Integer value) {
			addCriterion("id_tipo_evento <", value, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoLessThanOrEqualTo(Integer value) {
			addCriterion("id_tipo_evento <=", value, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoIn(List<Integer> values) {
			addCriterion("id_tipo_evento in", values, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoNotIn(List<Integer> values) {
			addCriterion("id_tipo_evento not in", values, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoBetween(Integer value1, Integer value2) {
			addCriterion("id_tipo_evento between", value1, value2, "idTipoEvento");
			return (Criteria) this;
		}

		public Criteria andIdTipoEventoNotBetween(Integer value1, Integer value2) {
			addCriterion("id_tipo_evento not between", value1, value2, "idTipoEvento");
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

		public Criteria andDuracionDiasIsNull() {
			addCriterion("duracion_dias is null");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasIsNotNull() {
			addCriterion("duracion_dias is not null");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasEqualTo(Integer value) {
			addCriterion("duracion_dias =", value, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasNotEqualTo(Integer value) {
			addCriterion("duracion_dias <>", value, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasGreaterThan(Integer value) {
			addCriterion("duracion_dias >", value, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasGreaterThanOrEqualTo(Integer value) {
			addCriterion("duracion_dias >=", value, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasLessThan(Integer value) {
			addCriterion("duracion_dias <", value, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasLessThanOrEqualTo(Integer value) {
			addCriterion("duracion_dias <=", value, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasIn(List<Integer> values) {
			addCriterion("duracion_dias in", values, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasNotIn(List<Integer> values) {
			addCriterion("duracion_dias not in", values, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasBetween(Integer value1, Integer value2) {
			addCriterion("duracion_dias between", value1, value2, "duracionDias");
			return (Criteria) this;
		}

		public Criteria andDuracionDiasNotBetween(Integer value1, Integer value2) {
			addCriterion("duracion_dias not between", value1, value2, "duracionDias");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table evento
	 * @mbg.generated  Mon Mar 26 14:56:44 COT 2018
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table evento
     *
     * @mbg.generated do_not_delete_during_merge Thu Feb 15 20:35:18 COT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}