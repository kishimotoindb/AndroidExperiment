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
