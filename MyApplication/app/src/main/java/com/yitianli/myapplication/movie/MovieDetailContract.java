package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.base.BaseCallback;
import com.yitianli.myapplication.base.BaseView;

public interface MovieDetailContract {

    interface View extends BaseView{

        void showData(MovieDetailBean bean);

        void showStarNum(float[] floats);

        void showStar(int[] ints);

    }

    interface Presenter extends BaseCallback<MovieDetailBean>{

        void getMovieDetail(String id);

        void getStarNum(MovieDetailBean.RatingBean.DetailsBean bean);

        void getStar(double score);

    }
}
