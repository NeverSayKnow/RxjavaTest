package com.yitianli.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yitianli.myapplication.widget.LoadingView;

public class BaseActivity extends AppCompatActivity implements BaseView{

    private LoadingView loadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingView = new LoadingView(this);
    }

    @Override
    public void showLoading() {
        if (!loadingView.isShowing()){
            loadingView.show();
        }
    }

    @Override
    public void hideLoading() {
        if (loadingView.isShowing()){
            loadingView.dismiss();
        }
    }

    @Override
    public void showToastMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError() {
        showToastMsg("网络请求出现问题，请稍后再试...");
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
