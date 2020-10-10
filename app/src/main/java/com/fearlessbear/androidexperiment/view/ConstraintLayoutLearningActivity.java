package com.fearlessbear.androidexperiment.view;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.fearlessbear.androidexperiment.R;

public class ConstraintLayoutLearningActivity extends AppCompatActivity {

  private View mExpr2MarginEndView;
  private View mExpr1LeftView;
  private View mExpr1Placeholder;
  private View mExpr1Button;
  private View mExpr2Button;
  private View mExpr3MarginEndView;
  private View mExpr3Button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_constraint_layout_learning);

    /*
     * 实验一:
     * ConstraintLayout，LeftView设置marginEnd对RightView无效。达到同样的效果，
     * 可以有两种bypass的方案：1）LeftView设置paddingEnd 2）LeftView和RightView之间再放一个View
     */
    mExpr1LeftView = findViewById(R.id.left_view);
    mExpr1Placeholder = findViewById(R.id.placeholder);
    mExpr1Button = findViewById(R.id.expr1_button);
    mExpr1Button.setOnClickListener(view -> {
      int visibility = mExpr1LeftView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
      mExpr1LeftView.setVisibility(visibility);
      mExpr1Placeholder.setVisibility(visibility);
    });

    /*
     * 实验二：
     * 正常ViewGroup中的margin在View设置为GONE后是否还生效？
     */
    mExpr2MarginEndView = findViewById(R.id.expr2_margin_end_view);
    mExpr2Button = findViewById(R.id.expr2_button);
    mExpr2Button.setOnClickListener(view -> {
      mExpr2MarginEndView.setVisibility(mExpr2MarginEndView.getVisibility() == View.VISIBLE ?
          View.GONE : View.VISIBLE);
    });

    /*
     * 实验三：
     * 正常ViewGroup中的margin在View设置为Invisible后是否还生效？
     */
    mExpr3MarginEndView = findViewById(R.id.expr3_margin_end_view);
    mExpr3Button = findViewById(R.id.expr3_button);
    mExpr3Button.setOnClickListener(view -> {
      mExpr3MarginEndView.setVisibility(mExpr3MarginEndView.getVisibility() == View.VISIBLE ?
          View.INVISIBLE : View.VISIBLE);
    });
  }
}