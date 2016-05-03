package com.omiphane;

import com.omiphane.generator.dao.UserMapper;
import com.omiphane.generator.model.UserExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Administrator on 2016/4/30.
 */
public class TestDao {

    @Autowired
    private UserMapper userMapper;

    @Test
    public  void testDao(){
        int n = userMapper.countByExample(new UserExample());
    }
}
