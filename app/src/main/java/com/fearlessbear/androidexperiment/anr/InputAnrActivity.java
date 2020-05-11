package com.fearlessbear.androidexperiment.anr;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fearlessbear.androidexperiment.R;
import com.fearlessbear.androidexperiment.databinding.ActivityInputAnrBinding;

public class InputAnrActivity extends Activity {

    private ActivityInputAnrBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityInputAnrBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        /*
         * 按道理点击按钮第一次之后，如果在第5~8秒之间再次点击按钮，应该会触发input anr。
         * 但是目前看到的现象并不是如此，可能和小米手机有关。
         */
        mBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InputAnrActivity.this, "start", Toast.LENGTH_LONG).show();
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {

                }
            }
        });

    }
}
