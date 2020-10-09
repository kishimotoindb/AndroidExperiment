package com.fearlessbear.androidexperiment.view.hierarchy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewStub;

import com.fearlessbear.androidexperiment.R;

public class HierarchyActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hierarchy);

    expr4();
  }

  private void expr4() {
    ViewStub stub = (ViewStub) findViewById(R.id.expr4_stub);
    stub.post(new Runnable() {
      @Override
      public void run() {
        stub.inflate();
      }
    });
  }
}