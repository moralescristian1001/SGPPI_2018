package com.mybatis.models;

import java.util.ArrayList;
import java.util.List;

public class EstudiantesxequiposExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public EstudiantesxequiposExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
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

		public Criteria andIdEstxequipIsNull() {
			addCriterion("id_estxequip is null");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipIsNotNull() {
			addCriterion("id_estxequip is not null");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipEqualTo(Integer value) {
			addCriterion("id_estxequip =", value, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipNotEqualTo(Integer value) {
			addCriterion("id_estxequip <>", value, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipGreaterThan(Integer value) {
			addCriterion("id_estxequip >", value, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_estxequip >=", value, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipLessThan(Integer value) {
			addCriterion("id_estxequip <", value, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipLessThanOrEqualTo(Integer value) {
			addCriterion("id_estxequip <=", value, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipIn(List<Integer> values) {
			addCriterion("id_estxequip in", values, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipNotIn(List<Integer> values) {
			addCriterion("id_estxequip not in", values, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipBetween(Integer value1, Integer value2) {
			addCriterion("id_estxequip between", value1, value2, "idEstxequip");
			return (Criteria) this;
		}

		public Criteria andIdEstxequipNotBetween(Integer value1, Integer value2) {
			addCriterion("id_estxequip not between", value1, value2, "idEstxequip");
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

		public Criteria andNombreIsNull() {
			addCriterion("nombre is null");
			return (Criteria) this;
		}

		public Criteria andNombreIsNotNull() {
			addCriterion("nombre is not null");
			return (Criteria) this;
		}

		public Criteria andNombreEqualTo(String value) {
			addCriterion("nombre =", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreNotEqualTo(String value) {
			addCriterion("nombre <>", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreGreaterThan(String value) {
			addCriterion("nombre >", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreGreaterThanOrEqualTo(String value) {
			addCriterion("nombre >=", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreLessThan(String value) {
			addCriterion("nombre <", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreLessThanOrEqualTo(String value) {
			addCriterion("nombre <=", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreLike(String value) {
			addCriterion("nombre like", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreNotLike(String value) {
			addCriterion("nombre not like", value, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreIn(List<String> values) {
			addCriterion("nombre in", values, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreNotIn(List<String> values) {
			addCriterion("nombre not in", values, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreBetween(String value1, String value2) {
			addCriterion("nombre between", value1, value2, "nombre");
			return (Criteria) this;
		}

		public Criteria andNombreNotBetween(String value1, String value2) {
			addCriterion("nombre not between", value1, value2, "nombre");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table estudiantesxequipos
	 * @mbg.generated  Mon Dec 04 04:05:06 COT 2017
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
     * This class corresponds to the database table estudiantesxequipos
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 04 00:52:06 COT 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}