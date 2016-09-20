package com.example.framework.mvp.base;

/**
 * Created by Administrator on 2016/6/12 0012.
 */
public interface IUiBaseView<T> {

    public void onSucceed(T object);

    public void onFailure(Throwable t);

//    public void onLoadingShow();
//
//    public void onLoadingHide();

//    public void onToast(String text);


}
