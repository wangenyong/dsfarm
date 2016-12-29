package com.wangenyong.dsfarm.module.customview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.bean.PieData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomViewActivity extends AppCompatActivity {
    private final static String KEY_CUSTOMVIEW = "com.dsfarm.customview.key";
    public static String PIEVIEW = "PieView";

    @BindView(R.id.toolbar_custom_view) Toolbar toolbar;
    @BindView(R.id.framelayout_custom_view) FrameLayout frameLayout;

    private ArrayList<PieData> pieDatas = new ArrayList<PieData>();

    public static Intent newIntent(Context context, String type) {
        Intent intent = new Intent(context, CustomViewActivity.class);
        intent.putExtra(KEY_CUSTOMVIEW, type);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String type = getIntent().getStringExtra(KEY_CUSTOMVIEW);

        if (type.equals(PIEVIEW)) {
            showPieView();
        }
    }

    private void showPieView() {
        View view = getLayoutInflater().inflate(R.layout.custom_pieview, null);

        frameLayout.addView(view);

        PieView pieView = (PieView)view.findViewById(R.id.pieView);

        pieDatas.add(new PieData("pie1", 4));
        pieDatas.add(new PieData("pie2", 3));
        pieDatas.add(new PieData("pie3", 6));
        pieDatas.add(new PieData("pie4", 5));
        pieDatas.add(new PieData("pie5", 2));

        pieView.setData(pieDatas);
    }
}
