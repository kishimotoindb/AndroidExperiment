package com.fearlessbear.androidexperiment.foundation.file;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.fearlessbear.androidexperiment.R;

import java.io.File;
import java.io.IOException;

public class SdcardActivity extends Activity {
    private static final String TAG = "SdcardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.miui.personalassistant/cache/uil-images/1649ua3998x00nlk19tygckpy0");
        Log.d(TAG, "file exist: " + file.exists());

        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            writeExternalStorage();
        }
    }

    void writeExternalStorage() {
        // 指定应用包名的外部存储路径
        File externalCacheDir = getExternalCacheDir();
        File pef = new File(externalCacheDir, "/testPkgExternal");
        try {
            pef.createNewFile();
            Log.d(TAG, "writeExternalStorage: pef path: " + pef.getAbsolutePath());
        } catch (IOException e) {
            Log.e(TAG, "writeExternalStorage: pkg specified external storage", e);
        }

        // sdcard/Android目录
        File f1 = new File(Environment.getExternalStorageDirectory(), "/Android/data/com.miui.personalassistant/cache/uil-images/test");
        try {
            boolean newFile = f1.createNewFile();
        } catch (IOException e) {
            Log.e(TAG, "create file", e);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        writeExternalStorage();
    }
}
