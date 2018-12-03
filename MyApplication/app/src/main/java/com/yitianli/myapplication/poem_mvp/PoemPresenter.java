package com.yitianli.myapplication.poem_mvp;

import com.yitianli.myapplication.Poem;

public class PoemPresenter implements PoemContract.Presenter{

    private PoemContract.View view;

    public PoemPresenter(PoemContract.View view){
        this.view = view;
    }

    public void getPoem(){
        view.showLoading();
        PoemModel.getPoem(this);
    }

    @Override
    public void onSuccess(Poem poem) {
        view.showData(poem);
    }

    @Override
    public void onFailure(String msg) {
        view.showFailureMsg(msg);
    }

    @Override
    public void onError() {
        view.showErrorMsg();
    }

    @Override
    public void onComplete() {
        view.hideLoading();
    }
}
