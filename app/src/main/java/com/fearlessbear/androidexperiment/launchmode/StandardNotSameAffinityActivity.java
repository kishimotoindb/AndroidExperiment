package com.fearlessbear.androidexperiment.launchmode;

import android.app.Activity;
import android.os.Bundle;

import com.fearlessbear.androidexperiment.R;

public class StandardNotSameAffinityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_not_same_affinity);
    }
}
