package com.wangenyong.dsfarm.module.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wangenyong.dsfarm.R;
import com.wangenyong.dsfarm.module.grid.GridFragment;
import com.wangenyong.dsfarm.module.home.HomeFragment;
import com.wangenyong.dsfarm.module.list.ListFragment;
import com.wangenyong.dsfarm.module.profile.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomBar) BottomBar bottomBar;

    private FragNavController fragNavController;

    //indices to fragments
    private final int TAB_HOME = FragNavController.TAB1;
    private final int TAB_LIST = FragNavController.TAB2;
    private final int TAB_GRID = FragNavController.TAB3;
    private final int TAB_PROFILE = FragNavController.TAB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Fragment> fragments = new ArrayList<>(4);

        fragments.add(HomeFragment.newInstance());
        fragments.add(ListFragment.newInstance());
        fragments.add(GridFragment.newInstance());
        fragments.add(ProfileFragment.newInstance());

        fragNavController = new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.contentContainer, fragments, TAB_HOME);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    fragNavController.switchTab(TAB_HOME);
                } else if (tabId == R.id.tab_list) {
                    fragNavController.switchTab(TAB_LIST);
                } else if (tabId == R.id.tab_grid) {
                    fragNavController.switchTab(TAB_GRID);
                } else if (tabId == R.id.tab_profile) {
                    fragNavController.switchTab(TAB_PROFILE);
                }
            }
        });
    }
}
