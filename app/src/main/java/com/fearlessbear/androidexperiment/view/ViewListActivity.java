package com.fearlessbear.androidexperiment.view;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.memory.CheckOutAppHeapSizeActivity;

public class ViewListActivity extends BaseActivity {

    {
        mTitle = new String[]{
                "当前手机单个应用可用内存",
                "ImageSpan",
                "布局右对齐",
                "监听View对用户的可见性"
        };
        mClasses = new Class[]{
                CheckOutAppHeapSizeActivity.class,
                ImageSpanActivity.class,
                RightToLeftActivity.class,
                ViewVisibilityListenActivity.class
        };
    }
}
