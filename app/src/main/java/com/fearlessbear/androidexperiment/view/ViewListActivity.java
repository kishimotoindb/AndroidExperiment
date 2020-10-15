package com.fearlessbear.androidexperiment.view;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.memory.CheckOutAppHeapSizeActivity;
import com.fearlessbear.androidexperiment.view.component.ComponentListActivity;
import com.fearlessbear.androidexperiment.view.fragment.FragmentListActivity;
import com.fearlessbear.androidexperiment.view.hierarchy.HierarchyActivity;
import com.fearlessbear.androidexperiment.view.performance.PerformanceListActivity;

public class ViewListActivity extends BaseActivity {

  {
    mTitle = new String[]{
        "当前手机单个应用可用内存",
        "ImageSpan",
        "布局右对齐",
        "监听View对用户的可见性",
        "EditText弹出键盘的问题",
        "View在ViewGroup中的显示顺序",
        "布局性能",
        "ConstraintLayout学习",
        "Fragment相关View体系",
        "控件学习",
    };
    mClasses = new Class[]{
        CheckOutAppHeapSizeActivity.class,
        ImageSpanActivity.class,
        RightToLeftActivity.class,
        ViewVisibilityListenActivity.class,
        EditTextKeyboardActivity.class,
        HierarchyActivity.class,
        PerformanceListActivity.class,
        ConstraintLayoutLearningActivity.class,
        FragmentListActivity.class,
        ComponentListActivity.class,
    };
  }
}
