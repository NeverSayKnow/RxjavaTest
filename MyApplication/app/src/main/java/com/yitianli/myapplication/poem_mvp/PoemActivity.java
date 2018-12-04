package com.yitianli.myapplication.poem_mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yitianli.myapplication.R;
import com.yitianli.myapplication.base.BaseActivity;

public class PoemActivity extends BaseActivity implements PoemContract.View{
    private TextView poem_title;
    private TextView poem_authors;
    private TextView poem_content;
    private TextView poem_authors_introduce;
    private PoemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);
        initView();
    }

    private void initView() {
        poem_title = findViewById(R.id.poem_title);
        poem_authors = findViewById(R.id.poem_authors);
        poem_content = findViewById(R.id.poem_content);
        poem_authors_introduce = findViewById(R.id.poem_authors_introduce);
        Button btn_random_poem = findViewById(R.id.btn_random_poem);
        presenter = new PoemPresenter();
        presenter.attachView(this);


        btn_random_poem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getPoem();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showData(PoemBean2 poem) {
        poem_title.setText(poem.getBiaoti());
        poem_authors.setText(poem.getZuozhe());
        poem_content.setText(poem.getNeirong());
        poem_authors_introduce.setText(poem.getJieshao());
    }

}
