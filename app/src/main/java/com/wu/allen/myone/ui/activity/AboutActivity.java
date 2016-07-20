package com.wu.allen.myone.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;

import static com.wu.allen.myone.R.id.toolbar;

/**
 * Created by allen on 2016/7/16.
 */

public class AboutActivity extends BaseActivity {

    Toolbar mToolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_layout);
        SwipeBackHelper.onCreate(this);
        initView();
    }

    public void initView(){
        mToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar =
            (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }
}
