package com.mybatis.mappers;

import com.mybatis.models.TipoRubrica;
import com.mybatis.models.TipoRubricaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TipoRubricaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    long countByExample(TipoRubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int deleteByExample(TipoRubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int deleteByPrimaryKey(Integer idTipoRubrica);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int insert(TipoRubrica record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int insertSelective(TipoRubrica record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    List<TipoRubrica> selectByExample(TipoRubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    TipoRubrica selectByPrimaryKey(Integer idTipoRubrica);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int updateByExampleSelective(@Param("record") TipoRubrica record, @Param("example") TipoRubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int updateByExample(@Param("record") TipoRubrica record, @Param("example") TipoRubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int updateByPrimaryKeySelective(TipoRubrica record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tipo_rubrica
     *
     * @mbg.generated Mon Mar 26 15:03:58 COT 2018
     */
    int updateByPrimaryKey(TipoRubrica record);
}