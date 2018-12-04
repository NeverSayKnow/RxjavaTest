package com.yitianli.myapplication;

import com.yitianli.myapplication.poem_mvp.PoemBean2;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiServer {

    //随机获取诗词一首
    @GET("recommendPoetry")
    Call<HttpResult<Poem>> getPoem();

    //随机获取诗词一首
    @GET("recommendPoetry")
    Observable<HttpResult<Poem>> getPoem2();

    //阿凡达数据-唐诗宋词-随机获取一首
    // http://api.avatardata.cn/TangShiSongCi/Random?key=00998048045547868a3f7fb1aa427f43
//    @FormUrlEncoded
    @POST("TangShiSongCi/Random")
    Observable<AFanDaHttpResult<PoemBean2>> getPoemRandom(@Query("key") String key);

    //阿凡达数据-唐诗宋词-随机获取一首
    // http://api.avatardata.cn/TangShiSongCi/Random?key=00998048045547868a3f7fb1aa427f43
    @GET("TangShiSongCi/Random")
    Observable<AFanDaHttpResult<PoemBean2>> getPoemRandomGet(@Query("key") String key);

    //获取城市的天气 https://www.apiopen.top/weatherApi?city=成都
    @FormUrlEncoded
    @POST
    Observable<HttpResult2<WeatherData>> getWeather(@Url String url, @Field("city") String city);
}
