package com.yitianli.myapplication.weather;

import com.yitianli.myapplication.base.BasePresenter;

public class WeatherNowPresenter extends BasePresenter<WeatherContract.View> implements WeatherContract.Presenter{


    public void getNowWeather(){
        if (!isAttchedView()){
            return;
        }
        getView().showLoading();
        WeatherModel.getNowWeather(getView().getLocation(),this);
    }

    @Override
    public void onSuccess(WeatherResult data) {
        if (isAttchedView()){
            getView().showData(data.getBasic(),data.getUpdate(),data.getNow());
        }
    }

    @Override
    public void onFailure(String msg) {
        if (isAttchedView()){
            getView().showToastMsg(msg);
        }

    }

    @Override
    public void onError() {
        if (isAttchedView()){
            getView().showError();
            getView().hideLoading();
        }
    }

    @Override
    public void onComplete() {
        if (isAttchedView()){
            getView().hideLoading();
        }

    }
}
