package com.fearlessbear.androidexperiment.components.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.fearlessbear.androidexperiment.R;

/*
 * 1. Activity的onDestroy、Application里注册的ActivityLifeCycle监听中的onDestroy、Activity中View
 * 的onDetachFromWindow，这三个方法被调用的顺序
 * 答：onDestroy -> lifeCycle -> detached
 */
public class ActivityLifeCircleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_circle);
        Log.i("xiong", "Activity onCreate");
    }

    @Override
    protected void onStart() {
        Log.i("xiong", "Activity onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("xiong", "Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("xiong", "Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("xiong", "Activity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("xiong", "Activity onRestart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("xiong", "Activity onRestoreInstanceState");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.i("xiong", "Activity onUserLeaveHint");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i("xiong", "Activity onCreate,persist");

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("xiong", "Activity onAttachedToWindow");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.i("xiong", "Activity onAttachFragment");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("xiong", "Activity onDetachedFromWindow");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.i("xiong", "Activity onPostCreate");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i("xiong", "Activity onSaveInstanceState,persist");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("xiong", "Activity onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("xiong", "Activity onSaveInstanceState");
    }
}
