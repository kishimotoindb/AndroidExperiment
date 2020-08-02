package com.fearlessbear.androidexperiment.components.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Trace;
import android.util.Printer;
import android.view.View;

import com.fearlessbear.androidexperiment.R;

public class LooperLoggingActivity extends Activity {

    private View invalidateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_logging);
        /*
         * 1.Vsync信号在app不需要刷新绘制的时候，会发送给app么？
         * 答：不会。
         *
         * ---
         * 2.如果一个页面一直不刷新，这段时间就不会执行doFrame？（可以用systrace观察）
         * 答：是的，如果页面没有主动触发申请vsync信号的操作（比如点击、invalidate、requestLayout、动画等），
         *     app进程就不会接收到Vsync信号，进而也不会回调doFrame。
         *
         * 实验设计：
         * 间隔性的点击invalidateBtn三次，观察systrace图像中的变化。
         *
         * 结论：
         * 只有在invalidateBtn被点击的时候，systrace中才会开始有帧的图像，用来处理input事件。其他时候app
         * 进程都没有收到vsync信号。
         *
         * 实验生成的systrace文件：
         * 根目录的files文件夹中，LooperLoggingActivity_vsync_request.html.zip
         *
         *
         * ---
         */
        invalidateBtn = findViewById(R.id.invalidate);
        invalidateBtn.setOnClickListener(view -> {
            try {
                Trace.beginSection("click_invalidate");
                invalidateBtn.invalidate();
            } finally {
                Trace.endSection();
            }
        });

        /*
         * 每个主线程的消息处理过程加一个trace
         *
         * 结论：
         * 通过systrace来看，是可行的
         *
         * 实验生成的trace文件：
         * 根目录的files文件夹中，LooperLoggingActivity_vsync_request.html.zip
         */
        Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {
                if (x.contains(">>>>>")) {
                    Trace.beginSection("handleMsg");
                } else if (x.contains("<<<<<")) {
                    Trace.endSection();
                }
            }
        });
    }
}