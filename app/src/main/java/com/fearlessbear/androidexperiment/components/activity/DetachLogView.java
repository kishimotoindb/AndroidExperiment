package com.fearlessbear.androidexperiment.components.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by BigFaceBear on 2019.09.18
 */
public class DetachLogView extends View {
    private static final String TAG = "DetachLogView";
    public DetachLogView(Context context) {
        super(context);
    }

    public DetachLogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DetachLogView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DetachLogView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow: ");
    }
}
