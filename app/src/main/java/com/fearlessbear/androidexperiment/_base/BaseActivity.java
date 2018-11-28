package com.fearlessbear.androidexperiment._base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.fearlessbear.androidexperiment.R;
import com.fearlessbear.androidexperiment.activity.ActivityListActivity;

public class BaseActivity extends AppCompatActivity {
    protected ListView listView;
    protected String[] mTitle;
    protected Class[] mClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter(mTitle, mClasses));
    }
}
