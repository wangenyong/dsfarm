package com.wangenyong.dsfarm.module.grid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangenyong.dsfarm.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GridFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridFragment extends Fragment {
    @BindView(R.id.recyclerview_grid) RecyclerView recyclerView;
    @BindView(R.id.toolbar_grid) Toolbar toolbar;

    private List<String> mData = new ArrayList<String>();

    public GridFragment() {
        // Required empty public constructor
    }

    public static GridFragment newInstance() {
        GridFragment fragment = new GridFragment();
        return fragment;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar.setTitle("Grid");
        toolbar.inflateMenu(R.menu.menu_grid);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);


        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setAdapter(new CommonAdapter<String>(getActivity(), R.layout.item_list, mData) {
            @Override
            protected void convert(ViewHolder holder, String text, int position) {
                holder.setText(R.id.textview_item_list, text);
            }
        });
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_android:
                    Toast.makeText(getActivity(), "Android", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_bug:
                    Toast.makeText(getActivity(), "Bug", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    };

}
