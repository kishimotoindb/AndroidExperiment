package com.fearlessbear.androidexperiment.packaging;

//import com.example.library.ModuleIdCollapseActivity;
import com.fearlessbear.androidexperiment._base.BaseActivity;

public class PackageListActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    {
        mTitle = new String[]{
               "module依赖中id的关系",
        };
        mClasses = new Class[]{
//            ModuleIdCollapseActivity.class,
        };
    }
}
