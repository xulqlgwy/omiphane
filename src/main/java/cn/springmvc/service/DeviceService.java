package cn.springmvc.service;

import cn.springmvc.model.Device;
import cn.springmvc.model.DeviceRealData;
import cn.springmvc.model.NodeGroup;
import cn.springmvc.model.ReportQueryForm;

import java.nio.channels.SocketChannel;
import java.util.List;


public interface DeviceService {

	public List<Device> getDeviceList();

	public List<DeviceRealData> getDeiceListByIds(String ids);

	public List<NodeGroup> getDeviceTree(String user);

	public List<DeviceRealData> getDeviceReportByQueryParam(ReportQueryForm reportQueryForm);

	public void sendCommand2Device(String cmdId,SocketChannel socketChannel,byte[] sendBytes);
}
