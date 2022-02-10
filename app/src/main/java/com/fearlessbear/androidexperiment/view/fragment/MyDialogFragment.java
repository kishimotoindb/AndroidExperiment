package com.fearlessbear.androidexperiment.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.fearlessbear.androidexperiment.R;

public class MyDialogFragment extends DialogFragment {

  /*
   * DialogFragment在执行onCreateView()的时候，container传入的是null。
   * 1）所以就是说在调用DialogFragment.show()的时候没有传入containerId，结果就是DialogFragment的确没有container。
   * 2）这也就能解释为什么DialogFragment的布局xml文件中，根View的Layout参数无效。
   *
   * DialogFragment的视图能力有内部的Dialog提供，所有Fragment本身只需要提供Transaction的能力，也就不需要
   * 在Activity布局中提供containerView。DialogFragment是通过Dialog新启动了一个window
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_my_dialog, container);
    View childAt = root.getChildAt(0);
    childAt.setOnClickListener(view->{
      PopupWindow pw = new PopupWindow(root.getContext());
      TextView textView = new TextView(root.getContext());
      textView.setText("引导");
      pw.setContentView(textView);
      pw.setFocusable(false);
      pw.setOutsideTouchable(true);
      pw.showAsDropDown(childAt,0,-200);
    });
    return root;
  }

  @Override
  public void onResume() {
    super.onResume();
  }
}
