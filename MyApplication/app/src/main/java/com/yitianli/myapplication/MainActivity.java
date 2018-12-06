package com.yitianli.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.yitianli.myapplication.base.BaseActivity;
import com.yitianli.myapplication.poem_mvp.PoemActivity;
import com.yitianli.myapplication.weather.WeatherActivity;

import org.reactivestreams.Subscription;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_weather)
    Button btnWeather;
    @BindView(R.id.btn_flow)
    Button btnFlow;
    @BindView(R.id.btn_mvp_test)
    Button btnMvpTest;

    private ApiServer apiServer;
    private Subscription mSubscription;


    protected void initView() {
        apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTittleName() {
        return "Demo集合";
    }

    @OnClick({R.id.btn_weather, R.id.btn_flow, R.id.btn_mvp_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_weather:
                Intent wIntent = new Intent(this, WeatherActivity.class);
                startActivity(wIntent);
                break;
            case R.id.btn_flow:
//                Flowable.create(new FlowableOnSubscribe<String>() {
//                    @Override
//                    public void subscribe(FlowableEmitter<String> emitter) throws Exception {
//                        try {
//                            AssetManager manager = getResources().getAssets();
//                            InputStream inputStream = manager.open("test.txt");
//                            InputStreamReader reader = new InputStreamReader(inputStream);
//                            BufferedReader br = new BufferedReader(reader);
//
//                            String string;
//
//                            while ((string = br.readLine()) != null && !emitter.isCancelled()) {
//                                while (emitter.requested() == 0) {
//                                    if (emitter.isCancelled()) {
//                                        break;
//                                    }
//                                }
//                                emitter.onNext(string);
//                            }
//
//                            br.close();
//                            reader.close();
//                            inputStream.close();
//                            emitter.onComplete();
//                        } catch (Exception e) {
//                            emitter.onError(e);
//                        }
//                    }
//                }, BackpressureStrategy.ERROR)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<String>() {
//                            @Override
//                            public void onSubscribe(Subscription s) {
//                                mSubscription = s;
//                                s.request(1);
//                            }
//
//                            @Override
//                            public void onNext(String s) {
//                                System.out.println(s);
//                                try {
//                                    Thread.sleep(2000);
//                                    mSubscription.request(1);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//
//                            @Override
//                            public void onError(Throwable t) {
//                                System.out.println(t);
//                                Log.e("TAG", "" + t);
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });
                break;
            case R.id.btn_mvp_test:
                Intent intent = new Intent(this, PoemActivity.class);
                startActivity(intent);
                break;
        }
    }

}
