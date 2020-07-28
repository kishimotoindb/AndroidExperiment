package com.fearlessbear.androidexperiment.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.fearlessbear.androidexperiment.R;

public class EditTextKeyboardActivity extends AppCompatActivity {

    private View editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_keyboard);
        editText = findViewById(R.id.edittext);
        editText.requestFocus();
        editText.setFocusable(true);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        /*
         * 可以通过在manifest中给当前Activity配置windowSoftInputMode处理键盘的自动弹出。
         * 另外还可以通过imm控制键盘的弹出和收起，但是这种情况需要有延时，需要View已经attach
         */
        editText.postDelayed(new Runnable() {
            @Override
            public void run() {
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(editText, 0);
                editText.requestFocus();
            }
        }, 50);

    }
}