package com.fearlessbear.androidexperiment.components.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fearlessbear.androidexperiment.R;

public class FragmentLifeCircleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_circle);
        Log.i("xiong", "Activity onCreate");
        getFragmentManager().beginTransaction().replace(R.id.fl, new FragmentLifeCircleFragment()).commit();
        /*
            Activity onCreate
            Fragment onCreate
            Fragment onCreateView
            Fragment onViewCreated
            Fragment onActivityCreated
            Activity onStart
            Fragment onStart
            Activity onResume
            Fragment onResume
            Activity onAttachedToWindow
         */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("xiong", "Activity onStart");
        //getFragmentManager().beginTransaction().replace(R.id.fl, new FragmentLifeCircleFragment()).commit();
        /*
            Activity onCreate
            Activity onStart
            Fragment onCreate
            Fragment onCreateView
            Fragment onViewCreated
            Fragment onActivityCreated
            Fragment onStart
            Activity onResume
            Fragment onResume
            Activity onAttachedToWindow
         */
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("xiong", "Activity onResume");
        //getFragmentManager().beginTransaction().replace(R.id.fl, new FragmentLifeCircleFragment()).commit();
        /*
            Activity onCreate
            Activity onStart
            Activity onResume
            Fragment onCreate
            Fragment onCreateView
            Fragment onViewCreated
            Fragment onActivityCreated
            Fragment onStart
            Fragment onResume
            Activity onAttachedToWindow
         */
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
