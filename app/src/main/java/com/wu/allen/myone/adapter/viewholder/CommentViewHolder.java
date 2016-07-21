package com.wu.allen.myone.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Comment;

/**
 * Created by allen on 2016/7/21.
 */

public class CommentViewHolder extends BaseViewHolder<Comment> {

    private static final String TAG = "CommentViewHolder";
    private TextView comment;

    public CommentViewHolder(ViewGroup parent) {
        super(parent,R.layout.item_comment_list);
        comment = $(R.id.tvComment);
    }

    @Override
    public void setData(Comment data) {
        super.setData(data);
        comment.setText(data.getComments());
    }
}
