package com.omiphane.generator.dao;

import com.omiphane.generator.model.enumDefine;
import com.omiphane.generator.model.enumDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface enumDefineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int countByExample(enumDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int deleteByExample(enumDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int insert(enumDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int insertSelective(enumDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    List<enumDefine> selectByExample(enumDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    enumDefine selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") enumDefine record, @Param("example") enumDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") enumDefine record, @Param("example") enumDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(enumDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enum_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(enumDefine record);
}