package com.carlisle.seed.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlisle.framework.BaseActivity;
import com.carlisle.framework.FragmentAdapter;
import com.carlisle.seed.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator      : carlisle
 * Date         : 29/08/2017
 * Description  :
 */

public class MainActivity extends BaseActivity {

    private static final int[] TAB_ICONS = {R.drawable.selector_first, R.drawable.selector_second};
    private static final String[] TAB_TITLES = {"search", "history"};

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());

        List<String> titles = new ArrayList<>();
        titles.add("first");
        titles.add("second");

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setOffscreenPageLimit(fragments.size());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < fragments.size(); i++) {
            View tabView = LayoutInflater.from(this).inflate(R.layout.view_custom_tab, null);
            ((ImageView) tabView.findViewById(R.id.iv_tab_icon)).setImageResource(TAB_ICONS[i]);
            ((TextView) tabView.findViewById(R.id.tv_tab_title)).setText(TAB_TITLES[i]);
            tabLayout.getTabAt(i).setCustomView(tabView);
        }
    }
}
