package com.wangenyong.dsfarm.module.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangenyong on 2017/1/3.
 */

@Module
public class ApplicationModule {
    private final Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
