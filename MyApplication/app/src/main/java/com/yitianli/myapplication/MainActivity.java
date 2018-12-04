package com.yitianli.myapplication;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yitianli.myapplication.poem_mvp.PoemActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
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
    private Button btn_flap_map;
    private Button btn_zip;
    private Button btn_flow;
    private Button btn_mvp_test;
    private Subscription mSubscription;

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
        btn_flap_map = findViewById(R.id.btn_flap_map);
        btn_zip = findViewById(R.id.btn_zip);
        btn_flow = findViewById(R.id.btn_flow);
        btn_mvp_test = findViewById(R.id.btn_mvp_test);
        btn_random_poem.setOnClickListener(this);
        btn_random_poem_rx.setOnClickListener(this);
        btn_weather.setOnClickListener(this);
        btn_flap_map.setOnClickListener(this);
        btn_zip.setOnClickListener(this);
        btn_flow.setOnClickListener(this);
        btn_mvp_test.setOnClickListener(this);
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
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.e("TAG","-----" + throwable.toString());
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
            case R.id.btn_flap_map:
                apiServer.getPoem2()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<HttpResult<Poem>>() {
                            @Override
                            public void accept(HttpResult<Poem> poemHttpResult) throws Exception {
                                Log.e("TAG","------------------"+poemHttpResult.getResult().getTitle());
                                Log.e("TAG","==========" + Thread.currentThread().getName());

                            }
                        })
                        .observeOn(Schedulers.io())
                        .flatMap(new Function<HttpResult<Poem>, ObservableSource<HttpResult2<WeatherData>>>() {
                            @Override
                            public ObservableSource<HttpResult2<WeatherData>> apply(HttpResult<Poem> poemHttpResult) throws Exception {
                                Log.e("TAG","-------flapmap-----"+poemHttpResult.getResult().getAuthors());
                                Log.e("TAG","==========" + Thread.currentThread().getName());
                                if (poemHttpResult.getCode() == 200){
//                                    return Observable.error(new Throwable("出错了"));
                                    return Observable.empty();
                                }
                                return apiServer.getWeather("https://www.apiopen.top/weatherApi","濮阳");

                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<HttpResult2<WeatherData>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e("TAG","======onSubscribe");
                                Log.e("TAG","==========" + Thread.currentThread().getName());
                            }

                            @Override
                            public void onNext(HttpResult2<WeatherData> weatherDataHttpResult2) {
                                Log.e("TAG","======onNext");
                                Log.e("TAG","==========" + Thread.currentThread().getName());

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("TAG","======onError" + e.getMessage());
                                Log.e("TAG","==========" + Thread.currentThread().getName());

                            }

                            @Override
                            public void onComplete() {
                                Log.e("TAG","======onComplete");
                                Log.e("TAG","==========" + Thread.currentThread().getName());
                            }
                        });
                break;
            case R.id.btn_zip:
                /*Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        Log.e("TAG","------emitter 1");
                        emitter.onNext(1);
                        Log.e("TAG","------emitter 2");
                        emitter.onNext(2);
                        Log.e("TAG","------emitter 3");
                        emitter.onNext(3);
                        Log.e("TAG","------emitter 4");
                        emitter.onNext(4);
                        Log.e("TAG","------onComplete integer");
                        emitter.onComplete();

                    }
                }).subscribeOn(Schedulers.io());

                Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        Log.e("TAG","------emitter A");
                        emitter.onNext("A");
                        Log.e("TAG","------emitter B");
                        emitter.onNext("B");
                        Log.e("TAG","------emitter C");
                        emitter.onNext("C");
                        Log.e("TAG","------onComplete string");
                        emitter.onComplete();

                    }
                }).subscribeOn(Schedulers.io());

                Observable.zip(observable, observable1, new BiFunction<Integer, String, String>() {
                    @Override
                    public String apply(Integer integer, String s) throws Exception {
                        return integer + s;
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG","======onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("TAG","======onNext" + s);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","======onError");

                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","======onComplete");
                    }
                });*/
                Flowable.create(new FlowableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                        Log.e("TAG","first requested = " + emitter.requested());
//                        Log.e("TAG","======emitter1");
//                        emitter.onNext(1);
//                        Log.e("TAG","======emitter2");
//                        emitter.onNext(2);
//                        Log.e("TAG","======emitter3");
//                        emitter.onNext(3);
//                        Log.e("TAG","======onComplete");
//                        emitter.onComplete();
                        boolean flag;
                        for (int i = 0; ; i++) {
                            flag = false;
                            while (emitter.requested() == 0){
                                if (!flag){
                                    Log.e("TAG","Oh! no, I can't emit the value!");
                                    flag = true;
                                }
                            }
                            emitter.onNext(i);
                            Log.e("TAG","emit = " + i + " , requested" + emitter.requested());
                        }
                    }
                },BackpressureStrategy.ERROR)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Integer>() {
                            @Override
                            public void onSubscribe(Subscription s) {
//                                Log.e("TAG","onSubscribe");
                                s.request(12);
//                                Log.e("TAG","s.request");

                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e("TAG","onNext"+integer);
                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
            case R.id.btn_flow:

                Flowable.create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                        try {
                            AssetManager manager = getResources().getAssets();
                            InputStream inputStream = manager.open("test.txt");
                            InputStreamReader reader = new InputStreamReader(inputStream);
                            BufferedReader br = new BufferedReader(reader);

                            String string;

                            while ((string=br.readLine()) != null && !emitter.isCancelled()){
                                while (emitter.requested() == 0){
                                    if (emitter.isCancelled()){
                                        break;
                                    }
                                }
                                emitter.onNext(string);
                            }

                            br.close();
                            reader.close();
                            inputStream.close();
                            emitter.onComplete();
                        }catch (Exception e){
                            emitter.onError(e);
                        }
                    }
                },BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        mSubscription = s;
                        s.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                        try {
                            Thread.sleep(2000);
                            mSubscription.request(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println(t);
                        Log.e("TAG","" + t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case R.id.btn_mvp_test:
                Intent intent = new Intent(this,PoemActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
