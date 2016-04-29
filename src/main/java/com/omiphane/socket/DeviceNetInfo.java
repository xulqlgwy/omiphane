package com.omiphane.socket;

import com.omiphane.dao.DeviceDao;
import com.omiphane.dao.DeviceRealDataDao;
import com.omiphane.model.Device;
import com.omiphane.model.DeviceRealData;
import com.omiphane.service.NetProcessService;
import com.omiphane.utilities.DeviceDataMapping;
import com.omiphane.utilities.GpsAnalysis;
import com.omiphane.utilities.PageConstant;
import com.mysql.jdbc.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by Administrator on 2015/7/8 0008.
 */
@Service
@Transactional
public class DeviceNetInfo implements NetProcessService {
    private static final Logger logger = LoggerFactory.getLogger(DeviceNetInfo.class);
    @Autowired
    private DeviceRealDataDao deviceRealDataDao;

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private DeviceDataMapping deviceDataMapping;


    static int BLOCK = 1024;
    protected ByteBuffer clientBuffer = ByteBuffer.allocate(BLOCK);

    private CharsetDecoder decoder;
    static CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();

    public DeviceNetInfo(){
    }


    private boolean attachDevice(SocketChannel socketChannel){
        return  true ;
    }

    @Override
    public String processChanel(SocketChannel socketChannel) {
        int count = 0;
        String devKey = "";
        try {
            count = socketChannel.read(clientBuffer);
            if (count > 0) {
                clientBuffer.flip();
                byte[] bt = clientBuffer.array();
                devKey = processData(bt,count);

                clientBuffer.clear();

                if(!deviceDataMapping.getSocketMapping().containsKey(devKey)){
                    deviceDataMapping.getSocketMapping().put(devKey,socketChannel);
                }
//                SocketChannel socketChannel1 = deviceDataMapping.getSocketMapping().get(devKey);
//                ByteBuffer block = encoder.encode(CharBuffer.wrap("[" + socketChannel1.toString() + "] 发送数据:" + "answer"));
//                socketChannel1.write(block);
            } else {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devKey;
    }

    @Override
    public void processLogin(SocketChannel socketChannel) {

    }

    @Override
    public String processData(byte[] byteBuffer, Integer len) {
        GpsAnalysis gpsAnalysis = null;
        try{
            byte[] byteData= byteBuffer;
            gpsAnalysis = new GpsAnalysis(byteData,len);
            gpsAnalysis.doAnalysis();

            //展示收到的数据
            logger.debug(gpsAnalysis.toString());

            //更新实时数据
            processRealData(gpsAnalysis.getDeviceRealData());



        }catch (Exception e){
            e.printStackTrace();
        }

        if (null == gpsAnalysis.getDeviceRealData()){
            return "NO_DEVICE";
        }else {
            return gpsAnalysis.getDeviceRealData().getDevId();
        }
    }

    /**
     * 更新实时数据
     * @param deviceRealData
     */
    public void processRealData(DeviceRealData deviceRealData){
        //更新实时数据表
        Integer deviceId = deviceDao.getIdByDeviceId(deviceRealData.getDevId());
        Device device = deviceDao.getDeviceById(deviceId);
        deviceRealData.setDeviceId(deviceId);//设置终端对应数据库中的id

        //填充终端基本数据
        PageConstant.Device2Data.copy(device, deviceRealData, null);

        if (deviceRealDataDao.getDeviceDataCount(deviceId) > 0 ){
            deviceRealDataDao.updateDeviceRealData(deviceRealData);
        }else{
            deviceRealDataDao.insertRealData(deviceRealData);
        }
        //插入到历史表
        deviceRealDataDao.insert2Historey(deviceRealData);

        //更新缓存
        deviceDataMapping.getDeviceMapping().put(deviceRealData.getDevId(),deviceRealData);

    }

    private void processMessage(GpsAnalysis gpsAnalysis){
        if (PageConstant.MSG_01F1.equals(gpsAnalysis.getMsgId())){
            logger.warn("终端["+gpsAnalysis.getDeviceNumber()+"]开始注册");
            byte[] sendbuffer = new byte[BLOCK];
//            sendbuffer[0] = PageConstant.HEAD;
//            word a = 0xb1f1;
//            byte[] msgId = NetReverse.RUInt162Bytes(ServerMessageNo.S_ACK_REGISTER);
//            Array.Copy(msgId, 0, buffer, 1, 2);
//            UInt16 len = 16 ;
//            Array.Copy(NetReverse.RUInt162Bytes(len), 0, buffer, 3, 2);
//            Array.Copy(this.analyze.PhoneNumber, 0, buffer, 5, 6);
//            Array.Copy(NetReverse.RUInt162Bytes(this.analyze.SerialNumber),0, buffer,11, 2);
//            Array.Copy(this.analyze.MessageBody, 0, buffer, 13, 16);
//            int n = 29;
//            makeCheckNumber(ref buffer, ref n);
//            showData(buffer, n);
//            sendData(buffer, n);
        }
    }

    public void setDecoder(CharsetDecoder decoder) {
        this.decoder = decoder;
    }
}
