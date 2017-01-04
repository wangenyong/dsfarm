package com.wangenyong.dsfarm.module.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


/**
 * Created by wangenyong on 2016/12/30.
 */

public class DSFarmApplication extends Application {
    public final static String TAG = "DSFarmLoggerTag";

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init(TAG).methodCount(0).hideThreadInfo().logLevel(isApkInDebug(this) ? LogLevel.FULL : LogLevel.NONE);
    }

    public static DSFarmApplication get(Context context) {
        return (DSFarmApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
