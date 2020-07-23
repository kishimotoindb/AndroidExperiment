package com.fearlessbear.androidexperiment.arch;

import com.fearlessbear.androidexperiment._base.BaseActivity;
import com.fearlessbear.androidexperiment.arch.paging.PagingListActivity;

public class ArchListActivity extends BaseActivity {

    {
        mTitle = new String[]{
               "paging"
        };
        mClasses = new Class[]{
                PagingListActivity.class
        };
    }

}