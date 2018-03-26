package com.mybatis.mappers;

import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EquipoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	long countByExample(EquipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int deleteByExample(EquipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int deleteByPrimaryKey(Integer idEquipo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int insert(Equipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int insertSelective(Equipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	List<Equipo> selectByExample(EquipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	Equipo selectByPrimaryKey(Integer idEquipo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int updateByExampleSelective(@Param("record") Equipo record, @Param("example") EquipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int updateByExample(@Param("record") Equipo record, @Param("example") EquipoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int updateByPrimaryKeySelective(Equipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo
	 * @mbg.generated  Mon Dec 04 04:21:21 COT 2017
	 */
	int updateByPrimaryKey(Equipo record);
	
	  List<Map<String, Object>> getRecords();
}