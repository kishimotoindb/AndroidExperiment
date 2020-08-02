package com.fearlessbear.androidexperiment.components.handler;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.components.activity.ActivityOptionsNo1Activity;

public class HandlerListActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "Message Id",
                "Logging"
        };
        mClasses = new Class[]{
                MessageIdActivity.class,
                LooperLoggingActivity.class
        };
    }
}
