package com.fearlessbear.androidexperiment.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.fearlessbear.androidexperiment.R;

/*
 * 2020-07-25 14:48:18.949 I/ListenLayout: onAttachedToWindow:
 * 2020-07-25 14:48:18.949 I/ListenLayout: onWindowVisibilityChanged: visible 0
 * 2020-07-25 14:48:18.949 I/ListenLayout: onVisibilityAggregated: visible true
 * 2020-07-25 14:48:21.445 I/ViewVisibilityListen: onClick: detach target
 * 2020-07-25 14:48:21.445 I/ListenLayout: onWindowVisibilityChanged: visible 8
 * 2020-07-25 14:48:21.445 I/ListenLayout: onVisibilityAggregated: visible false
 * 2020-07-25 14:48:21.445 I/ListenLayout: onDetachedFromWindow:
 * 2020-07-25 14:48:27.185 I/ViewVisibilityListen: onClick: attach target
 * 2020-07-25 14:48:27.187 I/ListenLayout: onAttachedToWindow:
 * 2020-07-25 14:48:27.187 I/ListenLayout: onWindowVisibilityChanged: visible 0
 * 2020-07-25 14:48:27.187 I/ListenLayout: onVisibilityAggregated: visible true
 * 2020-07-25 14:48:31.729 I/ViewVisibilityListen: onClick: set target gone
 * 2020-07-25 14:48:31.731 I/ListenLayout: onVisibilityAggregated: visible false
 * 2020-07-25 14:48:33.946 I/ViewVisibilityListen: onClick: set target visible
 * 2020-07-25 14:48:33.947 I/ListenLayout: onVisibilityAggregated: visible true
 * 2020-07-25 14:48:38.099 I/ViewVisibilityListen: onClick: set target invisible
 * 2020-07-25 14:48:38.102 I/ListenLayout: onVisibilityAggregated: visible false
 * 2020-07-25 14:48:39.558 I/ViewVisibilityListen: onClick: set target visible
 * 2020-07-25 14:48:39.559 I/ListenLayout: onVisibilityAggregated: visible true
 * 2020-07-25 15:02:05.339 I/ListenLayout: onAttachedToWindow:
 * 2020-07-25 15:02:05.339 I/ListenLayout: onWindowVisibilityChanged: visible 0
 * 2020-07-25 15:02:05.339 I/ListenLayout: onVisibilityAggregated: visible true
 * 2020-07-25 15:02:12.699 I/ListenLayout: onWindowVisibilityChanged: visible 8
 * 2020-07-25 15:02:12.700 I/ListenLayout: onVisibilityAggregated: visible false
 *
 * 从以上log来看，onVisibilityAggregated可以很好的反映出一个View是否真的对用户可见。attach/detach，
 * visible/gone/invisible，离开页面/回到页面。
 *
 * 用这个回调作为监听view对用户的可见性是可行的，但是需要从api 24开始。
 */
public class ViewVisibilityListenActivity extends Activity {

    private static final String TAG = "ViewVisibilityListen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_visibility_listen);
        final ViewGroup root = findViewById(R.id.root);
        final View target = findViewById(R.id.listenLayout);
        findViewById(R.id.startPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewVisibilityListenActivity.this, ImageSpanActivity.class));
            }
        });
        findViewById(R.id.switchAttach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (target.isAttachedToWindow()) {
                    Log.i(TAG, "onClick: detach target");
                    root.removeView(target);
                } else {
                    Log.i(TAG, "onClick: attach target");
                    root.addView(target);
                }
            }
        });
        findViewById(R.id.changeVisibility).setOnClickListener(new View.OnClickListener() {

            boolean invisible;

            @Override
            public void onClick(View v) {
                if (target.getVisibility() == View.VISIBLE) {
                    if (invisible) {
                        Log.i(TAG, "onClick: set target invisible");
                    } else {
                        Log.i(TAG, "onClick: set target gone");
                    }
                    target.setVisibility(invisible ? View.INVISIBLE : View.GONE);
                    invisible = !invisible;
                } else {
                    Log.i(TAG, "onClick: set target visible");
                    target.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /*
     * View的定义不能是内部类？用这里的ListenLayout在inflate的时候会找不到类文件
     */
    public static class ListenLayout extends ConstraintLayout {
        public ListenLayout(Context context) {
            super(context);
        }

        public ListenLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public ListenLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onWindowVisibilityChanged(int visibility) {
            super.onWindowVisibilityChanged(visibility);
            Log.i(TAG, "onWindowVisibilityChanged: visible " + visibility);
        }

        @Override
        public void onVisibilityAggregated(boolean isVisible) {
            super.onVisibilityAggregated(isVisible);
            Log.i(TAG, "onVisibilityAggregated: visible " + isVisible);
        }

        private static final String TAG = "ListenLayout";
    }
}
