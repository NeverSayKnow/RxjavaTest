package com.yitianli.myapplication.poem_mvp;

import com.yitianli.myapplication.Poem;

public interface PoemContract {

    interface View {
        //显示加载中
        void showLoading();

        void hideLoading();

        void showData(Poem poem);

        void showFailureMsg(String msg);

        void showErrorMsg();
    }

    interface Presenter {

        void onSuccess(Poem poem);

        void onFailure(String msg);

        void onError();

        void onComplete();
    }
}
