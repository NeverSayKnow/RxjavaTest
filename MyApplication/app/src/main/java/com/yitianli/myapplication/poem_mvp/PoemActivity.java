package com.yitianli.myapplication.poem_mvp;

import android.widget.TextView;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class PoemActivity extends BaseActivity implements PoemContract.View {

    @BindView(R.id.poem_title)
    TextView poemTitle;
    @BindView(R.id.poem_authors)
    TextView poemAuthors;
    @BindView(R.id.poem_content)
    TextView poemContent;
    @BindView(R.id.poem_authors_introduce)
    TextView poemAuthorsIntroduce;
    private PoemPresenter presenter;

    protected void initView() {
        presenter = new PoemPresenter();
        presenter.attachView(this);

    }

    @OnClick(R.id.btn_random_poem) void getPoem(){
        presenter.getPoem();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_poem;
    }

    @Override
    protected String getTittleName() {
        return "唐诗宋词";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showData(PoemBean2 poem) {
        poemTitle.setText(poem.getBiaoti());
        poemAuthors.setText(poem.getZuozhe());
        poemContent.setText(poem.getNeirong());
        poemAuthorsIntroduce.setText(poem.getJieshao());
    }

}
