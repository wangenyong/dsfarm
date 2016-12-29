package com.wangenyong.dsfarm.module;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangenyong.dsfarm.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommonFragment extends Fragment {
    private static final String ARG_PARAM = "text";

    @BindView(R.id.textView) TextView textView;

    // TODO: Rename and change types of parameters
    private String text;


    public CommonFragment() {
        // Required empty public constructor
    }

    public static CommonFragment newInstance(String text) {
        CommonFragment fragment = new CommonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        ButterKnife.bind(this, view);

        textView.setText(text);
        return view;
    }

}
