package com.fearlessbear.androidexperiment.view.widget;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.fearlessbear.androidexperiment.R;

public class TextWatcherActivity extends AppCompatActivity {

  String TAG = "TextWatcherActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_text_watcher);
    ((EditText) findViewById(R.id.edit)).addTextChangedListener(new TextWatcher() {

      /**
       * This method is called to notify you that, within <code>s</code>,
       * the <code>count</code> characters beginning at <code>start</code>
       * are about to be replaced by new text with length <code>after</code>.
       * It is an error to attempt to make changes to <code>s</code> from
       * this callback.
       *
       * s：输入下一个字符或者粘贴下一个字符(串)前，当前显示的文本内容
       * start：输入下一个字符或者粘贴下一个字符(串)前，光标所在的位置
       * count：将要被替换的文本长度
       * after：新输入文本的长度
       *
       * 从注释可以看出，before的时候，只是知道源字符串从第几个字符到第几个字符将被替换，并且新的字符有多长，
       * 但是完全没有提供新字符串的字符是什么。
       *
       * 1）插入新字符：start-插入位置；count=0，因为源字符串中没有字符会被替换；after，新字符串的长度
       * 2）替换：
       *  a.选中某些字符，然后从键盘输入新的字符
       *  b.选中某些字符，长按粘贴，原有字符（串）被替换为新的字符（串）
       *  start-选中字符的第一个字符的index
       *  count-选中字符的数量
       *  after-替换原有字符（串）的字符（串）的字符数量
       * 3) 删除：start-被删除字符（串）的第一个字符的位置；count-删除的字符数量；after=0，删除字符没有新字符，所以
       *  after为零
       *
       * 注意：
       * s是输入前的老字符串，这个回调描述的是老字符串的哪个子串被替换了
       */
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d(TAG,
            "beforeTextChanged: s " + s + ", start " + start + ", count " + count + ", after " +
                after);
      }

      /**
       * This method is called to notify you that, within <code>s</code>,
       * the <code>count</code> characters beginning at <code>start</code>
       * have just replaced old text that had length <code>before</code>.
       * It is an error to attempt to make changes to <code>s</code> from
       * this callback.
       *
       * 注意：
       * 输入前EditText上显示的是star，输入t，EditText的mText被设置为是start，即输入后的完整的新字符串。
       * s是输入后的完整的新字符串，这个回调描述的是新字符串的哪个子串是新输入的
       */
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG,
            "onTextChanged: s " + s + ", start " + start + ", count " + count + ", before " +
                before);
      }

      @Override
      public void afterTextChanged(Editable s) {
        Log.d(TAG,
            "afterTextChanged: s " + s);

        if (s.charAt(s.length() - 1)=='1') {
          s.delete(s.length() - 1, s.length());
        }
      }
    });
  }
}