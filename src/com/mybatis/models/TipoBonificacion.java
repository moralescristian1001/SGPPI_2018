package com.mybatis.models;

public class TipoBonificacion {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tipo_bonificacion.id_tipo_bonificacion
     *
     * @mbg.generated Mon Mar 26 15:03:13 COT 2018
     */
    private Integer idTipoBonificacion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tipo_bonificacion.descripcion
     *
     * @mbg.generated Mon Mar 26 15:03:13 COT 2018
     */
    private String descripcion;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tipo_bonificacion.id_tipo_bonificacion
     *
     * @return the value of tipo_bonificacion.id_tipo_bonificacion
     *
     * @mbg.generated Mon Mar 26 15:03:13 COT 2018
     */
    public Integer getIdTipoBonificacion() {
        return idTipoBonificacion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tipo_bonificacion.id_tipo_bonificacion
     *
     * @param idTipoBonificacion the value for tipo_bonificacion.id_tipo_bonificacion
     *
     * @mbg.generated Mon Mar 26 15:03:13 COT 2018
     */
    public void setIdTipoBonificacion(Integer idTipoBonificacion) {
        this.idTipoBonificacion = idTipoBonificacion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tipo_bonificacion.descripcion
     *
     * @return the value of tipo_bonificacion.descripcion
     *
     * @mbg.generated Mon Mar 26 15:03:13 COT 2018
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tipo_bonificacion.descripcion
     *
     * @param descripcion the value for tipo_bonificacion.descripcion
     *
     * @mbg.generated Mon Mar 26 15:03:13 COT 2018
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}