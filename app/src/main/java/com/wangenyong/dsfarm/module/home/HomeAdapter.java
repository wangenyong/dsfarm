package com.wangenyong.dsfarm.module.home;

import android.content.Context;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.data.model.CustomView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangenyong on 2017/1/5.
 */

public class HomeAdapter extends CommonAdapter<CustomView> {

    public HomeAdapter(Context context) {
        super(context, R.layout.item_home, new ArrayList<CustomView>());
    }

    @Override
    protected void convert(ViewHolder holder, CustomView customView, int position) {
        holder.setText(R.id.textview_item_home, customView.getTitle());
    }

    public void clearData() {
        mDatas.clear();
    }

    public void addAllData(List<CustomView> customViews) {
        mDatas.addAll(customViews);
    }
}
