package com.fearlessbear.androidexperiment.memory;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.fearlessbear.androidexperiment.R;
import com.fearlessbear.androidexperiment._base.BaseActivity;

public class CheckOutAppHeapSizeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_app_heap_size);
        TextView tvMemoryClass = (TextView) findViewById(R.id.tvClass);
        TextView tvLargerMemoryClass = (TextView) findViewById(R.id.tvLargerClass);

        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass = am.getMemoryClass();
        int largeMemoryClass = am.getLargeMemoryClass();
        tvMemoryClass.setText("Memory class is " + memoryClass + "Mb");
        tvLargerMemoryClass.setText("Larger memory class is " + largeMemoryClass + "Mb");
    }
}
