package com.fearlessbear.androidexperiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listview);

        //界面数据
        ArrayList<Map<String, String>> list = new ArrayList<>();
        //1.获取当前手机单个应用可使用的最大内存
        HashMap<String, String> data1 = new HashMap<>();
        data1.put("title", "当前手机单个应用可用内存");
        list.add(data1);

        listview.setAdapter(new SimpleAdapter(
                this, list, android.R.layout.simple_list_item_1,
                new String[]{"title"}, new int[]{android.R.id.text1}));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, CheckOutAppHeapSizeActivity.class));
                        break;
                }
            }
        });


    }
}
