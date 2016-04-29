package com.omiphane.generator.dao;

import com.omiphane.generator.model.User;
import com.omiphane.generator.model.UserExample;
import java.util.List;

public interface UserDAO {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(User record);

    void insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}