package com.mybatis.mappers;

import com.mybatis.models.Rubrica;
import com.mybatis.models.RubricaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RubricaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	long countByExample(RubricaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int deleteByExample(RubricaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int deleteByPrimaryKey(Integer idRubrica);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int insert(Rubrica record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int insertSelective(Rubrica record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	List<Rubrica> selectByExample(RubricaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	Rubrica selectByPrimaryKey(Integer idRubrica);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int updateByExampleSelective(@Param("record") Rubrica record, @Param("example") RubricaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int updateByExample(@Param("record") Rubrica record, @Param("example") RubricaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int updateByPrimaryKeySelective(Rubrica record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table rubrica
	 * @mbg.generated  Sat Feb 16 11:11:26 COT 2019
	 */
	int updateByPrimaryKey(Rubrica record);

	int getLastVersion(Integer asignatura);
	
	int getNextId();
}