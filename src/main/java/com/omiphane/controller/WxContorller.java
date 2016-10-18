package com.omiphane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 微信公众号
 * Created by xuliquan on 2016/9/18.
 */
@Controller
public class WxContorller extends BaseController {
    private static final String TOKEN = "xulq";


    @RequestMapping("/wx")
    public
    @ResponseBody
    String getDeviceList(ModelMap modelMap,HttpServletRequest request){
        Map<String, Object> returnMap = new HashMap<String, Object>();


        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");


        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);

        List<String> list = new ArrayList<String>();
        list.add(signature);
        list.add(timestamp);
        list.add(nonce);

        Collections.sort(list);

        String sha = null;
        try {
            sha = getSHA1(TOKEN,timestamp,nonce);
            System.out.println("sha:"+sha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (sha!=null && sha.equals(signature)){
            System.out.println("pass");
            return echostr;
        }else {
            System.out.println("failure");
        }

        return  null;
    }

    /**
     * 用SHA1算法生成安全签名
     * @param token 票据
     * @param timestamp 时间戳
     * @param nonce 随机字符串
     * @return 安全签名
     * @throws NoSuchAlgorithmException
     */
    public  String getSHA1(String token, String timestamp, String nonce) throws NoSuchAlgorithmException {
        String[] array = new String[] { token, timestamp, nonce };
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < 3; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        // SHA1签名生成
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.getBytes());
        byte[] digest = md.digest();

        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }
}
