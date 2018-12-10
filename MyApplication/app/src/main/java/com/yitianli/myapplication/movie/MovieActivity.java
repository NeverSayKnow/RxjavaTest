package com.yitianli.myapplication.movie;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MovieActivity extends BaseActivity implements MovieContract.View{

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;

    private MovieAdapter movieAdapter;
    private MoviePresenter moviePresenter;
    private List<MovieBean.SubjectsBean> list;

    @Override
    protected void initView() {
        list = new ArrayList<>();
        movieAdapter = new MovieAdapter(this,list);
        GridLayoutManager manager = new GridLayoutManager(MovieActivity.this, 3);
        rvMovie.setLayoutManager(manager);
        rvMovie.addItemDecoration(new MyMovieItemDecoration(this,10));
        rvMovie.setAdapter(movieAdapter);
        moviePresenter = new MoviePresenter();
        moviePresenter.attachView(this);
        moviePresenter.getMovie();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_movie;
    }

    @Override
    protected String getTittleName() {
        return "热映电影";
    }

    @Override
    public void showData(List<MovieBean.SubjectsBean> list) {
        this.list = list;
        movieAdapter.setList(list);
        movieAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviePresenter.detachView();
    }
}
