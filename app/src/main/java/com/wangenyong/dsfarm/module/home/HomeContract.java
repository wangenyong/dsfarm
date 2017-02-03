package com.wangenyong.dsfarm.module.home;

import android.app.Activity;

import com.wangenyong.dsfarm.data.model.CustomView;
import com.wangenyong.dsfarm.module.base.MvpPresenter;
import com.wangenyong.dsfarm.module.base.MvpView;

import java.util.List;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class HomeContract {
    interface View extends MvpView {
        void showCustomViews(List<CustomView> customViews);
    }

    interface Presenter extends MvpPresenter<View> {
        void loadCustomViews();
        void openCustomViewActivity(Activity activity, CustomView customView);
    }
}
