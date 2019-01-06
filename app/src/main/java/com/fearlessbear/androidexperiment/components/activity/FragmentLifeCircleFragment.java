package com.fearlessbear.androidexperiment.components.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        Log.i("xiong", "Fragment onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("xiong", "Fragment onViewCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("xiong", "Fragment onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_circle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("xiong", "Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("xiong", "Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("xiong", "Fragment onResume");
    }
}
