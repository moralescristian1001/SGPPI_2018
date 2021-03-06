package com.mybatis.mappers;

import com.mybatis.models.Salonxequipo;
import com.mybatis.models.SalonxequipoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalonxequipoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	long countByExample(SalonxequipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int deleteByExample(SalonxequipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int deleteByPrimaryKey(Integer idSalonxequipo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int insert(Salonxequipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int insertSelective(Salonxequipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	List<Salonxequipo> selectByExample(SalonxequipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	Salonxequipo selectByPrimaryKey(Integer idSalonxequipo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int updateByExampleSelective(@Param("record") Salonxequipo record, @Param("example") SalonxequipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int updateByExample(@Param("record") Salonxequipo record, @Param("example") SalonxequipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int updateByPrimaryKeySelective(Salonxequipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table salonxequipo
	 * @mbg.generated  Sun Jun 10 23:20:10 COT 2018
	 */
	int updateByPrimaryKey(Salonxequipo record);
}