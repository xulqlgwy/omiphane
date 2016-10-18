package com.omiphane.utilities;

import com.omiphane.generator.model.DeviceReal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by xulq on 2015/10/20 0020.
 */
public class DeviceDataList {
    private List<DeviceReal> deviceRealList;

    public DeviceDataList(){
        deviceRealList = new ArrayList<DeviceReal>();
    }


    public List<DeviceReal> getDeviceRealList() {
        return deviceRealList;
    }

    public void setDeviceRealList(List<DeviceReal> deviceRealList) {
        this.deviceRealList = deviceRealList;
    }
}
