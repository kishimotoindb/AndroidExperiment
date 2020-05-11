package com.fearlessbear.androidexperiment._base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.fearlessbear.androidexperiment.R;
import com.fearlessbear.androidexperiment.databinding.ActivityMainBinding;

public class BaseActivity extends Activity {
    protected ListView listView;
    protected String[] mTitle;
    protected Class[] mClasses;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.listview.setAdapter(new MyAdapter(mTitle, mClasses));
    }
}
