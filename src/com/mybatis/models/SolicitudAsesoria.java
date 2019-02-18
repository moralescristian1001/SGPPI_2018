package com.mybatis.models;

import java.util.Date;

public class SolicitudAsesoria {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column solicitud_asesoria.id_solicitud
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	private Integer idSolicitud;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column solicitud_asesoria.id_equipo
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	private Integer idEquipo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column solicitud_asesoria.dia_semana
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	private Integer diaSemana;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column solicitud_asesoria.hora_semana
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	private Double horaSemana;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column solicitud_asesoria.aceptada
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	private Boolean aceptada;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column solicitud_asesoria.fecha_solicitud
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	private Date fechaSolicitud;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column solicitud_asesoria.id_solicitud
	 * @return  the value of solicitud_asesoria.id_solicitud
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column solicitud_asesoria.id_solicitud
	 * @param idSolicitud  the value for solicitud_asesoria.id_solicitud
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column solicitud_asesoria.id_equipo
	 * @return  the value of solicitud_asesoria.id_equipo
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public Integer getIdEquipo() {
		return idEquipo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column solicitud_asesoria.id_equipo
	 * @param idEquipo  the value for solicitud_asesoria.id_equipo
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column solicitud_asesoria.dia_semana
	 * @return  the value of solicitud_asesoria.dia_semana
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public Integer getDiaSemana() {
		return diaSemana;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column solicitud_asesoria.dia_semana
	 * @param diaSemana  the value for solicitud_asesoria.dia_semana
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column solicitud_asesoria.hora_semana
	 * @return  the value of solicitud_asesoria.hora_semana
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public Double getHoraSemana() {
		return horaSemana;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column solicitud_asesoria.hora_semana
	 * @param horaSemana  the value for solicitud_asesoria.hora_semana
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public void setHoraSemana(Double horaSemana) {
		this.horaSemana = horaSemana;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column solicitud_asesoria.aceptada
	 * @return  the value of solicitud_asesoria.aceptada
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public Boolean getAceptada() {
		return aceptada;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column solicitud_asesoria.aceptada
	 * @param aceptada  the value for solicitud_asesoria.aceptada
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public void setAceptada(Boolean aceptada) {
		this.aceptada = aceptada;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column solicitud_asesoria.fecha_solicitud
	 * @return  the value of solicitud_asesoria.fecha_solicitud
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column solicitud_asesoria.fecha_solicitud
	 * @param fechaSolicitud  the value for solicitud_asesoria.fecha_solicitud
	 * @mbg.generated  Fri Sep 07 15:22:56 COT 2018
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
}