package com.omiphane.model;

import javax.servlet.http.HttpServletRequest;

/**
 * 报表查询类
 * @author xulq
 * 2014年2月11日
 */
public class ReportQueryForm {

	private Integer companyId;

	private String devId;

	private String tankType;

	private String startTime;

	private String endTime;

	public void fillForm(HttpServletRequest request){
		this.companyId = Integer.valueOf(request.getParameter("companyId"));
		this.devId = request.getParameter("devId");
		this.tankType = request.getParameter("tankType");
		this.startTime = request.getParameter("startTime");
		this.endTime = request.getParameter("endTime");
	}


	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getTankType() {
		return tankType;
	}

	public void setTankType(String tankType) {
		this.tankType = tankType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
