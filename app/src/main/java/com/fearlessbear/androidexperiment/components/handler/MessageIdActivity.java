package com.fearlessbear.androidexperiment.components.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Bundle;

import com.fearlessbear.androidexperiment.R;
import com.fearlessbear.androidexperiment._base.BaseActivity;

public class MessageIdActivity extends BaseActivity {
    Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_id);

        messageId();
    }

    private void messageId() {
        Message msg = Message.obtain(mHandler);
        msg.what = 1;
        mHandler.sendMessage(msg);
        mHandler.removeMessages(1);



    }
}
