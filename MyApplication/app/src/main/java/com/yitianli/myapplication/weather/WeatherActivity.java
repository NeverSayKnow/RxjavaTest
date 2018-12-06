package com.yitianli.myapplication.weather;

import android.widget.EditText;
import android.widget.TextView;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WeatherActivity extends BaseActivity implements WeatherContract.View {

    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.et_city)
    EditText etCity;

    private WeatherNowPresenter presenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_weather;
    }

    @Override
    protected String getTittleName() {
        return "实况天气";
    }

    @Override
    protected void initView() {
        presenter = new WeatherNowPresenter();
        presenter.attachView(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @OnClick(R.id.btn_search) void onViewClicked(){
        presenter.getNowWeather();
    }


    @Override
    public void showData(WeatherBasicBean weatherBasicBean, WeatherUpdateBean weatherUpdateBean, WeatherNowBean weatherNowBean) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherBasicBean.getCnty() + "-" + weatherBasicBean.getAdmin_area() + "-" + weatherBasicBean.getParent_city() + "-" + weatherBasicBean.getLocation() + "\n");
        builder.append("更新时间：" + weatherUpdateBean.getLoc() + "\n");
        builder.append("温度：" + weatherNowBean.getTmp() + "\n");
        builder.append("体感温度：" + weatherNowBean.getFl() + "\n");
        builder.append("天气状况：" + weatherNowBean.getCond_txt() + "\n");
        builder.append("风力：" + weatherNowBean.getWind_sc() + "\n");
        builder.append("风速，公里/小时：" + weatherNowBean.getWind_spd() + "\n");
        builder.append("风向：" + weatherNowBean.getWind_dir() + "\n");
        builder.append("相对湿度：" + weatherNowBean.getHum());
        tvWeather.setText(builder.toString());
    }

    @Override
    public String getLocation() {
        return etCity.getText().toString().trim();
    }

}
