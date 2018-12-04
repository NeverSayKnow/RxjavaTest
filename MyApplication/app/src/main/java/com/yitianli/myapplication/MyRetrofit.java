package com.yitianli.myapplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    private static MyRetrofit myRetrofit;
    private Retrofit retrofit;

    public MyRetrofit () {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(5,TimeUnit.SECONDS);
        builder.connectTimeout(5,TimeUnit.SECONDS);
        builder.writeTimeout(5,TimeUnit.SECONDS);

        if(BuildConfig.DEBUG){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.avatardata.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    //单例模式
    public static MyRetrofit getInstance(){
        if (myRetrofit == null){
            synchronized (MyRetrofit.class){
                if(myRetrofit == null){
                    myRetrofit = new MyRetrofit();
                }
            }
        }
        return myRetrofit;
    }
}
