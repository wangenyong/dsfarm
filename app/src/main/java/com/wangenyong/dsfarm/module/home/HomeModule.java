package com.wangenyong.dsfarm.module.home;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangenyong on 2017/1/5.
 */

@Module
public class HomeModule {
    private final Activity mActivity;

    public HomeModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    HomeAdapter provideCommonAdapter() {
        return new HomeAdapter(mActivity);
    }
}
