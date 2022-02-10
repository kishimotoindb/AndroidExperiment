package com.fearlessbear.androidexperiment.view.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.fearlessbear.androidexperiment.R;

/*
 * PopupWindow在弹起的时候，是否可以透传点击事件给下层的View，同时自己仍然展示？
 * 答：正常弹起的popupWindow，它的外轮廓外的点击事件，是直接透传到下一层的window的。但是点击到pop内的事件，
 * 是会被拦截的。
 *
 */
public class PopupWindowActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_popup_window);
    findViewById(R.id.btn).setOnClickListener(v->{
      Toast.makeText(this, "外围可点击", Toast.LENGTH_SHORT).show();
    });
    findViewById(R.id.txt).setOnClickListener(v->{
      PopupWindow pw = new PopupWindow(PopupWindowActivity.this);
      TextView textView = new TextView(PopupWindowActivity.this);
      textView.setText("popupWindow");
      pw.setContentView(textView);
      /*
       * true和false，pop外轮廓之外的区域，点击事件都是透传到下一层window的
       */
      pw.setOutsideTouchable(false);
      /*
       * 设置为false，所有点击事件都会透传到下一层的window，当前window不接收事件
       */
      pw.setTouchable(false);
      pw.setFocusable(false);
      pw.showAsDropDown(v);

    });
  }
}