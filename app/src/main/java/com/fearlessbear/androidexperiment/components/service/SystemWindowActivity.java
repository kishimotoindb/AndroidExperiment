package com.fearlessbear.androidexperiment.components.service;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.fearlessbear.androidexperiment.R;

public class SystemWindowActivity extends Activity {
    String TAG = "SystemWindowActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_window);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFloatingWindow();
            }
        });
    }

    @SuppressWarnings("all")
    private void addFloatingWindow() {
        if (!Settings.canDrawOverlays(this)) {
//            requestPermissions(new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW}, 1001);
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivity(intent);
        } else {
            showFloatingWindow();
        }
    }

    private void showFloatingWindow() {
        final View floating = LayoutInflater.from(this).inflate(R.layout.layout_floating_window, null);
        floating.findViewById(R.id.pbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindowManager().removeView(floating);
            }
        });
        WindowManager wm = getWindowManager();
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                100,
                100,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                0,
                PixelFormat.RGBA_8888
        );
        params.flags &= ~WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        wm.addView(floating, params);
        Log.d(TAG, "showFloatingWindow: addView");
    }

    private boolean checkSystemWindowPermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) == PackageManager.PERMISSION_GRANTED;
        Log.d(TAG, "checkSystemWindowPermission: " + (result ? "granted" : " not granted"));
        return result;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean result = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        Log.d(TAG, "onRequestPermissionsResult: requestCode " + requestCode + (result ? "granted" : "not granted"));
        if (requestCode == 1001 && result) {
            showFloatingWindow();
        }
    }
}
