package com.mybatis.mappers;

import com.mybatis.models.Socializacion;
import com.mybatis.models.SocializacionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocializacionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    long countByExample(SocializacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int deleteByExample(SocializacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int deleteByPrimaryKey(Integer idSocializacion);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int insert(Socializacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int insertSelective(Socializacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    List<Socializacion> selectByExample(SocializacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    Socializacion selectByPrimaryKey(Integer idSocializacion);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int updateByExampleSelective(@Param("record") Socializacion record, @Param("example") SocializacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int updateByExample(@Param("record") Socializacion record, @Param("example") SocializacionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int updateByPrimaryKeySelective(Socializacion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table socializacion
     *
     * @mbg.generated Mon Mar 26 15:01:09 COT 2018
     */
    int updateByPrimaryKey(Socializacion record);
}