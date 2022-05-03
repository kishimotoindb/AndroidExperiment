package com.fearlessbear.androidexperiment._base;

import com.fearlessbear.androidexperiment.anr.AnrListActivity;
import com.fearlessbear.androidexperiment.arch.ArchListActivity;
import com.fearlessbear.androidexperiment.components.activity.ActivityListActivity;
import com.fearlessbear.androidexperiment.components.handler.HandlerListActivity;
import com.fearlessbear.androidexperiment.components.service.ServiceListActivity;
import com.fearlessbear.androidexperiment.foundation.asset.AssetListActivity;
import com.fearlessbear.androidexperiment.foundation.file.FileListActivity;
import com.fearlessbear.androidexperiment.memory.MemoryListActivity;
import com.fearlessbear.androidexperiment.packaging.PackageListActivity;
import com.fearlessbear.androidexperiment.uri.UriMenuActivity;
import com.fearlessbear.androidexperiment.view.ViewListActivity;
import com.fearlessbear.androidexperiment.view.window.WindowListActivity;

public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";

  {
    mTitle = new String[]{
        "Asset",
        "Service",
        "Activity",
        "Handler",
        "Memory",
        "View",
        "File",
        "ANR",
        "ARCH",
        "打包相关",
        "Window",
        "uri",
    };
    mClasses = new Class[]{
        AssetListActivity.class,
        ServiceListActivity.class,
        ActivityListActivity.class,
        HandlerListActivity.class,
        MemoryListActivity.class,
        ViewListActivity.class,
        FileListActivity.class,
        AnrListActivity.class,
        ArchListActivity.class,
        PackageListActivity.class,
        WindowListActivity.class,
        UriMenuActivity.class,
    };
  }
}
