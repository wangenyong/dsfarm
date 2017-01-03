package com.wangenyong.dsfarm.module.base;

/**
 * Created by wangenyong on 2017/1/3.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view );
    void detachView();
}
