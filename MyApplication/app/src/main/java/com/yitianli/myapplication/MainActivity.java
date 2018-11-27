package com.yitianli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ApiServer apiServer;
    private TextView poem_title;
    private TextView poem_content;
    private TextView poem_authors;
    private Button btn_random_poem;
    private Button btn_random_poem_rx;
    private Button btn_weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);

    }

    private void initView() {
        poem_title = findViewById(R.id.poem_title);
        poem_authors = findViewById(R.id.poem_authors);
        poem_content = findViewById(R.id.poem_content);
        btn_random_poem = findViewById(R.id.btn_random_poem);
        btn_random_poem_rx = findViewById(R.id.btn_random_poem_rx);
        btn_weather = findViewById(R.id.btn_weather);
        btn_random_poem.setOnClickListener(this);
        btn_random_poem_rx.setOnClickListener(this);
        btn_weather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //正常的retrofit
            case R.id.btn_random_poem:
                Call<HttpResult<Poem>> httpResultCall = apiServer.getPoem();

                //异步请求
                httpResultCall.enqueue(new Callback<HttpResult<Poem>>() {
                    @Override
                    public void onResponse(Call<HttpResult<Poem>> call, Response<HttpResult<Poem>> response) {
                        Log.e("TAG", "=========" + response.body().getResult().getTitle());
                        Log.e("TAG", "=========" + response.body().getResult().getAuthors());
                        Log.e("TAG", "=========" + response.body().getResult().getContent());
                        poem_title.setText(response.body().getResult().getTitle());
                        poem_authors.setText(response.body().getResult().getAuthors());
                        String s = response.body().getResult().getContent();
                        String[] ss = s.split("\\|");
                        StringBuilder builder = new StringBuilder();

                        for (String s1 : ss) {
                            builder.append(s1);
                            builder.append("\n");
                        }
                        poem_content.setText(builder.toString());
                    }

                    @Override
                    public void onFailure(Call<HttpResult<Poem>> call, Throwable t) {

                    }
                });
                break;
            //retrofit结合Rxjava2的网络请求
            case R.id.btn_random_poem_rx:

                apiServer.getPoem2()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<HttpResult<Poem>>() {
                            @Override
                            public void accept(HttpResult<Poem> poemHttpResult) throws Exception {
                                poem_title.setText(poemHttpResult.getResult().getTitle());
                                poem_authors.setText(poemHttpResult.getResult().getAuthors());
                                String s = poemHttpResult.getResult().getContent();
                                String[] ss = s.split("\\|");
                                StringBuilder builder = new StringBuilder();

                                for (String s1 : ss) {
                                    builder.append(s1);
                                    builder.append("\n");
                                }
                                poem_content.setText(builder.toString());
                            }
                        });
                break;
            case R.id.btn_weather:
                apiServer.getWeather("https://www.apiopen.top/weatherApi","上海")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<HttpResult2<WeatherData>>() {
                            @Override
                            public void accept(HttpResult2<WeatherData> weatherDataHttpResult2) throws Exception {
                                Log.e("TAG","=====" + weatherDataHttpResult2.getMsg());
                                Log.e("TAG","=====" + weatherDataHttpResult2.getData().getCity());
                                List<WeatherBean> list = weatherDataHttpResult2.getData().getForecast();
                                for (WeatherBean bean: list){
                                    Log.e("TAG", bean.getDate()+"/"+bean.getFengli()+"/"+bean.getFengxiang()
                                            +"/"+bean.getHigh()+"/"+bean.getLow()+"/"+bean.getType());
                                }

                            }
                        });
                break;
            default:
                break;
        }
    }

}
