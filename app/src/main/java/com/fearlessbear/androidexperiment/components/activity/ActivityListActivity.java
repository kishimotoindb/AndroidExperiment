package com.fearlessbear.androidexperiment.components.activity;

import com.fearlessbear.androidexperiment._base.BaseActivity;

public class ActivityListActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "ActivityOptions",
                "FragmentLifeCircle",
                "ViewPager中Fragment的生命周期",
                "ViewDetach和ActivityDestroy的顺序",
                "OptionsMenu的运行逻辑"
        };
        mClasses = new Class[]{
                ActivityOptionsNo1Activity.class,
                FragmentLifeCircleActivity.class,
                ViewPageFragmentLifeCircleActivity.class,
                ActivityLifeCircleActivity.class,
                OptionsMenuActivity.class
        };
    }
}
