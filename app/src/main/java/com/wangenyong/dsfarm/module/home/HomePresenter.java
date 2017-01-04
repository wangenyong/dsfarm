package com.wangenyong.dsfarm.module.home;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class HomePresenter implements HomeContract.Presenter {
    HomeContract.View homeView;

    @Override
    public void attachView(HomeContract.View view) {
        homeView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void loadCustomViews() {

    }
}
