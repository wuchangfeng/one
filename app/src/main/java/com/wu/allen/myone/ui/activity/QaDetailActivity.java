package com.wu.allen.myone.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.model.Qa;
import com.wu.allen.myone.utils.ToastUtil;

/**
 * Created by allen on 2016/7/16.
 */

public class QaDetailActivity extends BaseActivity {

    private static final String TAG = "QaDetailActivity";
    private Intent mIntent;
    private Qa mQa;
    private Toolbar mToolbar;
    private TextView mTvtitle,mTvques,mTvansw,mTvcard;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
        mTvcard = (TextView)findViewById(R.id.tv_card);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(mQa.getQaIntr());
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);
        mTvques.setText(mQa.getQaDetail().trim());
        mTvansw.setText(mQa.getQaAnsw().trim());
        mTvcard.setText(mQa.getQaIntr().trim());
    }

    public void getData(){
        mIntent = getIntent();
        mQa = (Qa) mIntent.getSerializableExtra("qa");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_article_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_like){
            ToastUtil.showShort(QaDetailActivity.this,"Thank you for like it");
        }else if (id == R.id.action_share){

        }else if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
