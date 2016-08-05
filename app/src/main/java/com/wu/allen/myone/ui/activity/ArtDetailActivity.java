package com.wu.allen.myone.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.nispok.snackbar.Snackbar;
import com.wu.allen.myone.R;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.model.Article;
import com.wu.allen.myone.model.ArticleSave;
import com.wu.allen.myone.utils.ToastUtil;
import io.realm.Realm;


/**
 * Created by allen on 2016/7/14.
 */

public class ArtDetailActivity extends BaseActivity {

    private static final String TAG = "ArticleDetailActivity";
    private Article mArticle;
    private Intent mIntent;
    private Realm mRealm;
    private ImageView imgCover;
    private TextView tvMainContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articledetail_layout);
        SwipeBackHelper.onCreate(this);
        getData();
        initView();
        loadView();
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }

    public void getData(){
        mIntent = getIntent();
        mArticle = (Article) mIntent.getSerializableExtra("article");
    }

    public void initView(){
        Toolbar toolbar = $(R.id.toolbar);
        imgCover = $(R.id.iv_articlebg);
        tvMainContent = $(R.id.tv_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(mArticle.getTitle());
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveArticle();
            }
        });
    }

    public void SaveArticle(){
        mRealm = Realm.getDefaultInstance();
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                ArticleSave articleSave = bgRealm.createObject(ArticleSave.class);
                articleSave.setDetail(mArticle.getDetail());
                articleSave.setTitle(mArticle.getTitle());
                articleSave.setIntr(mArticle.getIntr());
                articleSave.setImg(mArticle.getImg());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Snackbar.with(getApplicationContext())
                    .text(getString(R.string.save_ok))
                    .show(ArtDetailActivity.this);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Snackbar.with(getApplicationContext())
                    .text(getString(R.string.save_error))
                    .show(ArtDetailActivity.this);
            }
        });

    }

    public void loadView(){
        Glide.with(this)
            .load(mArticle.getImg())
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(imgCover);
        tvMainContent.setText(mArticle.getDetail());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mRealm != null)
            mRealm.close();
        SwipeBackHelper.onDestroy(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_article_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share){
            ToastUtil.showShort(ArtDetailActivity.this,"thank you for share it");
        }else if(id == R.id.action_like){
            ToastUtil.showShort(ArtDetailActivity.this,"thank you for like it");
        }else{
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
