package com.wangenyong.dsfarm.module.home;

import android.app.Activity;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.data.model.CustomView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangenyong on 2017/1/5.
 */

@Module
public class HomeModule {
    private final int mId;
    private final Activity mActivity;

    public HomeModule(Activity activity, int id) {
        mId = id;
        mActivity = activity;
    }

    @Provides
    List<CustomView> provideList() {
        return new ArrayList<CustomView>();
    }

    @Provides
    CommonAdapter<CustomView> provideCommonAdapter(List<CustomView> customViews) {
        return new CommonAdapter<CustomView>(mActivity, mId, customViews) {
            @Override
            protected void convert(ViewHolder holder, CustomView customView, int position) {
                holder.setText(R.id.textview_item_home, customView.getTitle());
            }
        };
    }
}
