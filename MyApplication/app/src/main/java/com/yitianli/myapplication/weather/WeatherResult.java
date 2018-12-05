package com.yitianli.myapplication.weather;

public class WeatherResult {

    private String status;
    private WeatherBasicBean basic;
    private WeatherNowBean now;
    private WeatherUpdateBean update;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WeatherBasicBean getBasic() {
        return basic;
    }

    public void setBasic(WeatherBasicBean basic) {
        this.basic = basic;
    }

    public WeatherNowBean getNow() {
        return now;
    }

    public void setNow(WeatherNowBean now) {
        this.now = now;
    }

    public WeatherUpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(WeatherUpdateBean update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "status='" + status + '\'' +
                ", basic=" + basic +
                ", now=" + now +
                ", update=" + update +
                '}';
    }
}
