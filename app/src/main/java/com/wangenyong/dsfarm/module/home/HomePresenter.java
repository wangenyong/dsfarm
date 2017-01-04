package com.wangenyong.dsfarm.module.home;

import com.wangenyong.dsfarm.data.DataManager;
import com.wangenyong.dsfarm.data.model.CustomView;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class HomePresenter implements HomeContract.Presenter {
    HomeContract.View homeView;
    private DataManager dataManager;

    public HomePresenter() {
        dataManager = new DataManager();
    }

    @Override
    public void attachView(HomeContract.View view) {
        homeView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void loadCustomViews() {
        dataManager.getCustomViews()
                .subscribe(new Action1<List<CustomView>>() {
                    @Override
                    public void call(List<CustomView> customViews) {
                        homeView.showCustomViews(customViews);
                    }
                });
    }
}
