package com.wangenyong.dsfarm.module.base;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.wangenyong.dsfarm.data.DataManager;
import com.wangenyong.dsfarm.data.local.LocalDataHelper;
import com.wangenyong.dsfarm.data.remote.RetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by wangenyong on 2017/1/19.
 */

@Module
public class DataModule {

    String mBaseUrl;

    public DataModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    RetrofitService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }

    @Provides
    @Singleton
    LocalDataHelper provideLocalDataHelper() {
        return new LocalDataHelper();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(RetrofitService retrofitService, LocalDataHelper localDataHelper) {
        return new DataManager(retrofitService, localDataHelper);
    }
}
