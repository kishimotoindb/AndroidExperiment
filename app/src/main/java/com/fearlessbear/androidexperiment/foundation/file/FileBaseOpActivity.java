package com.fearlessbear.androidexperiment.foundation.file;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fearlessbear.androidexperiment.R;

import java.io.File;
import java.io.IOException;

public class FileBaseOpActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "FileBaseOpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_base_op);

        View rename = findViewById(R.id.rename);
        rename.setOnClickListener(this);

        View delete = findViewById(R.id.delete);
        delete.setOnClickListener(this);

        View canRead = findViewById(R.id.canRead);
        canRead.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rename:
                rename();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.canRead:
                canRead();
                break;
        }
    }

    private void canRead() {
        File file = new File(getCacheDir(), "canRead");
        Log.d(TAG, "canRead: before create, succ " + file.canRead());
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        Log.d(TAG, "canRead: after create, succ " + file.canRead());
        /*
         * canRead: before create, succ false
         * canRead: after create, succ true
         * 结论：
         * canRead在文件不存在的时候调用不会crash，返回不可读，相当于判断了文件不存在
         */
    }

    private void delete() {
        File file = new File(getCacheDir(), "delete");
        Log.d(TAG, "delete: before create, succ " + file.delete());
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        Log.d(TAG, "delete: after create, succ " + file.delete());
        /*
         * delete: before create, succ false
         * delete: after create, succ true
         * 结论：
         * delete在文件不存在的时候调用不会crash，返回false，相当于判断了文件不存在，所以删除不成功
         */
    }

    private void rename() {
        try {
            File cacheDir = getCacheDir();
            File source = new File(cacheDir, "source");
            File backup = new File(cacheDir, "backup");
            if (!source.exists()) {
                source.createNewFile();
            }
            Log.d(TAG, "rename: before rename: source file path is " + source.getPath() + ", source exists " + source.exists() + ", backup exists " + backup.exists());
            source.renameTo(backup);
            Log.d(TAG, "rename: after rename: source file path is " + source.getPath() + ", source exists " + source.exists() + ", backup exists " + backup.exists());
            /*
             *  before rename: source file path is /data/user/0/com.fearlessbear.androidexperiment/cache/source, source exists true, backup exists false
             *  after rename: source file path is /data/user/0/com.fearlessbear.androidexperiment/cache/source, source exists false, backup exists true
             *  结论：
             *  1. rename方法只是将当前source指向的文件改名为backup，source这个file对象的path并不会改变，也就是说rename之后，source就操作不到原来source指向的文件了。
             */
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
