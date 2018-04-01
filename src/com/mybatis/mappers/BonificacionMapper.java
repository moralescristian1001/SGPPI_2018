package com.mybatis.mappers;

import com.mybatis.models.Bonificacion;
import com.mybatis.models.BonificacionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonificacionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    long countByExample(BonificacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int deleteByExample(BonificacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int deleteByPrimaryKey(Integer idBonificacion);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int insert(Bonificacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int insertSelective(Bonificacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    List<Bonificacion> selectByExample(BonificacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    Bonificacion selectByPrimaryKey(Integer idBonificacion);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int updateByExampleSelective(@Param("record") Bonificacion record, @Param("example") BonificacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int updateByExample(@Param("record") Bonificacion record, @Param("example") BonificacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int updateByPrimaryKeySelective(Bonificacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bonificacion
     *
     * @mbg.generated Mon Mar 26 14:46:04 COT 2018
     */
    int updateByPrimaryKey(Bonificacion record);
}