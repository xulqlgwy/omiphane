package cn.springmvc.service;

import cn.springmvc.model.Company;
import cn.springmvc.model.DeviceRealData;
import cn.springmvc.model.NodeGroup;

import java.util.List;


public interface NodeGroupService {

	public int insertNodeGroup(NodeGroup nodeGroup);

	public List<Object> getNodeGroupListByUserId(Integer userId ,Integer id);

	public List<NodeGroup> getEntireTree(Integer userId,Integer id);

    public List<Company> getCompaniesByFilter(Integer id, String filter);

	public DeviceRealData getRealDataByDevId(String devId);



}
