package com.yitianli.myapplication.base;

import android.content.Context;


/**
 * MVP模式中V的基类，所有View都要继承BaseView
 */
public interface BaseView {

    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载中
     */
    void hideLoading();

    /**
     * 显示提示
     * @param msg msg
     */
    void showToastMsg(String msg);

    /**
     * 显示错误
     */
    void showError();

    /**
     * 获取上下文本
     * @return 当前上下文
     */
    Context getContext();

}
