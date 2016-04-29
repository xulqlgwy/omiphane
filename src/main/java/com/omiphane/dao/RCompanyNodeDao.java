package com.omiphane.dao;

import com.omiphane.model.RCompanyNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RCompanyNodeDao {

	public int insertRCompanyNode(RCompanyNode rCompanyNode);

	public RCompanyNode getRCompanyNodeById(@Param("id") Integer id);

	public int updateRCompanyNode(RCompanyNode rCompanyNode);

	public int deleteRCompanyNodeById(@Param("id") Integer id);

}
