package com.wu.allen.myone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Qa;

/**
 * Created by allen on 2016/7/16.
 */

public class QaDetailActivity extends AppCompatActivity {

    private static final String TAG = "QaDetailActivity";
    private Intent mIntent;
    private Qa mQa;
    private Toolbar mToolbar;
    private TextView mTvtitle,mTvques,mTvansw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qadetail_layout);
        SwipeBackHelper.onCreate(this);
        getData();
        initView();
    }

    public void initView(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTvtitle = (TextView)findViewById(R.id.tv_intr);
        mTvques = (TextView)findViewById(R.id.tv_ques);
        mTvansw = (TextView)findViewById(R.id.tv_answ);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        mTvtitle.setText(mQa.getQaIntr());
        mTvques.setText(mQa.getQaDetail());
        mTvansw.setText(mQa.getQaAnsw());
    }

    public void getData(){
        mIntent = getIntent();
        mQa = (Qa) mIntent.getSerializableExtra("qa");
        Log.d(TAG,mQa.getQaIntr());
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
}
