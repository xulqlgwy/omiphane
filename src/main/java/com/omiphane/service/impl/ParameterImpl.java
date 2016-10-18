package com.omiphane.service.impl;

import com.omiphane.generator.dao.ColumnDefineMapper;
import com.omiphane.generator.model.ColumnDefine;
import com.omiphane.generator.model.ColumnDefineExample;
import com.omiphane.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by Administrator on 2016/8/19.
 */
@Service
public class ParameterImpl implements ParameterService{
    @Autowired
    private ColumnDefineMapper columnDefineMapper;


    @Override
    public List<ColumnDefine> getColumnDefineList() {
        ColumnDefineExample columnDefineExample = new ColumnDefineExample();
        return columnDefineMapper.selectByExample(columnDefineExample);
    }
}
