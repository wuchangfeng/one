package com.wu.allen.myone.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.wu.allen.myone.utils.DateUtil;
import com.wu.allen.myone.utils.DeviceUtil;
import com.wu.allen.myone.utils.ToastUtil;
import java.util.ArrayList;
import java.util.List;

import static com.wu.allen.myone.R.id.recyclerView;
import static com.wu.allen.myone.R.id.toolbar;

/**
 * Created by allen on 2016/7/21.
 */

public class CommentsActivity extends BaseActivity {

    private static final String TAG = "CommentsActivity";
    private List<Comment> comments = new ArrayList<>();
    private String objectId,typeTable,comment;
    private EasyRecyclerView mRecyclerView;
    private CommentAdapter mCommentAdapter;
    private EditText edtComment;
    private Button btnSend;
    private Toolbar mToolbar;

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
        typeTable = intent.getStringExtra("type");
        comment = intent.getStringExtra("comment");
    }

    public void initView(){
        mToolbar = $(toolbar);
        edtComment = $(R.id.edt_comment);
        btnSend = $(R.id.btn_send_comment);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = $(recyclerView);
        mCommentAdapter = new CommentAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapterWithProgress(mCommentAdapter);
        mCommentAdapter.setNoMore(R.layout.view_nomore);
    }

    public void sendBtnListener(View mButton){
        String comments = edtComment.getText().toString();
        if(TextUtils.isEmpty(comments)){
            ToastUtil.showLong(CommentsActivity.this,getResources().getString(R.string.comment_null));
        }else{
            AVObject article = AVObject.createWithoutData(typeTable, objectId);
            AVObject comInsert = new AVObject(comment);
            comInsert.put("name", comments);
            comInsert.put("date", DateUtil.getCurrentDate());
            comInsert.put("phonesource", DeviceUtil.getManufacturer()+DeviceUtil.getModel());
            comInsert.put("dependent", article);
            comInsert.saveInBackground(new SaveCallback() {
                @Override
                public void done(AVException e) {
                    if (e == null) {
                        edtComment.setText("");
                        // refresh recycler
                        QueryComment();
                        // close soft keyborad
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(edtComment.getWindowToken(),0);
                    }
                }
            });
        }
    }

    public void QueryComment(){
        mCommentAdapter.clear();
        AVObject article = AVObject.createWithoutData(typeTable, objectId);
        AVQuery<AVObject> query = new AVQuery<>(comment);
        query.whereEqualTo("dependent", article);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                Comment comment;
                if(e == null){
                    for (AVObject avObject : list) {
                        String com = avObject.getString("name");
                        String date = avObject.getString("date");
                        String phonesource = avObject.getString("phonesource");
                        comment = new Comment(com,date,phonesource);
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
