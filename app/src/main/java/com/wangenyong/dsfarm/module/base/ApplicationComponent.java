package com.wangenyong.dsfarm.module.base;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wangenyong on 2017/1/3.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}
