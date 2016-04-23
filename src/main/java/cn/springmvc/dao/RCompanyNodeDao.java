package cn.springmvc.dao;

import cn.springmvc.model.Company;
import cn.springmvc.model.RCompanyNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RCompanyNodeDao {

	public int insertRCompanyNode(RCompanyNode rCompanyNode);

	public RCompanyNode getRCompanyNodeById(@Param("id") Integer id);

	public int updateRCompanyNode(RCompanyNode rCompanyNode);

	public int deleteRCompanyNodeById(@Param("id") Integer id);

}
