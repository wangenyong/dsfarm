package com.wangenyong.dsfarm.module.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.data.model.ProfileOne;
import com.wangenyong.dsfarm.data.model.ProfileTwo;
import com.wangenyong.dsfarm.data.model.Type;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    @BindView(R.id.recyclerview_profile) RecyclerView recyclerView;
    @BindView(R.id.toolbar_profile) Toolbar toolbar;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar.setTitle("Profile");

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        final ProfileMultiAdapter adapter = new ProfileMultiAdapter(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);
        List<Type>  dataes = new ArrayList<Type>();
        dataes.add(new ProfileTwo("two"));
        dataes.add(new ProfileTwo("two"));
        dataes.add(new ProfileOne("one"));
        dataes.add(new ProfileTwo("two"));
        dataes.add(new ProfileTwo("two"));
        dataes.add(new ProfileTwo("two"));
        adapter.addAllData(dataes);
        recyclerView.setAdapter(adapter);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getDatas().get(position).getType() == Type.PROFILE_ONE) {
                    return 4;
                } else {
                    return 1;
                }
            }
        });
    }

}
