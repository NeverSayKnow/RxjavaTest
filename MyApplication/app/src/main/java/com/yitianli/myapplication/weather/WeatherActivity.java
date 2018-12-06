package com.yitianli.myapplication.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;

public class WeatherActivity extends BaseActivity implements View.OnClickListener,WeatherContract.View {

    private TextView tv_weather;
    private EditText et_city;
    private Button btn_search;
    private WeatherNowPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();
    }

    private void init() {
        tv_weather = findViewById(R.id.tv_weather);
        et_city = findViewById(R.id.et_city);
        btn_search = findViewById(R.id.btn_search);
        presenter = new WeatherNowPresenter();
        presenter.attachView(this);
        btn_search.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:
                presenter.getNowWeather();
                break;
            default:
                break;
        }
    }

    @Override
    public void showData(WeatherBasicBean weatherBasicBean, WeatherUpdateBean weatherUpdateBean, WeatherNowBean weatherNowBean) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherBasicBean.getCnty()+"-"+weatherBasicBean.getAdmin_area()+"-"+weatherBasicBean.getParent_city()+"-"+weatherBasicBean.getLocation()+"\n");
        builder.append("更新时间：" + weatherUpdateBean.getLoc() + "\n");
        builder.append("温度：" + weatherNowBean.getTmp() + "\n");
        builder.append("体感温度：" + weatherNowBean.getFl() + "\n");
        builder.append("天气状况：" + weatherNowBean.getCond_txt() + "\n");
        builder.append("风力：" + weatherNowBean.getWind_sc() + "\n");
        builder.append("风速，公里/小时：" + weatherNowBean.getWind_spd() + "\n");
        builder.append("风向：" + weatherNowBean.getWind_dir() + "\n");
        builder.append("相对湿度：" + weatherNowBean.getHum());

        tv_weather.setText(builder.toString());
    }

    @Override
    public String getLocation() {
        return et_city.getText().toString().trim();
    }
}
