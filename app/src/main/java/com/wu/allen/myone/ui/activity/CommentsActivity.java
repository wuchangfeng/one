package com.wu.allen.myone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.wu.allen.myone.R;
import com.wu.allen.myone.adapter.CommentAdapter;
import com.wu.allen.myone.injector.components.AppComponent;
import com.wu.allen.myone.model.Comment;
import com.wu.allen.myone.utils.ToastUtil;
import java.util.ArrayList;
import java.util.List;

import static com.wu.allen.myone.R.id.recyclerView;
import static com.wu.allen.myone.R.id.toolbar;

/**
 * Created by allen on 2016/7/21.
 */

public class CommentsActivity extends BaseActivity {

    private String objectId;
    private EasyRecyclerView mRecyclerView;
    private CommentAdapter mCommentAdapter;
    private EditText mEditText;
    private Button mButton;
    private Toolbar mToolbar;
    private List<Comment> comments = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_layout);
        SwipeBackHelper.onCreate(this);
        initData();
        initView();
        QueryComment();
    }

    public void initData(){
        Intent intent = getIntent();
        objectId = intent.getStringExtra("objectId");
    }

    public void initView(){
        mToolbar = (Toolbar) findViewById(toolbar);
        mEditText = (EditText) findViewById(R.id.edtComment);
        mButton = (Button)findViewById(R.id.btnSendComment);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (EasyRecyclerView) findViewById(recyclerView);
        mCommentAdapter = new CommentAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapterWithProgress(mCommentAdapter);
        mCommentAdapter.setNoMore(R.layout.view_nomore);
    }

    public void sendBtnListener(View mButton){
        String comments = mEditText.getText().toString();
        if(TextUtils.isEmpty(comments)){
            ToastUtil.showLong(CommentsActivity.this,getResources().getString(R.string.comment_null));
        }else{
            AVObject article = AVObject.createWithoutData("Content", objectId);
            AVObject comInsert = new AVObject("Comment");
            comInsert.put("name", comments);
            comInsert.put("dependent", article);
            comInsert.saveInBackground(new SaveCallback() {
                @Override
                public void done(AVException e) {
                    if (e == null) {
                        // clear Edittext after send comment success
                        mEditText.setText("");
                        // TODO: 2016/7/22 bughere 
                    }
                }
            });
        }
    }

    public void QueryComment(){
        AVObject article = AVObject.createWithoutData("Content", objectId);
        AVQuery<AVObject> query = new AVQuery<>("Comment");
        query.whereEqualTo("dependent", article);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                Comment comment;
                if(e == null){
                    for (AVObject avObject : list) {
                        String com = avObject.getString("name");
                        comment = new Comment(com);
                        comments.add(comment);
                    }
                    mCommentAdapter.addAll(comments);
                    mCommentAdapter.notifyDataSetChanged();
                }else{
                    Log.d("comment",e.getMessage());
                }
            }
        });
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
