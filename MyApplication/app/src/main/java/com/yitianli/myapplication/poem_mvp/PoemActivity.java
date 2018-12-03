package com.yitianli.myapplication.poem_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.yitianli.myapplication.Poem;
import com.yitianli.myapplication.R;

public class PoemActivity extends AppCompatActivity implements PoemContract.View{
    private TextView poem_title;
    private TextView poem_authors;
    private TextView poem_content;
    private Button btn_random_poem;
    private PoemPresenter presenter;
    private ProgressBar progressbar_poem;

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
        btn_random_poem = findViewById(R.id.btn_random_poem);
        progressbar_poem = findViewById(R.id.progressbar_poem);
        presenter = new PoemPresenter(this);

        btn_random_poem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getPoem();
            }
        });
    }

    @Override
    public void showLoading() {
        progressbar_poem.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        progressbar_poem.setVisibility(View.GONE);
    }

    @Override
    public void showData(Poem poem) {
        poem_title.setText(poem.getTitle());
        poem_authors.setText(poem.getAuthors());

        //对返回的诗词内容进行处理
        String s = poem.getContent();
        String[] ss = s.split("\\|");
        StringBuilder builder = new StringBuilder();
        for (String s1 : ss) {
            builder.append(s1);
            builder.append("\n");
        }
        poem_content.setText(builder.toString());
    }

    @Override
    public void showFailureMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(this,"网络请求数据出现问题，请稍后再试",Toast.LENGTH_LONG).show();
    }
}
