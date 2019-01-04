package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.base.BasePresenter;

public class MovieDetailPresenter extends BasePresenter<MovieDetailContract.View> implements MovieDetailContract.Presenter {


    //发送网络请求，获取电影信息
    @Override
    public void getMovieDetail(String id) {
        if(!isAttchedView()){
            return;
        }
        getView().showLoading();
        MovieDetailModel.getMovieDetail(id,this);
    }

    //获取电影一星到五星各星的占比
    @Override
    public void getStarNum(MovieDetailBean.RatingBean.DetailsBean bean) {
        getView().showStarNum(MovieDetailModel.getStarNum(bean));
    }

    //用来展示评分对应星星的多少
    @Override
    public void getStar(double score) {
        getView().showStar(MovieModel.getStarCount_score(score));
    }

    @Override
    public void onSuccess(MovieDetailBean data) {
        if(!isAttchedView()){
            return;
        }
        getView().showData(data);
        getStar(data.getRating().getAverage());
        getStarNum(data.getRating().getDetails());

    }

    @Override
    public void onFailure(String msg) {
        if(!isAttchedView()){
            return;
        }
        getView().showToastMsg(msg);
    }

    @Override
    public void onError() {
        if(!isAttchedView()){
            return;
        }
        getView().showError();
    }

    @Override
    public void onComplete() {
        if(!isAttchedView()){
            return;
        }
        getView().hideLoading();
    }

}
