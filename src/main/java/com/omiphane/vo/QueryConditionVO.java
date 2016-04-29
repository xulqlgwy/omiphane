/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.omiphane.vo;


import org.springframework.format.annotation.NumberFormat;

/**
 * 查询条件
 * @author xulq
 * @version v 0.1 2014/7/1 17:14 Exp $$
 */
public class QueryConditionVO {

    /**
     * 节点Id
     */
    private String nodeId;
    /**
     * 节点类型
     */
    private String nodeType;
    /**
     * 是否安装
     */
    private String isInstalled;
    /**
     * 是否已付钱
     */
    @NumberFormat
    private String isPayed;
    /**
     * 起租日期
     */
    private String startTime;
    /**
     * 结束日期
     */
    private String endTime;

    /**
     * 起始值
     */
    private String startValue;
    /**
     * 结束值
     */
    private String endValue;

    /**
     * 参数类型,区域管理与空调管理公用此参数,
     */
    private String paramType;

    /**
     * 空调品牌
     */
    private String airBranch;

    /**
     * 空调单价
     */
    private String airPrice;

    /**
     * 功率
     */
    private String airPower;

    /**
     * 序列号
     */
    private String airSN;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getIsInstalled() {
        return isInstalled;
    }

    public void setIsInstalled(String isInstalled) {
        this.isInstalled = isInstalled;
    }

    public String getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(String isPayed) {
        this.isPayed = isPayed;
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

    public String getStartValue() {
        return startValue;
    }

    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    public String getEndValue() {
        return endValue;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getAirBranch() {
        return airBranch;
    }

    public void setAirBranch(String airBranch) {
        this.airBranch = airBranch;
    }

    public String getAirPrice() {
        return airPrice;
    }

    public void setAirPrice(String airPrice) {
        this.airPrice = airPrice;
    }

    public String getAirPower() {
        return airPower;
    }

    public void setAirPower(String airPower) {
        this.airPower = airPower;
    }

    public String getAirSN() {
        return airSN;
    }

    public void setAirSN(String airSN) {
        this.airSN = airSN;
    }
}
