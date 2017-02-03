package com.wangenyong.dsfarm.module.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.data.model.CustomView;
import com.wangenyong.dsfarm.module.base.DSFarmApplication;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements MultiItemTypeAdapter.OnItemClickListener, HomeContract.View {
    @BindView(R.id.recyclerview_home) RecyclerView recyclerView;
    @BindView(R.id.toolbar_home) Toolbar toolbar;

    @Inject
    HomePresenter presenter;
    @Inject
    HomeAdapter adapter;

    private LayoutInflater mInflater;



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
        DaggerHomeComponent.builder()
                .applicationComponent(DSFarmApplication.get(getActivity()).getComponent())
                .homeModule(new HomeModule(getActivity()))
                .build()
                .inject(this);
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
        presenter.attachView(this);

        toolbar.setTitle("Home");
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter.setOnItemClickListener(this);
        View headerView = mInflater.inflate(R.layout.item_home_header, null);
        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        headerAndFooterWrapper.addHeaderView(headerView);
        recyclerView.setAdapter(headerAndFooterWrapper);
        presenter.loadCustomViews();
    }

    @Override
    public void showCustomViews(List<CustomView> customViews) {
        adapter.clearData();
        adapter.addAllData(customViews);
        adapter.notifyDataSetChanged();
    }

    public void onItemClick(View view, RecyclerView.ViewHolder holder,  int position) {
        presenter.openCustomViewActivity(getActivity(), adapter.getDatas().get(position-1));
    }

    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder,  int position) {
        return false;
    }

    @Override
    public void onDetach() {
        presenter.detachView();
        super.onDetach();
    }
}
