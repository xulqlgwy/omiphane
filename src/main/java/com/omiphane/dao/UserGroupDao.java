package com.omiphane.dao;

import com.omiphane.model.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupDao {

	public int insertUserGroup(UserGroup userGroup);

	public UserGroup getUserGroupById(@Param("id") Integer id);

	public int updateUserGroup(UserGroup userGroup);

	public int deleteUserGroupById(@Param("id") Integer id);
}
