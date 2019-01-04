package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.ApiServer;
import com.yitianli.myapplication.MyRetrofit;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailModel {

    public static void getMovieDetail(String id,MovieDetailContract.Presenter presenter){

        ApiServer apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);
        String url = "http://api.douban.com/v2/movie/subject/" + id;
        Map<String, String> map = new HashMap<>();
        map.put("apikey","0b2bdeda43b5688921839c8ecb20399b");
        map.put("city","上海");
        map.put("client","");
        map.put("udid","");
        apiServer.getMovieDetail(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDetailBean movieDetailBean) {
                        presenter.onSuccess(movieDetailBean);
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

    //获取一星到五星对应的前端显示图形长度的百分比
    public static float[] getStarNum(MovieDetailBean.RatingBean.DetailsBean bean){
        float[] floats = new float[5];
        float total = bean.get_$1() + bean.get_$2() + bean.get_$3() + bean.get_$4() + bean.get_$5();
        floats[0] = bean.get_$1() / total;
        floats[1] = bean.get_$2() / total;
        floats[2] = bean.get_$3() / total;
        floats[3] = bean.get_$4() / total;
        floats[4] = bean.get_$5() / total;
        return floats;
    }
}
