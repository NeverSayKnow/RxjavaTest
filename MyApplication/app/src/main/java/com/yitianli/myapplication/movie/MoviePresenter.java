package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.base.BasePresenter;

import java.util.List;

public class MoviePresenter extends BasePresenter<MovieContract.View> implements MovieContract.Presenter {

    public void getMovie(){
        if (!isAttchedView()){
            return;
        }

        getView().showLoading();
        MovieModel.getMovie(this);
    }

    @Override
    public void onSuccess(List<MovieBean.SubjectsBean> data) {
        if (isAttchedView()){
            getView().showData(data);
        }

    }

    @Override
    public void onFailure(String msg) {
        if (isAttchedView()){
            getView().showToastMsg(msg);
        }
    }

    @Override
    public void onError() {
        if (isAttchedView()){
            getView().showError();
        }
    }

    @Override
    public void onComplete() {
        if (isAttchedView()){
            getView().hideLoading();
        }
    }
}
