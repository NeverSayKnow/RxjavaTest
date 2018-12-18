package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.base.BasePresenter;

public class MovieDetailPresenter extends BasePresenter<MovieDetailContract.View> implements MovieDetailContract.Presenter {



    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void getStarNum(MovieBean.SubjectsBean.RatingBean.DetailsBean bean) {
        getView().showStarNum(MovieModel.getStarNum(bean));
    }

    @Override
    public void getStar(double score) {
        getView().showStar(MovieModel.getStarCount_score(score));
    }

}
