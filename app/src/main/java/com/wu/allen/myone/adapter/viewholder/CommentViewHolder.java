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
    private TextView tvComment,tvDate,tvPhoneType;

    public CommentViewHolder(ViewGroup parent) {
        super(parent,R.layout.item_comment_list);
        tvComment = $(R.id.tv_comment_detail);
        tvDate = $(R.id.tv_comment_date);
        tvPhoneType = $(R.id.tv_phone_type);
    }

    @Override
    public void setData(Comment data) {
        String phoneType = getContext().getResources().getString(R.string.from);
        super.setData(data);
        tvComment.setText(data.getComments());
        tvDate.setText(data.getDate());
        tvPhoneType.setText(phoneType+data.getPhonesource());
    }
}
