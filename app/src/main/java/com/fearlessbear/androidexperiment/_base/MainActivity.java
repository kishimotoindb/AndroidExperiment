package com.fearlessbear.androidexperiment._base;

import com.fearlessbear.androidexperiment.components.activity.ActivityListActivity;
import com.fearlessbear.androidexperiment.components.handler.HandlerListActivity;
import com.fearlessbear.androidexperiment.foundation.asset.AssetListActivity;
import com.fearlessbear.androidexperiment.memory.MemoryListActivity;
import com.fearlessbear.androidexperiment.service.ServiceListActivity;

public class MainActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "Asset",
                "Service",
                "Activity",
                "Handler",
                "Memory"
        };
        mClasses = new Class[]{
                AssetListActivity.class,
                ServiceListActivity.class,
                ActivityListActivity.class,
                HandlerListActivity.class,
                MemoryListActivity.class
        };
    }
}
