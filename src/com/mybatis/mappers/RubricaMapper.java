package com.mybatis.mappers;

import com.mybatis.models.Rubrica;
import com.mybatis.models.RubricaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RubricaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    long countByExample(RubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int deleteByExample(RubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int deleteByPrimaryKey(Integer idRubrica);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int insert(Rubrica record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int insertSelective(Rubrica record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    List<Rubrica> selectByExample(RubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    Rubrica selectByPrimaryKey(Integer idRubrica);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int updateByExampleSelective(@Param("record") Rubrica record, @Param("example") RubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int updateByExample(@Param("record") Rubrica record, @Param("example") RubricaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int updateByPrimaryKeySelective(Rubrica record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rubrica
     *
     * @mbg.generated Mon Mar 26 14:58:32 COT 2018
     */
    int updateByPrimaryKey(Rubrica record);
}