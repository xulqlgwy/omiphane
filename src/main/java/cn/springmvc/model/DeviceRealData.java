package cn.springmvc.model;

/**
 * Created by xulq on 2015/5/17.
 */
public class DeviceRealData extends Device{
    private int rid;
    private int deviceId;
    private String gpsTime;
    private double latitude;
    private double longtitude;
    private double speed;
    private double angel;
    private double altitude;
    private String location;
    private double weight;
    private int version;
    private String ipcData;
    private int alarmData;
    private int status;


    public String toString(){
        String message = "" ;
        message += "deviceId:" + this.getDevId() + "\r\n";
        message += "nickName:" + this.getNickName() + "\r\n";
        message += "longtitude:" + this.getLongitude() + "\r\n";
        message += "latitude:" + this.getLatitude() + "\r\n";
        return message;
    }



    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longtitude;
    }

    public void setLongitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAngel() {
        return angel;
    }

    public void setAngel(double angel) {
        this.angel = angel;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getIpcData() {
        return ipcData;
    }

    public void setIpcData(String ipcData) {
        this.ipcData = ipcData;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getAlarmData() {
        return alarmData;
    }

    public void setAlarmData(int alarmData) {
        this.alarmData = alarmData;
    }
}
