package com.wangenyong.dsfarm.module.home;

import com.wangenyong.dsfarm.data.model.CustomView;
import com.wangenyong.dsfarm.module.base.BasePresenter;
import com.wangenyong.dsfarm.module.base.BaseView;

import java.util.List;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class HomeContract {
    interface View extends BaseView {
        void showCustomViews(List<CustomView> customViews);
    }

    interface Presenter extends BasePresenter<View> {
        void loadCustomViews();
    }
}
