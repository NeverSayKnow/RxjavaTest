package com.yitianli.myapplication.weather;

import com.yitianli.myapplication.base.BaseCallback;
import com.yitianli.myapplication.base.BaseView;

public interface WeatherContract {

    interface View extends BaseView {
        //展示数据
        void showData( WeatherBasicBean weatherBasicBean,
                      WeatherUpdateBean weatherUpdateBean,
                       WeatherNowBean weatherNowBean);

        //获取用户输入要查询天气的城市
        String getLocation();
    }

    interface Presenter extends BaseCallback<WeatherResult> {

    }
}
