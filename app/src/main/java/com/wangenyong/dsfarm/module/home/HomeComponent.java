package com.wangenyong.dsfarm.module.home;

import com.wangenyong.dsfarm.module.base.ApplicationComponent;
import com.wangenyong.dsfarm.module.utils.FragmentScoped;

import dagger.Component;

/**
 * Created by wangenyong on 2017/1/4.
 */

@FragmentScoped
@Component(modules = HomeModule.class, dependencies = ApplicationComponent.class)
public interface HomeComponent {
    void inject(HomeFragment homeFragment);
}
