package com.yitianli.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.wang.avi.AVLoadingIndicatorView;
import com.yitianli.myapplication.R;

public class MyLoadingView extends Dialog implements View.OnClickListener {


    public MyLoadingView(Context context) {
        super(context, R.style.loading_dialog_style);
        onInit();
    }

    private void onInit() {
        View view = getLayoutInflater().inflate(R.layout.my_loading_view, null);
        view.setOnClickListener(this);
        setContentView(view);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }

    @Override
    public void show() {
        super.show();
    }


    @Override
    public void dismiss() {
        super.dismiss();
    }
}
