package cn.springmvc.dao;

import cn.springmvc.model.Device;
import cn.springmvc.model.DeviceRealData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRealDataDao {

	public int insertRealData(DeviceRealData deviceRealData);

	public DeviceRealData getRealDataById(@Param("id") Integer id);

	public DeviceRealData getRealDataByDeviceId(@Param("devId") String devId);

	public List<DeviceRealData> getRealDataByDeviceIds(@Param("ids") List<Integer> ids);

	public int insert2Historey(DeviceRealData deviceRealData);

	public int getDeviceDataCount(@Param("deviceId") Integer deviceId);

	public int updateDeviceRealData(DeviceRealData deviceRealData);

	public List<DeviceRealData> getRealDataByTimeIntervalWithId(@Param("startTime") String startTime, @Param("endTime")String endTime,@Param("devId") String devId);

	public List<DeviceRealData> getRealDataByTimeIntervalWithTankType(@Param("startTime") String startTime, @Param("endTime")String endTime,@Param("tankType") String tankType);

	public List<DeviceRealData> getRealDataByTimeIntervalWithCompanyId(@Param("startTime") String startTime, @Param("endTime")String endTime,@Param("companyId") Integer companyId);

}
