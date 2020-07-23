package com.fearlessbear.androidexperiment.components.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.fearlessbear.androidexperiment.R;

/**
 * Created by BigFaceBear on 2019.04.04
 */
public class ViewPageFragmentLifeCircleActivity extends Activity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_fragment_life_circle);
//        mViewPager = findViewById(R.id.viewpager);
//        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return new FragmentLifeCircleFragment();
//            }
//
//            @Override
//            public int getCount() {
//                return 5;
//            }
//        });
//        mViewPager.setOffscreenPageLimit(1);
    }
}
