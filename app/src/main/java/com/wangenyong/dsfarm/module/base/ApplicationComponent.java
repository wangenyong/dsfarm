package com.wangenyong.dsfarm.module.base;

import android.app.Application;

import com.wangenyong.dsfarm.data.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wangenyong on 2017/1/3.
 */

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {
    Application applicaton();
    DataManager dataManager();
}
