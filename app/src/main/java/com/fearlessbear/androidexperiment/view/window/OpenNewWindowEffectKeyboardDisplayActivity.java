package com.fearlessbear.androidexperiment.view.window;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fearlessbear.androidexperiment.R;

/*
 * 在当前Activity上开启一个新的window（toast、dialog、type_application的window），对当前activity拉起
 * 的键盘展示有什么影响？
 * 结论：
 * 1.系统原生Toast：System级别window，不影响当前Activity的键盘展示。即，toast弹出，键盘保持展示，不收起。
 * 2.系统原生Dialog：System级别window，不影响当前Activity的键盘展示。即，dialog弹起，键盘保持展示，不收起。
 * 3.Type_Application级别window：影响当前Activity的键盘展示。即，弹起后，键盘收起，关闭后，键盘重新弹出。（Manifest中设置always_visible）
 */
public class OpenNewWindowEffectKeyboardDisplayActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_toast_effect_keyboard_display);
    findViewById(R.id.edittext).requestFocus();
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getBaseContext(), "Toast", Toast.LENGTH_LONG).show();
      }
    });
    findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        LinearLayout ll = new LinearLayout(getBaseContext());
        TextView textView = new TextView(getBaseContext());
        textView.setText("I am first Dialog");
        textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            new AlertDialog.Builder(OpenNewWindowEffectKeyboardDisplayActivity.this)
                .setTitle("I am the second dialog")
                .show();
          }
        });
        EditText editText = new EditText(getBaseContext());
        editText.setText("I am the first dialog");
        ll.addView(textView);
        ll.addView(editText);


        new AlertDialog.Builder(OpenNewWindowEffectKeyboardDisplayActivity.this)
            .setView(ll)
            .show();
      }
    });
    findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        WindowManager.LayoutParams lp =
            new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_APPLICATION);
        lp.width = 300;
        lp.height = 300;
        lp.gravity = Gravity.CENTER;
        TextView textView = new TextView(getBaseContext());
        textView.setOnClickListener(
            v -> ((WindowManager) getSystemService(WINDOW_SERVICE)).removeView(textView));
        textView.setText("I am TypeApplicationWindow");
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.addView(textView, lp);
      }
    });
  }
}