package com.fearlessbear.androidexperiment.view.fragment;

import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.fearlessbear.androidexperiment.R;

public class DialogFragmentLearnActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialog_fragment_learn);

    Window window = getWindow();
    window.setTitle("DialogFragmentLearnActivity");

    DialogFragment fragment = new MyDialogFragment();
    fragment.show(getSupportFragmentManager(), "dialogFragment");
  }

}