package com.wangenyong.dsfarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomBar) BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
}
