package com.fearlessbear.androidexperiment.memory;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.view.textview.ImageSpanActivity;

public class MemoryListActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "当前手机单个应用可用内存",
                "ImageSpan"
        };
        mClasses = new Class[]{
                CheckOutAppHeapSizeActivity.class,
                ImageSpanActivity.class
        };
    }
}
