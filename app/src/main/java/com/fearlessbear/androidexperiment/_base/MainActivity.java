package com.fearlessbear.androidexperiment._base;

import com.fearlessbear.androidexperiment.components.activity.ActivityListActivity;
import com.fearlessbear.androidexperiment.components.handler.HandlerListActivity;
import com.fearlessbear.androidexperiment.foundation.asset.AssetListActivity;
import com.fearlessbear.androidexperiment.memory.MemoryListActivity;
import com.fearlessbear.androidexperiment.components.service.ServiceListActivity;
import com.fearlessbear.androidexperiment.view.ViewListActivity;

public class MainActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "Asset",
                "Service",
                "Activity",
                "Handler",
                "Memory",
                "View"
        };
        mClasses = new Class[]{
                AssetListActivity.class,
                ServiceListActivity.class,
                ActivityListActivity.class,
                HandlerListActivity.class,
                MemoryListActivity.class,
                ViewListActivity.class
        };
    }
}
