package cn.springmvc.dao;

import cn.springmvc.model.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupDao {

	public int insertUserGroup(UserGroup userGroup);

	public UserGroup getUserGroupById(@Param("id") Integer id);

	public int updateUserGroup(UserGroup userGroup);

	public int deleteUserGroupById(@Param("id") Integer id);
}
