package com.mybatis.models;

public class Semestre {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column semestre.id_semestre
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    private Integer idSemestre;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column semestre.ano
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    private Integer ano;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column semestre.numero
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    private Short numero;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column semestre.id_semestre
     *
     * @return the value of semestre.id_semestre
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    public Integer getIdSemestre() {
        return idSemestre;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column semestre.id_semestre
     *
     * @param idSemestre the value for semestre.id_semestre
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column semestre.ano
     *
     * @return the value of semestre.ano
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column semestre.ano
     *
     * @param ano the value for semestre.ano
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column semestre.numero
     *
     * @return the value of semestre.numero
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    public Short getNumero() {
        return numero;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column semestre.numero
     *
     * @param numero the value for semestre.numero
     *
     * @mbg.generated Mon Mar 26 15:00:45 COT 2018
     */
    public void setNumero(Short numero) {
        this.numero = numero;
    }
}