package com.fearlessbear.androidexperiment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment._base.MyAdapter;

public class ActivityListActivity extends BaseActivity {
    {
        mTitle = new String[]{
                "ActivityOptions"
        };
        mClasses = new Class[]{
                ActivityOptionsNo1Activity.class
        };
    }
}
