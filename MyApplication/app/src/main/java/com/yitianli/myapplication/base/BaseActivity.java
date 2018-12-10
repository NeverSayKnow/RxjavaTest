package com.yitianli.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.widget.MyLoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    @BindView(R.id.tv_name_tittle)
    TextView tvNameTittle;
//    private LoadingView loadingView;
    private MyLoadingView loadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadingView = new LoadingView(this);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        tvNameTittle.setText(getTittleName());
        loadingView = new MyLoadingView(this);
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutResource();

    protected abstract String getTittleName();


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
