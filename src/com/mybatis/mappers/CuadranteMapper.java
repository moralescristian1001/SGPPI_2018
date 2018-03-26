package com.mybatis.mappers;

import com.mybatis.models.Cuadrante;
import com.mybatis.models.CuadranteExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CuadranteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	long countByExample(CuadranteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int deleteByExample(CuadranteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int deleteByPrimaryKey(Integer idCuadrante);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int insert(Cuadrante record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int insertSelective(Cuadrante record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	List<Cuadrante> selectByExample(CuadranteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	Cuadrante selectByPrimaryKey(Integer idCuadrante);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int updateByExampleSelective(@Param("record") Cuadrante record, @Param("example") CuadranteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int updateByExample(@Param("record") Cuadrante record, @Param("example") CuadranteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int updateByPrimaryKeySelective(Cuadrante record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cuadrante
	 * @mbg.generated  Mon Mar 26 12:48:07 COT 2018
	 */
	int updateByPrimaryKey(Cuadrante record);

	List<Map<String, Object>> getRecords();
}