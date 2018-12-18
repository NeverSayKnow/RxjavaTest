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

    /**
     * 根据星星数两返回一个数组，用来表示需要显示的图片
     * @param stars 星星的数量，共计50,5颗代表一星
     * @return int[],内有5个数，分别代表显示什么图片，0-整星，1-半星，2-灰星
     */
    public static int[] getStarCount(String stars){
        int show[] = new int[5];
        int i = Integer.valueOf(stars)/5;
        int whole = i/2; //整星数量
        int half = 0;  //半星数量
        int hui = 0;  //灰色星数量
        if (i%2 == 0){
            hui = 5-whole;
        }else {
            half = 1;
            hui = 4 - whole;
        }

        int index = 0;
        for (int i1 = 0; i1 < whole; i1++) {
            show[index] = 0;
            index++;
        }

        if (half != 0){
            show[index] = 1;
            index += 1;
        }

        for (int i1 = 0; i1 < hui; i1++) {
            show[index] = 2;
            index++;
        }

        return show;
    }

    public static int[] getStarCount_score(double score){
        int i = (int) Math.round(score);
        int show[] = new int[5];
        int whole = i/2; //整星数量
        int half = 0;  //半星数量
        int hui = 0;  //灰色星数量
        if (i%2 == 0){
            hui = 5-whole;
        }else {
            half = 1;
            hui = 4 - whole;
        }

        int index = 0;
        for (int i1 = 0; i1 < whole; i1++) {
            show[index] = 0;
            index++;
        }

        if (half != 0){
            show[index] = 1;
            index += 1;
        }

        for (int i1 = 0; i1 < hui; i1++) {
            show[index] = 2;
            index++;
        }

        return show;
    }

    //获取一星到五星对应的前端显示图形长度的百分比
    public static float[] getStarNum(MovieBean.SubjectsBean.RatingBean.DetailsBean bean){
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
