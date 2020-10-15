package com.fearlessbear.androidexperiment.view.fragment;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.view.performance.layout.LayoutListActivity;

public class FragmentListActivity extends BaseActivity {

  {
    mTitle = new String[]{
        "DialogFragment的window",
    };
    mClasses = new Class[]{
        DialogFragmentLearnActivity.class,
    };
  }
}
