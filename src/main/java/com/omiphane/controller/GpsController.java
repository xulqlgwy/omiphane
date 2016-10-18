package com.omiphane.controller;

import com.omiphane.service.GpsService;
import com.omiphane.utilities.DeviceDataList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Administrator on 2016/10/8.
 */
@Controller
public class GpsController extends BaseController{
    @Autowired
    private DeviceDataList deviceDataList;

    @Autowired
    private GpsService gpsService;

    @RequestMapping("/gps")
    public
    @ResponseBody
    ModelAndView gpsView(ModelMap modelMap,HttpServletRequest request){
        return new ModelAndView(GPS_VIEW);
    }


    @RequestMapping("/initListView")
    public @ResponseBody
    Map<String, Object> initListView(HttpSession session) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            if (deviceDataList !=null && deviceDataList.getDeviceRealList().size() > 0){
                resultMap.put(MESSAGE, deviceDataList.getDeviceRealList());
            }else {
                gpsService.getDeviceBaseInfo();
            }

            return resultMap;
        }  catch (Exception e) {
            resultMap.put(ERROR, e.getMessage());
            return resultMap;
        }
    }

}



