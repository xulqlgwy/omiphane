package cn.springmvc.model;

/**
 * 用户表
 * @author xulq
 * 2014年2月11日
 */
public class RCompanyNode {

	private int id;
	private int companyId;
	private String nodeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
}
