package com.wu.allen.myone.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.wu.allen.myone.R;
import com.wu.allen.myone.adapter.SaveAdapter;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.model.ArticleSave;
import com.wu.allen.myone.utils.ToastUtil;
import com.wu.allen.myone.view.ISaveView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import java.util.List;

import static com.wu.allen.myone.R.id.recyclerView;

/**
 * Created by allen on 2016/7/15.
 */

public class SaveArtActivity extends BaseActivity implements ISaveView {

    private static final String TAG = "SaveArtActivity";
    private EasyRecyclerView mRecyclerView;
    private SaveAdapter mSaveAdapter;
    private Realm mRealm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articlesave_layout);
        SwipeBackHelper.onCreate(this);
        initView();
        QueryArticle();
    }

    private void initView(){
        Toolbar toolbar = $(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = $(recyclerView);
        mSaveAdapter = new SaveAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapterWithProgress(mSaveAdapter);
        mSaveAdapter.setNoMore(R.layout.view_nomore);
        mSaveAdapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemClick(int position) {
                DeleteArticle(position);// need in front of remove() method
                mSaveAdapter.remove(position);
                ToastUtil.showLong(SaveArtActivity.this,"Delete success!");
                return true;
            }
        });
        mSaveAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ToastUtil.showLong(SaveArtActivity.this,"Long Click can delete!");
            }
        });
    }

    /**
     * after you long click the item ,the artile you save can delete from realm db
     * @param position
     */
    private void DeleteArticle(final int position){
        mRealm = Realm.getDefaultInstance();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<ArticleSave> results = realm.where(ArticleSave.class)
                    .equalTo("title",mSaveAdapter.getItem(position).getTitle())
                    .findAll();
                results.deleteFirstFromRealm();
                Log.d(TAG,"delete success");
            }
        });
    }

    private void QueryArticle() {
        mRealm = Realm.getDefaultInstance();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmQuery<ArticleSave> query = realm.where(ArticleSave.class);
                RealmResults<ArticleSave> result1 = query.findAll();
                fillData(result1);
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void fillData(List<ArticleSave> list) {
        mSaveAdapter.addAll(list);
        mSaveAdapter.notifyDataSetChanged();
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
        if(mRealm != null)
            mRealm.close();
    }

    @Override
    public void errorLayoutShow() {

    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }
}
