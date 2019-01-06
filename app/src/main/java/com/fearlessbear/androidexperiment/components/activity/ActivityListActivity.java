package com.fearlessbear.androidexperiment.components.activity;

import com.fearlessbear.androidexperiment._base.BaseActivity;

public class ActivityListActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "ActivityOptions",
                "FragmentLifeCircle"
        };
        mClasses = new Class[]{
                ActivityOptionsNo1Activity.class,
                FragmentLifeCircleActivity.class
        };
    }
}
