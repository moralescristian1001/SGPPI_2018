package com.mybatis.models;

public class TipoEvento {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tipo_evento.id_tipo_evento
     *
     * @mbg.generated Mon Mar 26 15:03:33 COT 2018
     */
    private Integer idTipoEvento;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tipo_evento.nombre_evento
     *
     * @mbg.generated Mon Mar 26 15:03:33 COT 2018
     */
    private String nombreEvento;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tipo_evento.id_tipo_evento
     *
     * @return the value of tipo_evento.id_tipo_evento
     *
     * @mbg.generated Mon Mar 26 15:03:33 COT 2018
     */
    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tipo_evento.id_tipo_evento
     *
     * @param idTipoEvento the value for tipo_evento.id_tipo_evento
     *
     * @mbg.generated Mon Mar 26 15:03:33 COT 2018
     */
    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tipo_evento.nombre_evento
     *
     * @return the value of tipo_evento.nombre_evento
     *
     * @mbg.generated Mon Mar 26 15:03:33 COT 2018
     */
    public String getNombreEvento() {
        return nombreEvento;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tipo_evento.nombre_evento
     *
     * @param nombreEvento the value for tipo_evento.nombre_evento
     *
     * @mbg.generated Mon Mar 26 15:03:33 COT 2018
     */
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
}