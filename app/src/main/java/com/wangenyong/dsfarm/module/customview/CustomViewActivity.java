package com.wangenyong.dsfarm.module.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.bean.PieData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomViewActivity extends AppCompatActivity {
    @BindView(R.id.pieView) PieView pieView;

    private ArrayList<PieData> pieDatas = new ArrayList<PieData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);

        pieDatas.add(new PieData("pie1", 4));
        pieDatas.add(new PieData("pie2", 3));
        pieDatas.add(new PieData("pie3", 6));
        pieDatas.add(new PieData("pie4", 10));
        pieDatas.add(new PieData("pie5", 2));

        pieView.setData(pieDatas);
    }
}
