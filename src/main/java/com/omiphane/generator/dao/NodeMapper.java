package com.omiphane.generator.dao;

import com.omiphane.generator.model.Node;
import com.omiphane.generator.model.NodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int countByExample(NodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int deleteByExample(NodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int insert(Node record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int insertSelective(Node record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    List<Node> selectByExample(NodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    Node selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Node record, @Param("example") NodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Node record, @Param("example") NodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Node record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Node record);
}