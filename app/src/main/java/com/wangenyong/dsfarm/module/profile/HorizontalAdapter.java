package com.wangenyong.dsfarm.module.profile;

import android.content.Context;

import com.wangenyong.dsfarm.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangenyong on 2017/2/14.
 */

public class HorizontalAdapter extends CommonAdapter<String> {
    public HorizontalAdapter(Context context) {
        super(context, R.layout.item_profile_two, new ArrayList<String>());
    }

    @Override
    protected void convert(ViewHolder holder, String title, int position) {
        holder.setText(R.id.textview_item_two_profile, title);
    }

    public void clearData() {
        mDatas.clear();
    }

    public void addAllData(List<String> lists) {
        mDatas.addAll(lists);
        notifyDataSetChanged();
    }
}
