package com.wangenyong.dsfarm.data.local;

import com.wangenyong.dsfarm.data.model.CustomView;
import com.wangenyong.dsfarm.module.customview.CustomViewActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class LocalDataHelper {

    public Observable<List<CustomView>> newCustomViews() {
        List<CustomView> customViews = new ArrayList<CustomView>();
        customViews.add(new CustomView(CustomViewActivity.PIEVIEW));
        customViews.add(new CustomView(CustomViewActivity.LEVELVIEW));
        return Observable.just(customViews);
    }
}
