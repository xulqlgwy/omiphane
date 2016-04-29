package com.omiphane.dao;

import com.omiphane.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao {

	public int insertUser(User user);

	public List<User> getUserListByUserId(@Param("userGroupId") Integer userGroupId);

	public User getUserById(@Param("id")Integer id);

	public int updateUser(User User);

	public int deleteUserById(@Param("id")Integer id);

	public int deleteUserByUserId(@Param("userGroupId") Integer userGroupId);

}
