package com.mybatis.mappers;

import com.mybatis.models.Asesorias;
import com.mybatis.models.AsesoriasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AsesoriasMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	long countByExample(AsesoriasExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int deleteByExample(AsesoriasExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int deleteByPrimaryKey(Integer idAsesoria);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int insert(Asesorias record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int insertSelective(Asesorias record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	List<Asesorias> selectByExample(AsesoriasExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	Asesorias selectByPrimaryKey(Integer idAsesoria);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int updateByExampleSelective(@Param("record") Asesorias record, @Param("example") AsesoriasExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int updateByExample(@Param("record") Asesorias record, @Param("example") AsesoriasExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int updateByPrimaryKeySelective(Asesorias record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table asesorias
	 * @mbg.generated  Thu Sep 06 19:11:07 COT 2018
	 */
	int updateByPrimaryKey(Asesorias record);
}