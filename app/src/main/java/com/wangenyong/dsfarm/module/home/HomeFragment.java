package com.wangenyong.dsfarm.module.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.module.customview.CustomViewActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements MultiItemTypeAdapter.OnItemClickListener {
    @BindView(R.id.recyclerview_home) RecyclerView recyclerView;
    @BindView(R.id.toolbar_home) Toolbar toolbar;

    private LayoutInflater mInflater;

    private List<String> mData = new ArrayList<String>();

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData.add("Rocket");
        mData.add("Nets");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflater = inflater;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toolbar.setTitle("Home");

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        CommonAdapter<String> adapter = new CommonAdapter<String>(getActivity(), R.layout.item_home, mData) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.textview_item_home, s);
            }
        };

        adapter.setOnItemClickListener(this);
        View headerView = mInflater.inflate(R.layout.item_home_header, null);
        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        headerAndFooterWrapper.addHeaderView(headerView);
        recyclerView.setAdapter(headerAndFooterWrapper);
    }

    public void onItemClick(View view, RecyclerView.ViewHolder holder,  int position) {
        Intent intent = new Intent(getActivity(), CustomViewActivity.class);
        startActivity(intent);
    }

    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder,  int position) {
        return false;
    }
}
