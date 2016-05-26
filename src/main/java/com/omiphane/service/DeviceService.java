package com.omiphane.service;

import com.omiphane.model.Device;
import com.omiphane.model.DeviceRealData;
import com.omiphane.model.NodeGroup;
import com.omiphane.model.ReportQueryForm;

import java.nio.channels.SocketChannel;
import java.util.List;


public interface DeviceService {

	public List<DeviceRealData> getDeiceListByIds(String ids);

	public List<NodeGroup> getDeviceTree(String user);

	public List<DeviceRealData> getDeviceReportByQueryParam(ReportQueryForm reportQueryForm);

	public void sendCommand2Device(String cmdId,SocketChannel socketChannel,byte[] sendBytes);
}
