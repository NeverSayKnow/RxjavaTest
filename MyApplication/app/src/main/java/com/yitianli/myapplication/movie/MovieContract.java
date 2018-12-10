package com.yitianli.myapplication.movie;

import com.yitianli.myapplication.base.BaseCallback;
import com.yitianli.myapplication.base.BaseView;

import java.util.List;

public interface MovieContract {

    interface View extends BaseView{

        void showData(List<MovieBean.SubjectsBean> list);
    }

    interface Presenter extends BaseCallback<List<MovieBean.SubjectsBean>> {

    }
}
