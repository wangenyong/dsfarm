package com.wangenyong.dsfarm.module.base;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangenyong on 2017/1/3.
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideContext() {
        return mApplication;
    }
}
