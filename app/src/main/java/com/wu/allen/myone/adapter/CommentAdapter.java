package com.wu.allen.myone.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.adapter.viewholder.CommentViewHolder;
import com.wu.allen.myone.model.Comment;

/**
 * Created by allen on 2016/7/21.
 */

public class CommentAdapter extends RecyclerArrayAdapter<Comment> {

    public CommentAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(parent);
    }
}
