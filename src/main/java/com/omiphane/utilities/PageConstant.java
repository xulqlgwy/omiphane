package com.omiphane.utilities;

import com.omiphane.model.Device;
import com.omiphane.model.DeviceRealData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/3/19.
 */
public  class PageConstant {
    public static String NODE_GROUP = "node_group";
    public static String NODE_COMPANY = "node_company";
    public static String NODE_DEVICE = "node_device";
    public static String ROOT_NODE = "0";
    public static String NODE_TANK = "node_tank";
    public static String NODE_BUS = "node_bus";
    public static BeanCopier Device2Data = BeanCopier.create(Device.class,DeviceRealData.class,false);


    public static byte HEAD = 0x7e;
    public static String MSG_01F1 = "01F1";
    public static String MSG_01F2 = "01F2";
    public static String MSG_01F3 = "01F3";

    public static String MSG_81F1 = "81F1";
    public static String MSG_81F2 = "81F2";
    public static String MSG_81F3 = "81F3";



    public static int getNodeId(String node){
        String[] nodeInfo = node.split("-");
        return Integer.valueOf(nodeInfo[1]);
    }

    public static String getNodeType(String node){
        String[] nodeInfo = node.split("-");
        return nodeInfo[0];
    }




}
