/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.omiphane.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


/**
 * @author xulq
 * @version v 0.1 2014/4/26 14:58 Exp $$
 */
public class BaseController {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseController.class);

    /**
     * 默认页大小：20
     */
    protected static final int PAGE_SIZE = 20;

    /**
     * 默认页面提示语key
     */
    protected static final String MESSAGE = "message";

    /**
     * 默认页面提示语key
     */
    protected static final String ERROR = "error";

    /**
     * 默认页面提示语key
     */
    protected static final String ERROR_PAGE = "error";

    /**
     * 客户区主页面
     */
    public final static String HOME = "/index";

    public final static String AREA_MAIN_VIEW = "/airmanage/air_main_table";

    public final static String ROOM_LIST = "/airmanage/room_list";

    public final static String AREA_MANAGE = "/airmanage/area_manage";

    public final static String PARK_MANAGE = "/airmanage/park_manage";

    public final static String BUILDING_MANAGE = "/airmanage/building_manage";

    public final static String FLOOR_MANAGE = "/airmanage/floor_manage";

    public final static String ROOM_MANAGE = "/airmanage/room_manage";

    public final static String AIR_MANAGE = "/airmanage/air_condition_manage";

    public final static String AIR_FORM = "/airmanage/air_condition_form";

    public final static String BINDING_AIR = "/airmanage/air_select";

    public final static String CHART_VIEW = "/airmanage/charts";



    /**
     * 解析validate校验的结果,把错误信息进行封装
     *
     * @param result
     * @return
     */
    protected String getError(BindingResult result) {
        if (result == null || result.getErrorCount() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError : result.getAllErrors()) {
            sb.append(objectError.getDefaultMessage()).append("<br/>");
        }
        return sb.toString();
    }
}
