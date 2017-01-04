package com.wangenyong.dsfarm.data;

import com.wangenyong.dsfarm.data.local.FakeDataHelper;
import com.wangenyong.dsfarm.data.model.CustomView;

import java.util.List;

import rx.Observable;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class DataManager {

    public DataManager() {
    }

    public Observable<List<CustomView>> getCustomViews() {
        return FakeDataHelper.newCustomViews();
    }
}
