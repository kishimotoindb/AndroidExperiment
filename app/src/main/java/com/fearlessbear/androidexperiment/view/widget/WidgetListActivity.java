package com.fearlessbear.androidexperiment.view.widget;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.view.widget.recycler.RecyclerBaseLearnActivity;
import com.fearlessbear.androidexperiment.view.widget.recycler.StaggeredLayoutActivity;

public class WidgetListActivity extends BaseActivity {

  {
    mTitle = new String[]{
        "PopupWindow",
        "TextWatcher",
        "RecyclerViewBaseLearn",
        "StaggeredLayoutManager：FullSpan"
    };
    mClasses = new Class[]{
        PopupWindowActivity.class,
        TextWatcherActivity.class,
        RecyclerBaseLearnActivity.class,
        StaggeredLayoutActivity.class,
    };
  }
}
