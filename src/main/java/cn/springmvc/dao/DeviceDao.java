package cn.springmvc.dao;

import cn.springmvc.model.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceDao {

	public int insertDevice(Device device);

	public Device getDeviceById(@Param("id") Integer id);

	public List<Device> getDeviceListByCompanyId(@Param("companyId") Integer companyId, @Param("type") Integer type);

	public int updateDevice(Device device);

	public int deleteDeviceById(@Param("id") Integer id);

	public int deleteDeviceByCompanyId(@Param("companyId") Integer companyId);

	public int getDeviceCountByCompanyId(@Param("companyId") Integer companyId);

	public List<Device> getDeviceListByIds(@Param("ids") List<Integer> ids);

	/**
	 * 根据终端号获取终端在数据库的id
	 * @param devId
	 * @return
	 */
	public int getIdByDeviceId(@Param("devId") String devId);

	public List<Device> getDeviceWithTankTypeByCompanyId(@Param("companyId") Integer companyId);
}
