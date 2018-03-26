package com.mybatis.mappers;

import com.mybatis.models.Evento;
import com.mybatis.models.EventoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    long countByExample(EventoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int deleteByExample(EventoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int deleteByPrimaryKey(Integer idEvento);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int insert(Evento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int insertSelective(Evento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    List<Evento> selectByExample(EventoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    Evento selectByPrimaryKey(Integer idEvento);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int updateByExampleSelective(@Param("record") Evento record, @Param("example") EventoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int updateByExample(@Param("record") Evento record, @Param("example") EventoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int updateByPrimaryKeySelective(Evento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evento
     *
     * @mbg.generated Thu Feb 15 20:35:18 COT 2018
     */
    int updateByPrimaryKey(Evento record);
}