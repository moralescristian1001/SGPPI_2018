package com.mybatis.mappers;

import com.mybatis.models.Seguimiento;
import com.mybatis.models.SeguimientoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeguimientoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    long countByExample(SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int deleteByExample(SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int deleteByPrimaryKey(Integer idSeguimiento);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int insert(Seguimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int insertSelective(Seguimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    List<Seguimiento> selectByExampleWithBLOBs(SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    List<Seguimiento> selectByExample(SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    Seguimiento selectByPrimaryKey(Integer idSeguimiento);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int updateByExampleSelective(@Param("record") Seguimiento record, @Param("example") SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Seguimiento record, @Param("example") SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int updateByExample(@Param("record") Seguimiento record, @Param("example") SeguimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int updateByPrimaryKeySelective(Seguimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int updateByPrimaryKeyWithBLOBs(Seguimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seguimiento
     *
     * @mbg.generated Mon Mar 26 15:00:09 COT 2018
     */
    int updateByPrimaryKey(Seguimiento record);
}