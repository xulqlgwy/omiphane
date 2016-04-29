package com.omiphane.utilities;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据传递进来的model将request中的参数传递进去
 */
public class FillVoBlank {
    private Object modelObj;
    private HttpServletRequest request;

    public void initVoAndRequest(Object model, HttpServletRequest request){
        this.modelObj = model ;
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Object getModelObj() {
        return modelObj;
    }

    public void setModelObj(Object modelObj) {
        this.modelObj = modelObj;
    }
}
