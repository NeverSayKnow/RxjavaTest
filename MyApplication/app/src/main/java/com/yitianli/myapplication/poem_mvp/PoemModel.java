package com.yitianli.myapplication.poem_mvp;

import android.util.Log;

import com.yitianli.myapplication.AFanDaHttpResult;
import com.yitianli.myapplication.ApiServer;
import com.yitianli.myapplication.HttpResult;
import com.yitianli.myapplication.MyRetrofit;
import com.yitianli.myapplication.Poem;
import com.yitianli.myapplication.base.BaseCallback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PoemModel {


    public static void getPoem(final BaseCallback<PoemBean2> callback){
        ApiServer apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);

        apiServer.getPoemRandom("3f5462eb29c84035944c2f5a0cd811f0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AFanDaHttpResult<PoemBean2>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AFanDaHttpResult<PoemBean2> poemBean2AFanDaHttpResult) {

                        int code = poemBean2AFanDaHttpResult.getError_code();
                        if (code == 0){ //成功，返回Poem对象
                            callback.onSuccess(poemBean2AFanDaHttpResult.getResult());
                        }else { //失败，返回message
                            Log.e("TAG","======="+poemBean2AFanDaHttpResult.getReason());
                            callback.onFailure(poemBean2AFanDaHttpResult.getReason());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();
                        Log.e("TAG",""+ e);
                        callback.onComplete();
                    }

                    @Override
                    public void onComplete() {
                        callback.onComplete();
                    }
                });

    }
}
