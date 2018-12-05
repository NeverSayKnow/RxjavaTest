package com.yitianli.myapplication.weather;

import android.util.Log;

import com.yitianli.myapplication.ApiServer;
import com.yitianli.myapplication.MyRetrofit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherModel {

    public static void getNowWeather(String location, final WeatherContract.Presenter presenter){
        ApiServer apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);
        apiServer.getNowWeather("https://free-api.heweather.com/s6/weather/now",location,"1a31921eca7948d1bdf20be71210c4be")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherBaseData<WeatherResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherBaseData<WeatherResult> weatherResultWeatherBaseData) {
                        Log.e("TAG","onNext");
                        Log.e("TAG","========" + weatherResultWeatherBaseData.getHeWeather6().toString());
                        if (weatherResultWeatherBaseData.getHeWeather6().get(0).getStatus().equals("ok")){
                            presenter.onSuccess(weatherResultWeatherBaseData.getHeWeather6().get(0));
                        }else {
                            presenter.onFailure(weatherResultWeatherBaseData.getHeWeather6().get(0).getStatus());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","onError");
                        presenter.onError();

                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","onComplete");
                        presenter.onComplete();
                    }
                });
    }
}
