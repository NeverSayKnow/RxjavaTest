package com.yitianli.myapplication.weather;

import java.util.List;

public class WeatherBaseData<T> {
    private List<T> HeWeather6;

    public List<T> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<T> heWeather6) {
        HeWeather6 = heWeather6;
    }

    @Override
    public String toString() {
        return "WeatherBaseData{" +
                "HeWeather6=" + HeWeather6 +
                '}';
    }
}
