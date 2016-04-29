package com.omiphane.dao;

import com.omiphane.model.NodeGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeGroupDao {

	public int insertNodeGroup(NodeGroup nodeGroup);

	public List<NodeGroup> getNodeListByUserId(@Param("userGroupId") Integer userGroupId, @Param("id") Integer id);

	public NodeGroup getNodeById(@Param("id")Integer id);

	public int updateNodeGroup(NodeGroup nodeGroup);

	public int deleteNodeGroupById(@Param("id")Integer id);

	public int deleteNodeGroupByUserId(@Param("userGroupId") Integer userGroupId);

	public List<NodeGroup> getChildrenNodesById(@Param("parentId") Integer id ,@Param("userGroupId") Integer userGroupId);

}
