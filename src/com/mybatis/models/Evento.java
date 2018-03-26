package com.mybatis.models;

import java.util.Date;

public class Evento {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evento.id_evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    private Integer idEvento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evento.id_tipo_evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    private Integer idTipoEvento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evento.fecha
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    private Date fecha;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evento.duracion_dias
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    private Integer duracionDias;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evento.id_evento
     *
     * @return the value of evento.id_evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public Integer getIdEvento() {
        return idEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evento.id_evento
     *
     * @param idEvento the value for evento.id_evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evento.id_tipo_evento
     *
     * @return the value of evento.id_tipo_evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evento.id_tipo_evento
     *
     * @param idTipoEvento the value for evento.id_tipo_evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evento.fecha
     *
     * @return the value of evento.fecha
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evento.fecha
     *
     * @param fecha the value for evento.fecha
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evento.duracion_dias
     *
     * @return the value of evento.duracion_dias
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public Integer getDuracionDias() {
        return duracionDias;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evento.duracion_dias
     *
     * @param duracionDias the value for evento.duracion_dias
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }
}