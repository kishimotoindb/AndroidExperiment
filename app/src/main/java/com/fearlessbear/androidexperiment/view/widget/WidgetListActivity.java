package com.fearlessbear.androidexperiment.view.widget;

import com.fearlessbear.androidexperiment._base.BaseActivity;

public class WidgetListActivity extends BaseActivity {

  {
    mTitle = new String[]{
        "PopupWindow",
        "TextWatcher",
    };
    mClasses = new Class[]{
        PopupWindowActivity.class,
        TextWatcherActivity.class,
    };
  }
}
