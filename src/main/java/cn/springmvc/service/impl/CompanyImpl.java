package cn.springmvc.service.impl;

import cn.springmvc.dao.CompanyDao;
import cn.springmvc.dao.DeviceDao;
import cn.springmvc.dao.NodeGroupDao;
import cn.springmvc.model.Company;
import cn.springmvc.model.Device;
import cn.springmvc.model.NodeGroup;
import cn.springmvc.service.CompanyService;
import cn.springmvc.service.NodeGroupService;
import cn.springmvc.utilities.PageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CompanyImpl implements CompanyService{
	@Autowired
	public DeviceDao deviceDao;

    @Autowired
	private CompanyDao companyDao;


	@Override
	public List<Object> getCatelogByCompanyId(Integer companyId, Integer type) {
		List<Object> objects = new ArrayList<Object>();
		Device device = new Device();
		device.setLeaf(false);
		device.setText("砂浆罐");
		device.setId(PageConstant.NODE_TANK + "-" + companyId);
		device.setChecked(false);
		objects.add(device);

		Device device2 = new Device();
		device2.setLeaf(false);
		device2.setText("车辆");
		device2.setId(PageConstant.NODE_BUS + "-" + companyId);
		device2.setChecked(false);
		objects.add(device2);
		return objects;
	}

	@Override
	public List<Object> getDeviceByCompanyId(Integer companyId, Integer type) {
		List<Object> objects = new ArrayList<Object>();
		List<Device> devices = deviceDao.getDeviceListByCompanyId(companyId,type);
		for (Device device : devices){
			device.setLeaf(true);
			device.setText(device.getNickName());
			device.setId(PageConstant.NODE_DEVICE + "-" + device.getDid());
			device.setChecked(false);
			objects.add(device);
		}

		return objects;
	}

	@Override
	public List<Company> getCompaniesByUserId(Integer id) {
		if (null == id){
			return null;
		}
		return companyDao.getCompaniesByUserId(id);
	}

	@Override
	public List<Device> getTankTypeByCompanyId(Integer companyId) {
		if (companyId == null){
			return null;
		}
		return deviceDao.getDeviceWithTankTypeByCompanyId(companyId);
	}
}
