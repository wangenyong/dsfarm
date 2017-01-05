package com.wangenyong.dsfarm.module.profile;

import android.content.Context;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.data.model.ProfileOne;
import com.wangenyong.dsfarm.data.model.ProfileTwo;
import com.wangenyong.dsfarm.data.model.Type;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

/**
 * Created by wangenyong on 2017/1/5.
 */

public class ProfileMultiAdapter extends MultiItemTypeAdapter<Type> {

    public ProfileMultiAdapter(Context context) {
        super(context, new ArrayList<Type>());
        addItemViewDelegate(new OneDelegate());
        addItemViewDelegate(new TwoDelegate());
    }

    public class OneDelegate implements ItemViewDelegate<Type> {
        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_profile_one;
        }

        @Override
        public boolean isForViewType(Type item, int position) {
            return item.getType() == Type.PROFILE_ONE;
        }

        @Override
        public void convert(ViewHolder holder, Type item, int position) {
            holder.setText(R.id.textview_item_one_profile, ((ProfileOne)item).getTitle());
        }
    }

    public class TwoDelegate implements ItemViewDelegate<Type> {
        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_profile_two;
        }

        @Override
        public boolean isForViewType(Type item, int position) {
            return item.getType() == Type.PROFILE_TWO;
        }

        @Override
        public void convert(ViewHolder holder, Type item, int position) {
            holder.setText(R.id.textview_item_two_profile, ((ProfileTwo)item).getTitle());
        }
    }
}
