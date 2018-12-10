package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.ApiServer;
import com.yitianli.myapplication.MyRetrofit;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieModel {

    public static void getMovie(MovieContract.Presenter presenter){
        /**
         * apikey：固定值0b2bdeda43b5688921839c8ecb20399b
         * city：所在城市，例如北京、上海等
         * start：表示从第几条数据开始获取，包含本条
         * count：表示要获取几条数据
         * client：客户端信息。可为空
         * udid：用户 id。可为空
         */
        ApiServer apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);
        //创建请求热映电影接口所需参数
        Map<String,String> map = new HashMap();
        map.put("apikey","0b2bdeda43b5688921839c8ecb20399b");
        map.put("city","上海");
        map.put("start","0");
        map.put("count","9");
        map.put("client","");
        map.put("udid","");

        apiServer.getMovie("https://api.douban.com/v2/movie/in_theaters",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        if (null != movieBean){
                            presenter.onSuccess(movieBean.getSubjects());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.onError();
                        presenter.onComplete();
                    }

                    @Override
                    public void onComplete() {
                        presenter.onComplete();
                    }
                });
    }
}
