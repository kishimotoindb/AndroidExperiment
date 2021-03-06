package com.fearlessbear.androidexperiment.components.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fearlessbear.androidexperiment.R;

public class ActivityOptionsNo1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no1_anim);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle anim = ActivityOptions.makeCustomAnimation(ActivityOptionsNo1Activity.this, R.anim.activity_options_enter_anim, 0).toBundle();
                startActivity(new Intent(ActivityOptionsNo1Activity.this, ActivityOptionsNo2Activity.class), anim);
            }
        });

    }
}
