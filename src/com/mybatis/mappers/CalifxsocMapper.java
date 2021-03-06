package com.mybatis.mappers;

import com.mybatis.models.Califxsoc;
import com.mybatis.models.CalifxsocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CalifxsocMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	long countByExample(CalifxsocExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int deleteByExample(CalifxsocExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int deleteByPrimaryKey(Integer idCalifxsoc);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int insert(Califxsoc record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int insertSelective(Califxsoc record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	List<Califxsoc> selectByExample(CalifxsocExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	Califxsoc selectByPrimaryKey(Integer idCalifxsoc);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int updateByExampleSelective(@Param("record") Califxsoc record, @Param("example") CalifxsocExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int updateByExample(@Param("record") Califxsoc record, @Param("example") CalifxsocExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int updateByPrimaryKeySelective(Califxsoc record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table califxsoc
	 * @mbg.generated  Mon Jun 11 00:27:45 COT 2018
	 */
	int updateByPrimaryKey(Califxsoc record);

	/**
	 * getNextId
	 */
	int getNextId();
}