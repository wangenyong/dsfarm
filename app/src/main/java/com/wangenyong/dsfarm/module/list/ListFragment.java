package com.wangenyong.dsfarm.module.list;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.wangenyong.dsfarm.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout toolbarCollapsing;
    @BindView(R.id.recyclerview_list) RecyclerView recyclerView;
    @BindView(R.id.toolbar_list) Toolbar toolbar;

    private List<String> mData = new ArrayList<String>();

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        // TODO Auto-generated method stub
        super.onAttach(context);
        Logger.d("ListFragment onAttach");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData.add("A");
        mData.add("B");
        mData.add("C");
        mData.add("D");
        mData.add("E");
        mData.add("F");
        mData.add("G");
        mData.add("H");
        mData.add("I");
        mData.add("J");
        mData.add("K");
        mData.add("L");
        mData.add("M");
        mData.add("N");
        mData.add("O");
        mData.add("P");
        mData.add("Q");
        Logger.d("ListFragment onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        Logger.d("ListFragment onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Logger.d("ListFragment onActivityCreated");

        toolbarCollapsing.setTitle("List");
        toolbarCollapsing.setCollapsedTitleTextColor(Color.WHITE);
        toolbarCollapsing.setExpandedTitleColor(Color.TRANSPARENT);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<String>(getActivity(), R.layout.item_list, mData) {
            @Override
            protected void convert(ViewHolder holder, String text, int position) {
                holder.setText(R.id.textview_item_list, text);
            }
        });
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Logger.d("ListFragment onStart");

    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Logger.d("ListFragment onResume");

    }


    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Logger.d("ListFragment onPause");

    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Logger.d("ListFragment onStop");

    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        super.onDestroyView();
        Logger.d("ListFragment onDestroyView");

    }
}
