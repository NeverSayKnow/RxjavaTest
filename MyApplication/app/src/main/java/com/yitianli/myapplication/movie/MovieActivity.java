package com.yitianli.myapplication.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yitianli.myapplication.R;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_movie);
    }
}