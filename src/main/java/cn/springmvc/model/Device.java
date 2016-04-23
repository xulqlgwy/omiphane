package cn.springmvc.model;

/**
 * 用户表
 * @author xulq
 * 2014年2月11日
 */
public class Device extends NodeGroup{

	private int did;
	private int type;
	private String devId;
	private String nickName;
	private String sn;
	private String product;
	private String model;
	private String creationDate;
	private int companyId;
	private String simCardNum;
	/**
	 * 已使用的时间
	 */
	private int dateCost;
	private int lastModifiedDate;
	private double keyValue;
	private int threshold;
	private String tankType;
	private String remark;



	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}



	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getSimCardNum() {
		return simCardNum;
	}

	public void setSimCardNum(String simCardNum) {
		this.simCardNum = simCardNum;
	}

	public int getDateCost() {
		return dateCost;
	}

	public void setDateCost(int dateCost) {
		this.dateCost = dateCost;
	}

	public int getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(int lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public double getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(double keyValue) {
		this.keyValue = keyValue;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getTankType() {
		return tankType;
	}

	public void setTankType(String tankType) {
		this.tankType = tankType;
	}
}
