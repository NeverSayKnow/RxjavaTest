package com.yitianli.myapplication.poem_mvp;

import android.util.Log;

import com.yitianli.myapplication.ApiServer;
import com.yitianli.myapplication.HttpResult;
import com.yitianli.myapplication.MyRetrofit;
import com.yitianli.myapplication.Poem;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PoemModel {


    public static void getPoem(final PoemContract.Presenter presenter){
        ApiServer apiServer = MyRetrofit.getInstance().getRetrofit().create(ApiServer.class);
        apiServer.getPoem2()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HttpResult<Poem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HttpResult<Poem> poemHttpResult) {
                        int code = poemHttpResult.getCode();
                        if (code == 200){ //成功，返回Poem对象
                            presenter.onSuccess(poemHttpResult.getResult());
                        }else { //失败，返回message
                            Log.e("TAG","======="+poemHttpResult.getMessage());
                            presenter.onFailure(poemHttpResult.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.onError();
                        Log.e("TAG",""+ e);
                        presenter.onComplete();
                    }

                    @Override
                    public void onComplete() {
                        presenter.onComplete();
                    }
                });
    }
}
