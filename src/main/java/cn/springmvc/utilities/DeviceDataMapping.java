package cn.springmvc.utilities;

import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xulq on 2015/10/20 0020.
 */
public class DeviceDataMapping {
    private Map<String,Object> deviceMapping;
    private Map<String,SocketChannel> socketMapping;


    public DeviceDataMapping(){
        System.out.println("创建终端数据映射");
        deviceMapping = new HashMap<String, Object>();
        socketMapping = new HashMap<String, SocketChannel>();
    }

    public String toString(){
        return  "当前实时上传终端个数:" + deviceMapping.size() + "终端连接数:"+ socketMapping.size();
    }


    public Map<String, Object> getDeviceMapping() {
        return deviceMapping;
    }

    public void setDeviceMapping(Map<String, Object> deviceMapping) {
        this.deviceMapping = deviceMapping;
    }

    public Map<String, SocketChannel> getSocketMapping() {
        return socketMapping;
    }

    public void setSocketMapping(Map<String, SocketChannel> socketMapping) {
        this.socketMapping = socketMapping;
    }
}
