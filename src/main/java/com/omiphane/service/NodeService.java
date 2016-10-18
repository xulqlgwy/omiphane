package com.omiphane.service;

import com.omiphane.generator.model.Device;
import com.omiphane.generator.model.DeviceData;
import com.omiphane.generator.model.Node;
import com.omiphane.model.Company;
import com.omiphane.model.DeviceRealData;
import com.omiphane.model.NodeGroup;

import java.util.List;


public interface NodeService {

	public int insertNodeGroup(NodeGroup nodeGroup);

	public List<Node> getNodeListByNodeId(Integer nodeId);

	public List<Node> getChildrenNodeByParentId(Integer parentId);

	public List<Object> getNodeGroupListByUserId(Integer userId ,Integer id);

	public List<NodeGroup> getEntireTree(Integer userId,Integer id);

    public List<Company> getCompaniesByFilter(Integer id, String filter);

	public List<DeviceData>  getRealDataByNodeId(List<Integer> nodeIds);

//	public  List<Device> getDeviceList(List<Integer> nodeIds);



}
