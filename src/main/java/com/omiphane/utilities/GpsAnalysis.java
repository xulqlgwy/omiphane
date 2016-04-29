package com.omiphane.utilities;

import com.omiphane.model.DeviceRealData;

import java.sql.Timestamp;


/**
 * Created by Administrator on 2015/10/13 0013.
 */
public class GpsAnalysis {
    private String msgId;
    /**
     * 消息体长度
     */
    private Integer msgLength;
    private String alarmInfo;
    private String status;
    private DeviceRealData deviceRealData;
    private byte[] buffer;
    private String deviceNumber;
    private String serialNumber;
    private byte[] msgBody;
    /**
     * 整个包长度
     */
    private Integer bufferLength;

    /**
     * 构造一个GPS数据解析器
     * @param buffer
     * @param length
     */
    public GpsAnalysis(byte[] buffer, Integer length){
        this.buffer = new byte[length];
        System.arraycopy(buffer,0,this.buffer,0,length);
        this.bufferLength = length;
    }

    /**
     * 执行解析
     */
    public void doAnalysis() throws Exception{
        if (buffer[0] != 0x7E){
            throw new Exception("数据头错误");
        }
        if (!isDataValid()){
            throw new Exception("校验码错误");
        }

        byte[] b2 = new byte[2];
        System.arraycopy(this.buffer,1,b2,0,2);

        this.msgId = XConverter.byteToHexString(this.buffer,2);

        this.msgId = PageConstant.bytesToHexString(b2);
        System.arraycopy(this.buffer,3,b2,0,2);

        byte[] b4 = new byte[4];
        b4[0] = 0;
        b4[1] = 0;
        b4[2] = b2[0];
        b4[3] = b2[1];
        this.msgLength = PageConstant.byte2Int(b4);

        byte[] d = new byte[6];
        System.arraycopy(this.buffer,5,d,0,6);
        this.deviceNumber = PageConstant.bytesToHexString(d);

        System.arraycopy(this.buffer,11,b2,0,2);
        this.serialNumber = PageConstant.bytesToHexString(b2);

        this.msgBody = new byte[this.msgLength];
        System.arraycopy(this.buffer,13,this.msgBody,0,this.msgLength);

        getGpsRealData(this.msgBody,this.msgLength);
    }

    /**
     * 解析GPS数据
     * @param data
     * @param len
     */
    private void getGpsRealData(byte[] data, int len){
        this.deviceRealData = new DeviceRealData();
        byte[] b4 = new byte[4];
        System.arraycopy(data,0,b4,0,4);
        this.deviceRealData.setAlarmData(PageConstant.byte2Int(b4));

        System.arraycopy(data,4,b4,0,4);
        this.deviceRealData.setStatus(PageConstant.byte2Int(b4));

        System.arraycopy(data,8,b4,0,4);
        this.deviceRealData.setLatitude(PageConstant.byte2Int(b4)/1000000.00);

        System.arraycopy(data,12,b4,0,4);
        this.deviceRealData.setLongitude(PageConstant.byte2Int(b4)/1000000.00);

        byte[] b2 = new byte[2];

        //清零
        PageConstant.bytesReset(b4,4);
        System.arraycopy(data,16,b2,0,2);
        System.arraycopy(b2,0,b4,2,2);
        this.deviceRealData.setAltitude(PageConstant.byte2Int(b4));

        //清零
        PageConstant.bytesReset(b4,4);
        System.arraycopy(data,18,b2,0,2);
        System.arraycopy(b2,0,b4,2,2);
        this.deviceRealData.setSpeed(PageConstant.byte2Int(b4));

        //清零
        PageConstant.bytesReset(b4,4);
        System.arraycopy(data,20,b2,0,2);
        System.arraycopy(b2,0,b4,2,2);
        double n = (PageConstant.byte2Int(b4) / 100.00);
        this.deviceRealData.setWeight(n);


        byte[] b6 = new byte[6];
        System.arraycopy(data,22,b6,0,6);


        Timestamp d = new Timestamp(System.currentTimeMillis());
        this.deviceRealData.setGpsTime(d.toString());//PageConstant.bytesToHexString(b6)

        this.deviceRealData.setDevId(this.deviceNumber);
    }

    /**
     * 验证校验码
     * @return
     */
    private boolean isDataValid()
    {
        byte ck = 0;
        for (int i = 0; i < this.bufferLength; i++ ){
            if (i == 0 ){
                ck = 0;
            }
            else if (i == this.bufferLength - 2){
                if (ck == this.buffer[i]){
                    return true;
                }else{
                    return false;
                }
            }else{
                ck = (byte)(ck ^ this.buffer[i]);
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("消息体ID = " + this.msgId).append("\r\n");
        string.append("消息体长度 = " + this.msgLength).append("\r\n");
        string.append("消息体内容 =" + PageConstant.bytesToHexString(this.buffer)).append("\r\n");
        string.append("内容解析:" + this.deviceRealData.toString()).append("\r\n");
        return string.toString();
    }

    public Integer getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(Integer msgLength) {
        this.msgLength = msgLength;
    }

    public String getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(String alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeviceRealData getDeviceRealData() {
        return deviceRealData;
    }

    public void setDeviceRealData(DeviceRealData deviceRealData) {
        this.deviceRealData = deviceRealData;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public Integer getBufferLength() {
        return bufferLength;
    }

    public void setBufferLength(Integer bufferLength) {
        this.bufferLength = bufferLength;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public byte[] getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(byte[] msgBody) {
        this.msgBody = msgBody;
    }
}
