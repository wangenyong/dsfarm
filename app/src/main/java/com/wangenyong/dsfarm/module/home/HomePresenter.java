package com.wangenyong.dsfarm.module.home;

import android.app.Activity;
import android.content.Intent;

import com.wangenyong.dsfarm.data.DataManager;
import com.wangenyong.dsfarm.data.model.CustomView;
import com.wangenyong.dsfarm.module.base.BasePresenter;
import com.wangenyong.dsfarm.module.customview.CustomViewActivity;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public HomePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void loadCustomViews() {
        mDataManager.getCustomViews()
                .subscribe(new Action1<List<CustomView>>() {
                    @Override
                    public void call(List<CustomView> customViews) {
                        getView().showCustomViews(customViews);
                    }
                });
    }

    @Override
    public void openCustomViewActivity(Activity activity, CustomView customView) {
        switch (customView.getType()) {
            case CustomView.WEBVIEW:
                break;
            default:
                Intent intent = CustomViewActivity.newIntent(activity, customView.getTitle());
                activity.startActivity(intent);
        }

    }
}
