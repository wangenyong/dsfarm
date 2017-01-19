package com.wangenyong.dsfarm.data;

import com.wangenyong.dsfarm.data.local.LocalDataHelper;
import com.wangenyong.dsfarm.data.model.CustomView;
import com.wangenyong.dsfarm.data.remote.RetrofitService;

import java.util.List;

import rx.Observable;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class DataManager {
    private final RetrofitService mRetrofitService;
    private final LocalDataHelper mLocalDataHelper;

    public DataManager(RetrofitService retrofitService, LocalDataHelper localDataHelper) {
        this.mRetrofitService = retrofitService;
        this.mLocalDataHelper = localDataHelper;
    }

    public Observable<List<CustomView>> getCustomViews() {
        return mLocalDataHelper.newCustomViews();
    }
}
