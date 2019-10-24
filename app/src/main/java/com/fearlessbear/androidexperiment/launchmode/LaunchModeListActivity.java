package com.fearlessbear.androidexperiment.launchmode;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.components.activity.ActivityLifeCircleActivity;
import com.fearlessbear.androidexperiment.components.activity.ActivityOptionsNo1Activity;
import com.fearlessbear.androidexperiment.components.activity.FragmentLifeCircleActivity;
import com.fearlessbear.androidexperiment.components.activity.ViewPageFragmentLifeCircleActivity;

public class LaunchModeListActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "SingleTask会开到其他stack中么？",
        };
        mClasses = new Class[]{
                SingleTaskActivity.class
        };
    }
}
