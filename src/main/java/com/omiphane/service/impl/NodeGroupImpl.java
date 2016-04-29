package com.omiphane.service.impl;

import com.omiphane.dao.CompanyDao;
import com.omiphane.dao.DeviceDao;
import com.omiphane.dao.DeviceRealDataDao;
import com.omiphane.dao.NodeGroupDao;
import com.omiphane.model.Company;
import com.omiphane.model.DeviceRealData;
import com.omiphane.model.NodeGroup;
import com.omiphane.service.NodeGroupService;
import com.omiphane.utilities.PageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class NodeGroupImpl implements NodeGroupService{

	@Autowired
	private NodeGroupDao nodeGroupDao;

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private DeviceDao deviceDao;

	@Autowired
	private DeviceRealDataDao deviceRealDataDao;
	
	@Override
	public int insertNodeGroup(NodeGroup nodeGroup) {
		// TODO Auto-generated method stub
		return nodeGroupDao.insertNodeGroup(nodeGroup);
	}

	@Override
	public List<Object> getNodeGroupListByUserId(Integer userId ,Integer id) {
		List<Object> objects = new ArrayList<Object>();
		List<NodeGroup> nodeGroups = nodeGroupDao.getChildrenNodesById(id, userId);
		if (nodeGroups.size() > 0) { //如果有子节点,则不包含company信息
			for (NodeGroup nodeGroup : nodeGroups) {
				nodeGroup.setId(PageConstant.NODE_GROUP + "-" + nodeGroup.getId());
				nodeGroup.setLeaf(false);
				objects.add(nodeGroup);
			}

		} else {
			List<Company> companies = companyDao.getCompanyListByNodeId(id);
			for (Company company : companies) {
				if (deviceDao.getDeviceCountByCompanyId(company.getCid()) > 0) {
					company.setLeaf(false);
				}else {
					company.setLeaf(true);
				}
				company.setId(PageConstant.NODE_COMPANY + "-" + company.getCid());
				company.setText(company.getName());
				company.setChecked(false);
				objects.add(company);
			}
		}
		return objects;
	}

	@Override
	public List<NodeGroup> getEntireTree(Integer userId, Integer id) {
		List<NodeGroup> nodes = nodeGroupDao.getChildrenNodesById(id, userId);
		if(nodes.size() > 0){
			for (NodeGroup node : nodes){
				node.setLeaf(false);
			}
		}else {
			List<Company> companies = companyDao.getCompanyListByNodeId(id);
			for (Company company : companies) {
				NodeGroup node = new NodeGroup();
				node.setId(PageConstant.NODE_COMPANY + "-" + company.getCid());
				node.setText(company.getName());
				node.setChecked(false);
				node.setId(company.getId());
				if (deviceDao.getDeviceCountByCompanyId(company.getCid()) > 0) {
					node.setLeaf(false);
				}
				nodes.add(node);
			}
		}
		return nodes;
	}

	@Override
	public List<Company> getCompaniesByFilter(Integer id, String filter) {
        if (null != id){
			List<Company> companies = new ArrayList<Company>();
			Company company = companyDao.getCompanyById(id);
			companies.add(company);
			return companies;
		}else {
			return companyDao.getCompanyListByFilter(filter);
		}
	}

	@Override
	public DeviceRealData getRealDataByDevId(String devId) {
		if (StringUtils.isEmpty(devId)){
			return null;
		}
		return deviceRealDataDao.getRealDataByDeviceId(devId);
	}
}
