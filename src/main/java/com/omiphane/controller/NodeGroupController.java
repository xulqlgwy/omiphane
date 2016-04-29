package com.omiphane.controller;

import com.omiphane.model.*;
import com.omiphane.service.CompanyService;
import com.omiphane.service.DeviceService;
import com.omiphane.service.NodeGroupService;
import com.omiphane.utilities.DeviceDataMapping;
import com.omiphane.utilities.PageConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xulq on 2015/3/19.
 */
@Controller
public class NodeGroupController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(NodeGroupController.class);
    @Autowired
    private NodeGroupService nodeGroupService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DeviceDataMapping deviceDataMapping;


//    @RequestMapping("/get/nodeGroupList")
//    public
//    @ResponseBody
//    ModelAndView showNodeGroupList(ModelMap modelMap,HttpServletRequest request){
//        String userId = request.getParameter("UserId");
//        List<NodeGroup> nodeGroups = nodeGroupService.getNodeGroupListByUserId(Integer.valueOf(userId));
//        modelMap.put("NODES",nodeGroups);
//        return new ModelAndView(ROOM_MANAGE);
//    }

    @RequestMapping("/")
    public
    @ResponseBody
    ModelAndView showHome(ModelMap modelMap,HttpServletRequest request){
        return new ModelAndView(AREA_MAIN_VIEW);
    }

    @RequestMapping("/get/deviceList")
    public
    @ResponseBody
    Map<String, Object> getDeviceList(ModelMap modelMap,HttpServletRequest request){
        String s = request.getParameter("extraParam");
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if(!StringUtils.isEmpty(s)){
            List<DeviceRealData> devices = deviceService.getDeiceListByIds(s);
            returnMap.put("devices",devices);
        }
        return  returnMap;
    }
    @RequestMapping("/get/deviceTree")
    public
    @ResponseBody
    Map<String, Object> getDeviceTree(ModelMap modelMap,HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String strId = request.getParameter("node");
        if (StringUtils.isEmpty(strId)){
            return null;
        }

        List<Object> nodeGroups = new ArrayList<Object>();
        if (strId.equals(PageConstant.ROOT_NODE)){
            nodeGroups = nodeGroupService.getNodeGroupListByUserId(1,Integer.valueOf(PageConstant.ROOT_NODE));
        }else {
            if (PageConstant.getNodeType(strId).equals(PageConstant.NODE_GROUP)){
                nodeGroups = nodeGroupService.getNodeGroupListByUserId(1,PageConstant.getNodeId(strId));
            }else if (PageConstant.getNodeType(strId).equals(PageConstant.NODE_COMPANY)){
                nodeGroups = companyService.getCatelogByCompanyId(PageConstant.getNodeId(strId),1);
            }else if (PageConstant.getNodeType(strId).equals(PageConstant.NODE_TANK)){
                nodeGroups = companyService.getDeviceByCompanyId(PageConstant.getNodeId(strId),1);
            }else if ( PageConstant.getNodeType(strId).equals(PageConstant.NODE_BUS)){
                nodeGroups = companyService.getDeviceByCompanyId(PageConstant.getNodeId(strId),2);
            }
        }
        returnMap.put("deviceTree", nodeGroups);
        logger.warn(deviceDataMapping.toString());
        return  returnMap;
    }
    /**
     *   暂时不用
     */
    @RequestMapping("/get/busTree")
    public
    @ResponseBody
    Map<String, Object> getBusTree(ModelMap modelMap,HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String strId = request.getParameter("node");

        List<Object> nodeGroups = new ArrayList<Object>();
        if (strId.equals(PageConstant.ROOT_NODE)){
            nodeGroups = nodeGroupService.getNodeGroupListByUserId(1,Integer.valueOf(PageConstant.ROOT_NODE));
        }else {
            if (PageConstant.getNodeType(strId).equals(PageConstant.NODE_GROUP)){
                nodeGroups = nodeGroupService.getNodeGroupListByUserId(1,PageConstant.getNodeId(strId));
            }else if (PageConstant.getNodeType(strId).equals(PageConstant.NODE_COMPANY)){
                nodeGroups = companyService.getDeviceByCompanyId(PageConstant.getNodeId(strId),2);
            }else if (PageConstant.getNodeType(strId).equals(PageConstant.NODE_DEVICE)){

            }
        }
        returnMap.put("busTree",nodeGroups);
        return  returnMap;
    }

    @RequestMapping("/get/EntireTree")
    public
    @ResponseBody
    Map<String, Object> getEntireTree(ModelMap modelMap,HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String s = request.getParameter("node");
        if (StringUtils.isEmpty(s)){
            return  null;
        }
        List<NodeGroup> nodeGroups = nodeGroupService.getEntireTree(1, Integer.valueOf(s));
        returnMap.put("entireTree",nodeGroups);
        return  returnMap;
    }

    /**
     * 获取实时数据
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/get/realData")
    public
    @ResponseBody
    Map<String, Object> getRealData(ModelMap modelMap,String selids , HttpServletRequest request){
        logger.warn("请求终端列表:" + selids);
        if (StringUtils.isEmpty(selids)){
            return  null;
        }
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<DeviceRealData> deviceRealDatas = new ArrayList<DeviceRealData>();

        String idArray[] = selids.split(",");
        for (int i = 0 ; i< idArray.length; i ++){
            if (!deviceDataMapping.getDeviceMapping().containsKey(idArray[i])){
                if ("null".equals(idArray[i])) continue;
                logger.warn(idArray[i] + ":当前无实时数据,返回最后一条数据,同时放到Map");
                deviceRealDatas.add(nodeGroupService.getRealDataByDevId(idArray[i]));
                deviceDataMapping.getDeviceMapping().put(idArray[i],nodeGroupService.getRealDataByDevId(idArray[i]));
            }else {
                deviceRealDatas.add((DeviceRealData)deviceDataMapping.getDeviceMapping().get(idArray[i]));
            }
        }

        returnMap.put("realDataList",deviceRealDatas);
        return  returnMap;
    }

    @RequestMapping("/get/company")
    public
    @ResponseBody
    Map<String, Object> getCompany(ModelMap modelMap, HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String query = request.getParameter("filter");

        List<Company> companies = companyService.getCompaniesByUserId(1);
        returnMap.put("companies",companies);
        return  returnMap;
    }

    /**
     * 根据company 获取 终端列表用于combo
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/get/comboDevice")
    public
    @ResponseBody
    Map<String, Object> getDevices(ModelMap modelMap, HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String companyId = request.getParameter("extraParam");
        if (StringUtils.isEmpty(companyId)){
            return null;
        }

        List<Object> devices = companyService.getDeviceByCompanyId(Integer.valueOf(companyId), 1);
        returnMap.put("devices",devices);
        return  returnMap;
    }

    /**
     * 根据company 获取 终端列表用于combo
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/get/tankType")
    public
    @ResponseBody
    Map<String, Object> getTankType(ModelMap modelMap, HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String companyId = request.getParameter("extraParam");
        if (StringUtils.isEmpty(companyId)){
            return null;
        }

        List<Device> devices = companyService.getTankTypeByCompanyId(Integer.valueOf(companyId));
        returnMap.put("devices",devices);
        return  returnMap;
    }

    @RequestMapping("/query/report")
    public
    @ResponseBody
    Map<String, Object> queryReport(ModelMap modelMap,ReportQueryForm r,HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        ReportQueryForm reportQueryForm = new ReportQueryForm();
        reportQueryForm.fillForm(request);
        List<DeviceRealData> deviceRealDatas = deviceService.getDeviceReportByQueryParam(reportQueryForm);
        returnMap.put("success","true");
        returnMap.put("deviceReportData",deviceRealDatas);
        return  returnMap;
    }

    @RequestMapping("/sendCmd")
    public
    @ResponseBody
    Map<String, Object> sendCmd(ModelMap modelMap,HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String msgId = request.getParameter("Cmd");
        String devId = request.getParameter("devId");
        String msg = request.getParameter("message");

        deviceService.sendCommand2Device(msgId,deviceDataMapping.getSocketMapping().get(devId),msg.getBytes());
        returnMap.put(MESSAGE,"Success");
        return  returnMap;
    }
}
