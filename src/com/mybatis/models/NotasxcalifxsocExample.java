package com.mybatis.models;

import java.util.ArrayList;
import java.util.List;

public class NotasxcalifxsocExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public NotasxcalifxsocExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
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

		public Criteria andIdNotaxsocializacionIsNull() {
			addCriterion("id_notaxsocializacion is null");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionIsNotNull() {
			addCriterion("id_notaxsocializacion is not null");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionEqualTo(Integer value) {
			addCriterion("id_notaxsocializacion =", value, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionNotEqualTo(Integer value) {
			addCriterion("id_notaxsocializacion <>", value, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionGreaterThan(Integer value) {
			addCriterion("id_notaxsocializacion >", value, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_notaxsocializacion >=", value, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionLessThan(Integer value) {
			addCriterion("id_notaxsocializacion <", value, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionLessThanOrEqualTo(Integer value) {
			addCriterion("id_notaxsocializacion <=", value, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionIn(List<Integer> values) {
			addCriterion("id_notaxsocializacion in", values, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionNotIn(List<Integer> values) {
			addCriterion("id_notaxsocializacion not in", values, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionBetween(Integer value1, Integer value2) {
			addCriterion("id_notaxsocializacion between", value1, value2, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdNotaxsocializacionNotBetween(Integer value1, Integer value2) {
			addCriterion("id_notaxsocializacion not between", value1, value2, "idNotaxsocializacion");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocIsNull() {
			addCriterion("id_califxsoc is null");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocIsNotNull() {
			addCriterion("id_califxsoc is not null");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocEqualTo(Integer value) {
			addCriterion("id_califxsoc =", value, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocNotEqualTo(Integer value) {
			addCriterion("id_califxsoc <>", value, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocGreaterThan(Integer value) {
			addCriterion("id_califxsoc >", value, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_califxsoc >=", value, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocLessThan(Integer value) {
			addCriterion("id_califxsoc <", value, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocLessThanOrEqualTo(Integer value) {
			addCriterion("id_califxsoc <=", value, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocIn(List<Integer> values) {
			addCriterion("id_califxsoc in", values, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocNotIn(List<Integer> values) {
			addCriterion("id_califxsoc not in", values, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocBetween(Integer value1, Integer value2) {
			addCriterion("id_califxsoc between", value1, value2, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdCalifxsocNotBetween(Integer value1, Integer value2) {
			addCriterion("id_califxsoc not between", value1, value2, "idCalifxsoc");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemIsNull() {
			addCriterion("id_rubricaxitem is null");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemIsNotNull() {
			addCriterion("id_rubricaxitem is not null");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemEqualTo(Integer value) {
			addCriterion("id_rubricaxitem =", value, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemNotEqualTo(Integer value) {
			addCriterion("id_rubricaxitem <>", value, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemGreaterThan(Integer value) {
			addCriterion("id_rubricaxitem >", value, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_rubricaxitem >=", value, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemLessThan(Integer value) {
			addCriterion("id_rubricaxitem <", value, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemLessThanOrEqualTo(Integer value) {
			addCriterion("id_rubricaxitem <=", value, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemIn(List<Integer> values) {
			addCriterion("id_rubricaxitem in", values, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemNotIn(List<Integer> values) {
			addCriterion("id_rubricaxitem not in", values, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemBetween(Integer value1, Integer value2) {
			addCriterion("id_rubricaxitem between", value1, value2, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdRubricaxitemNotBetween(Integer value1, Integer value2) {
			addCriterion("id_rubricaxitem not between", value1, value2, "idRubricaxitem");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteIsNull() {
			addCriterion("id_estudiante is null");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteIsNotNull() {
			addCriterion("id_estudiante is not null");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteEqualTo(Integer value) {
			addCriterion("id_estudiante =", value, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteNotEqualTo(Integer value) {
			addCriterion("id_estudiante <>", value, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteGreaterThan(Integer value) {
			addCriterion("id_estudiante >", value, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_estudiante >=", value, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteLessThan(Integer value) {
			addCriterion("id_estudiante <", value, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteLessThanOrEqualTo(Integer value) {
			addCriterion("id_estudiante <=", value, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteIn(List<Integer> values) {
			addCriterion("id_estudiante in", values, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteNotIn(List<Integer> values) {
			addCriterion("id_estudiante not in", values, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteBetween(Integer value1, Integer value2) {
			addCriterion("id_estudiante between", value1, value2, "idEstudiante");
			return (Criteria) this;
		}

		public Criteria andIdEstudianteNotBetween(Integer value1, Integer value2) {
			addCriterion("id_estudiante not between", value1, value2, "idEstudiante");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table notasxcalifxsoc
	 * @mbg.generated  Sat Feb 16 16:10:35 COT 2019
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
     * This class corresponds to the database table notasxcalifxsoc
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 26 14:57:59 COT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}