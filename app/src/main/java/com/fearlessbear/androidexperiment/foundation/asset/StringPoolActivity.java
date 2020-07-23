package com.fearlessbear.androidexperiment.foundation.asset;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.fearlessbear.androidexperiment.R;

/**
 * apk在打包的时候，会将资源文件里的所有字符串去重然后放到一个字符串池中，当前Activity用于验证
 * 在layout.xml中hardcode的字符串和string.xml定义的字符串，是否均在字符串池中，其是不是相同的
 * 字符串对象。
 */
public class StringPoolActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_pool);
        String resource = getString(R.string.app_name);
        String hardcode = (String) ((TextView) findViewById(R.id.textHardCode)).getText();
        String quote = (String) ((TextView) findViewById(R.id.textQuote)).getText();

        TextView result = (TextView) findViewById(R.id.result);
        StringBuilder sb = new StringBuilder();
        sb.append("resource vs hardcode: " + (resource == hardcode) + "\r\n"); //false
        sb.append("resource vs quote: " + (resource == quote) + "\r\n"); //true
        sb.append("hardcode vs quote: " + (hardcode == quote) + "\r\n"); //false
        result.setText(sb.toString());

    }
}
