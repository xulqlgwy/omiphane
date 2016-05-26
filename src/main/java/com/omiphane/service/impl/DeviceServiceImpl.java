package com.omiphane.service.impl;

import com.omiphane.dao.DeviceDao;
import com.omiphane.dao.DeviceRealDataDao;
import com.omiphane.generator.dao.DeviceMapper;
import com.omiphane.model.DeviceRealData;
import com.omiphane.model.NodeGroup;
import com.omiphane.model.ReportQueryForm;
import com.omiphane.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceDao deviceDao;

	@Autowired
	private DeviceRealDataDao deviceRealDataDao;

	@Autowired
	private DeviceMapper deviceMapper;


	@Override
	public List<DeviceRealData> getDeiceListByIds(String ids) {

		return  null;
	}

	@Override
	public List<NodeGroup> getDeviceTree(String user) {

		return null;
	}

	/**
	 * 根据查询条件返回查询结果
	 * @param reportQueryForm
	 * @return
	 */
	@Override
	public List<DeviceRealData> getDeviceReportByQueryParam(ReportQueryForm reportQueryForm) {
		List<DeviceRealData> deviceRealDatas  = new ArrayList<DeviceRealData>();
 		if (!StringUtils.isEmpty(reportQueryForm.getDevId())){
			deviceRealDatas= deviceRealDataDao.getRealDataByTimeIntervalWithId(
					reportQueryForm.getStartTime(),reportQueryForm.getEndTime(),reportQueryForm.getDevId());
		}else if(!StringUtils.isEmpty(reportQueryForm.getTankType())){
			deviceRealDatas = deviceRealDataDao.getRealDataByTimeIntervalWithTankType(
					reportQueryForm.getStartTime(),reportQueryForm.getEndTime(),reportQueryForm.getTankType());
		}else if (!StringUtils.isEmpty(reportQueryForm.getCompanyId())){
			deviceRealDatas = deviceRealDataDao.getRealDataByTimeIntervalWithCompanyId(
					reportQueryForm.getStartTime(),reportQueryForm.getEndTime(),reportQueryForm.getCompanyId());
		}
		Map<String,DeviceRealData> deviceMap = new HashMap<String, DeviceRealData>();
		for (int i = 0 ; i< deviceRealDatas.size() ; i++){
			if (deviceMap.containsKey(deviceRealDatas.get(i).getDevId())) {
				DeviceRealData r = deviceMap.get(deviceRealDatas.get(i).getDevId());
				//如果当前重量比上一次的重，则视为加料
				if (deviceRealDatas.get(i).getWeight() > deviceRealDatas.get(i-1).getWeight()){
					r.setWeight(r.getWeight() + deviceRealDatas.get(i).getWeight());
				}
			}else {
				deviceMap.put(deviceRealDatas.get(i).getDevId(),deviceRealDatas.get(i));
			}
		}

		//将计算后的结果放到列表
		deviceRealDatas.clear();
		for (Map.Entry<String,DeviceRealData> entry : deviceMap.entrySet()){
			deviceRealDatas.add(entry.getValue());
		}
		return deviceRealDatas;
	}

	@Override
	public void sendCommand2Device(String cmdId, SocketChannel socketChannel, byte[] sendBytes) {
		if (socketChannel == null){
			return;
		}
		ByteBuffer byteBuffer = ByteBuffer.wrap(sendBytes);
		try {
			socketChannel.write(byteBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
