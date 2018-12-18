package com.yitianli.myapplication.movie;

import android.webkit.WebView;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;

import butterknife.BindView;

public class MovieWebActivity extends BaseActivity {

    @BindView(R.id.wv_movie)
    WebView wvMovie;

    @Override
    protected void initView() {
        wvMovie.loadUrl("https://movie.douban.com/subject/3878007/mobile");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_movie_web;
    }

    @Override
    protected String getTittleName() {
        return "电影";
    }
}
