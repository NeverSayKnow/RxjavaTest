package com.yitianli.myapplication.poem_mvp;

import com.yitianli.myapplication.Poem;
import com.yitianli.myapplication.base.BaseCallback;
import com.yitianli.myapplication.base.BasePresenter;

public class PoemPresenter extends BasePresenter<PoemContract.View> implements BaseCallback<PoemBean2> {

//    private PoemContract.View view;

    public void getPoem(){
        if (!isAttchedView()){
            return;
        }
        getView().showLoading();
        PoemModel.getPoem(this);
    }

    @Override
    public void onSuccess(PoemBean2 data) {
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

        getView().showError();
    }

    @Override
    public void onComplete() {
        getView().hideLoading();
    }
}
