package com.fearlessbear.androidexperiment.components.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fearlessbear.androidexperiment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLifeCircleFragment extends Fragment {


    public FragmentLifeCircleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("xiong", getTag() + " Fragment onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("xiong", getTag() + " Fragment onViewCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("xiong", getTag() + " Fragment onCreateView");
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_life_circle, container, false);
        ((TextView) root.findViewById(R.id.text)).setText(getTag());
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("xiong", getTag() + " Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("xiong", getTag() + " Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("xiong", getTag() + " Fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("xiong", getTag() + " Fragment onPause");
    }

    // 页面可见的起始时间
    private long mStartTimeMillis;
    private boolean mIsVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            mStartTimeMillis = System.currentTimeMillis();
        } else if (mIsVisible) {
            // 因为ViewPager在初始化Fragment的时候会调用setUserVisibleHint(false)，所以需要判断是否是
            // 从可见变为不可见
            Log.e("xiong", getTag() + " become invisible count");
        }
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisible = isVisibleToUser;
        Log.i("xiong", getTag() + " Fragment visible to user " + isVisibleToUser);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("xiong", getTag() + " Fragment onStop");

        // 如果离开时可见，那么在这里打点。如果不可见，说明已经通过setUserVisibleHint()方法将fragment
        // 设置为不可见，那么应该在
        if (mIsVisible) {
            Log.e("xiong", getTag() + " onStop count");
        }
    }
}
