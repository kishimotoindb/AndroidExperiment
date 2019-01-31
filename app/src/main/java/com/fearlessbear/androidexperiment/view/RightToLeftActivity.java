package com.fearlessbear.androidexperiment.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fearlessbear.androidexperiment.R;

/**
 * 问题：
 * <p>
 * 1. 布局改为右对齐之后，整个layout是对称翻转？
 * 答：整个layout会左右对称翻转
 * <p>
 * 2. paddingLeft和paddingStart有什么区别？
 * 答：如果是left，无所谓layout是否左右对称翻转，是一个绝对的方向，即屏幕左侧。但是start的话，是相对layout的
 * 左右而言的，所以翻转后实际是right。
 */
public class RightToLeftActivity extends Activity implements View.OnClickListener {
    TextView mTvDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_right_align);
        findViewById(R.id.button).setOnClickListener(this);
        mTvDirection = findViewById(R.id.direction);
    }


    @Override
    public void onClick(View v) {
        if (v.isSelected()) {
            mTvDirection.setText("LTR");
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        } else {
            mTvDirection.setText("RTL");
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        v.setSelected(!v.isSelected());
    }
}
