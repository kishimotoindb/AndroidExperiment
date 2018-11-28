package com.fearlessbear.androidexperiment.view.textview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.fearlessbear.androidexperiment.R;

public class ImageSpanActivity extends AppCompatActivity {

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
