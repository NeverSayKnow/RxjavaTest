package com.yitianli.myapplication;

import java.util.List;

public class WeatherData {
    private WeatherBean yesterday;
    private String city;
    private String aqi;
    private List<WeatherBean> forecast;
    private String ganmao;
    private String wendu;

    public WeatherBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(WeatherBean yesterday) {
        this.yesterday = yesterday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public List<WeatherBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherBean> forecast) {
        this.forecast = forecast;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }
}
