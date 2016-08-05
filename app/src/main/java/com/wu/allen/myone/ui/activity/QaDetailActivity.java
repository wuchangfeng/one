package com.wu.allen.myone.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.model.Qa;
import com.wu.allen.myone.utils.RanNumUtil;
import com.wu.allen.myone.utils.ShareUtil;
import com.wu.allen.myone.utils.ToastUtil;

/**
 * Created by allen on 2016/7/16.
 */

public class QaDetailActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "QaDetailActivity";
    private Intent mIntent;
    private Qa mQa;
    private Toolbar mToolbar;
    private TextView tvTitle,tvQues,tvAnsw,tvCard;
    private Button btnLike,btnCom,btnShare;
    private TextView tvLike,tvCom,tvShare;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qadetail_layout);
        SwipeBackHelper.onCreate(this);
        getData();
        initView();
    }


    public void getData(){
        mIntent = getIntent();
        mQa = (Qa) mIntent.getSerializableExtra("qa");
    }


    public void initView(){
        mToolbar = $(R.id.toolbar);
        tvTitle = $(R.id.tv_intr);
        tvQues = $(R.id.tv_ques);
        tvAnsw = $(R.id.tv_answ);
        tvCard = $(R.id.tv_card);
        btnLike = $(R.id.btn_like);
        btnCom = $(R.id.btn_comment);
        btnShare = $(R.id.btn_share);
        tvLike = $(R.id.tv_like);
        tvCom = $(R.id.tv_comment);
        tvShare = $(R.id.tv_share);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(mQa.getQaIntr());
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);
        setOnListener();
        setData();
    }

    private void setOnListener() {
        btnLike.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        btnCom.setOnClickListener(this);
    }

    private void setData() {
        tvQues.setText(mQa.getQaDetail().trim());
        tvAnsw.setText(mQa.getQaAnsw().trim());
        tvCard.setText(mQa.getQaIntr().trim());
        tvLike.setText(RanNumUtil.genNum());
        tvCom.setText(RanNumUtil.genNum());
        tvShare.setText(RanNumUtil.genNum());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_comment:
                Intent intent = new Intent(this, CommentsActivity.class);
                intent.putExtra("objectId",mQa.getObjectId());
                intent.putExtra("type","OneQa");
                intent.putExtra("comment","QuesCom");
                startActivity(intent);
                break;
            case R.id.btn_share:
                ShareUtil.shareText(this,mQa.getQaIntr());
                break;
            case R.id.btn_like:
                ToastUtil.showShort(this, "like");
                break;
            default:
                break;
        }
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
            ToastUtil.showShort(QaDetailActivity.this,"Thank you for share it");
        }else if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
