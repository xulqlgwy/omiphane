package com.omiphane.service.impl;

import com.omiphane.generator.dao.DeviceBaseMapper;
import com.omiphane.generator.dao.DeviceRealMapper;
import com.omiphane.generator.model.*;
import com.omiphane.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2016/10/19.
 */
@Service
public class GpsServiceImpl implements GpsService {

    @Autowired
    private DeviceBaseMapper deviceBaseMapper;

    @Autowired
    private DeviceRealMapper deviceRealMapper;

    private BeanCopier beanCopier = BeanCopier.create(DeviceBase.class,DeviceReal.class,false);

    @Override
    public List<DeviceReal> getDeviceBaseInfo() {

        DeviceBaseExample deviceBaseExample = new DeviceBaseExample();
        List<DeviceBase> deviceBases = deviceBaseMapper.selectByExample(deviceBaseExample);

        List<DeviceReal> deviceRealList = new ArrayList<DeviceReal>();
        for (DeviceBase deviceBase : deviceBases){
            DeviceReal deviceReal = null;
            DeviceRealExample deviceRealExample = new DeviceRealExample();
            DeviceRealExample.Criteria criteria = deviceRealExample.createCriteria();
            criteria.andDeviceIdEqualTo(deviceBase.getDeviceId());
            List<DeviceReal> deviceReals =  deviceRealMapper.selectByExample(deviceRealExample);
            if (deviceReals != null && deviceReals.size() > 0){
                deviceReal = deviceReals.get(0);
            }else {
                deviceReal = new DeviceReal();
            }

            beanCopier.copy(deviceBase,deviceReal,null);
            deviceRealList.add(deviceReal);
        }

        return deviceRealList;
    }
}
