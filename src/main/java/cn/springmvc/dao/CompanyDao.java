package cn.springmvc.dao;

import cn.springmvc.model.Company;
import cn.springmvc.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao {

	public List<Company> getCompanyListByNodeId(@Param("nodeId") Integer nodeId);

	public List<Company> getCompanyListByFilter(@Param("filter") String filter);

	public Company getCompanyById(@Param("id") Integer id);

	public List<Company> getCompaniesByUserId(@Param("userId") Integer userId);
}
