package com.omiphane.generator.dao;

import com.omiphane.generator.model.DeviceNodeRel;
import com.omiphane.generator.model.DeviceNodeRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceNodeRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int countByExample(DeviceNodeRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int deleteByExample(DeviceNodeRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int insert(DeviceNodeRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int insertSelective(DeviceNodeRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    List<DeviceNodeRel> selectByExample(DeviceNodeRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    DeviceNodeRel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DeviceNodeRel record, @Param("example") DeviceNodeRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DeviceNodeRel record, @Param("example") DeviceNodeRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DeviceNodeRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_node_rel
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DeviceNodeRel record);
}