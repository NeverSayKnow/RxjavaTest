package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.base.BaseCallback;
import com.yitianli.myapplication.base.BaseView;

public interface MovieDetailContract {

    interface View extends BaseView{

        void showData(MovieBean.SubjectsBean bean);

        void showStarNum(float[] floats);

        void showStar(int[] ints);

    }

    interface Presenter extends BaseCallback{

        void getStarNum(MovieBean.SubjectsBean.RatingBean.DetailsBean bean);

        void getStar(double score);

    }
}
