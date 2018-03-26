package com.mybatis.mappers;

import com.mybatis.models.Profesoresxasignaturas;
import com.mybatis.models.ProfesoresxasignaturasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfesoresxasignaturasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    long countByExample(ProfesoresxasignaturasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int deleteByExample(ProfesoresxasignaturasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int deleteByPrimaryKey(Integer idProfxasig);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int insert(Profesoresxasignaturas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int insertSelective(Profesoresxasignaturas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    List<Profesoresxasignaturas> selectByExample(ProfesoresxasignaturasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    Profesoresxasignaturas selectByPrimaryKey(Integer idProfxasig);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int updateByExampleSelective(@Param("record") Profesoresxasignaturas record, @Param("example") ProfesoresxasignaturasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int updateByExample(@Param("record") Profesoresxasignaturas record, @Param("example") ProfesoresxasignaturasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int updateByPrimaryKeySelective(Profesoresxasignaturas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table profesoresxasignaturas
     *
     * @mbg.generated Mon Dec 04 00:52:19 COT 2017
     */
    int updateByPrimaryKey(Profesoresxasignaturas record);
}