package com.yitianli.myapplication.base;

import android.view.View;

public class BasePresenter<V extends BaseView> {

    /**
     * 绑定的View
     */
    private V mvpView;

    /**
     * 绑定View，一般在初始化中调用
     * @param mvpView 绑定的view
     */
    public void attachView(V mvpView){
        this.mvpView = mvpView;
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView(){
        mvpView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     * @return True--绑定  False--没有绑定
     */
    public boolean isAttchedView(){
        return mvpView != null;
    }

    /**
     * 获取链接的view
     * @return
     */
    public V getView(){
        return mvpView;
    }
}
