package com.fearlessbear.androidexperiment;

import android.app.Application;
import android.util.Log;

/**
 * Created by BigFaceBear on 2020.01.28
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
