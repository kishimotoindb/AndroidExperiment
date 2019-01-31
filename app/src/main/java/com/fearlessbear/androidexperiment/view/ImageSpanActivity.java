package com.fearlessbear.androidexperiment.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.fearlessbear.androidexperiment.R;

public class ImageSpanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_span);
        TextView text = (TextView) findViewById(R.id.text);
        SpannableString ss = new SpannableString("我是。");
        ss.setSpan(new ImageSpan(this, R.mipmap.ic_launcher), 2, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        text.setText(ss);
    }
}
