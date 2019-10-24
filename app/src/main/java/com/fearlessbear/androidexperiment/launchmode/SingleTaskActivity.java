package com.fearlessbear.androidexperiment.launchmode;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fearlessbear.androidexperiment.R;

public class SingleTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        Button btnSt = findViewById(R.id.singleTask);
        Button btndef = findViewById(R.id.defaultMode);
        btndef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("personalassistant://stock/search"));
                startActivity(intent);
            }
        });
        btnSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("personalassistant://base/web?url=http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
