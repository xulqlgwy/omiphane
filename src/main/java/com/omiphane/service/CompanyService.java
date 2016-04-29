package com.omiphane.service;

import com.omiphane.model.Company;
import com.omiphane.model.Device;

import java.util.List;


public interface CompanyService {
	public List<Object> getCatelogByCompanyId(Integer companyId, Integer type);

	public List<Object> getDeviceByCompanyId(Integer companyId, Integer type);

	public List<Company> getCompaniesByUserId(Integer id);

	public List<Device> getTankTypeByCompanyId(Integer companyId);
}
