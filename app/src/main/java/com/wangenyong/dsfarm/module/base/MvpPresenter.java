package com.wangenyong.dsfarm.module.base;

/**
 * Created by wangenyong on 2017/1/3.
 */

public interface MvpPresenter<T extends MvpView> {
    void attachView(T mvpView);
    void detachView();
}
