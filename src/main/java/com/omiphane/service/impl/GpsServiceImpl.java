package com.omiphane.service.impl;

import com.omiphane.generator.dao.DeviceBaseMapper;
import com.omiphane.generator.model.DeviceBase;
import com.omiphane.generator.model.DeviceBaseExample;
import com.omiphane.generator.model.DeviceReal;
import com.omiphane.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by Administrator on 2016/10/19.
 */
public class GpsServiceImpl implements GpsService {

    @Autowired
    private DeviceBaseMapper deviceBaseMapper;

    @Override
    public List<DeviceReal> getDeviceBaseInfo() {

        DeviceBaseExample deviceBaseExample = new DeviceBaseExample();
        List<DeviceBase> deviceBases = deviceBaseMapper.selectByExample(deviceBaseExample);

        return null;
    }
}
