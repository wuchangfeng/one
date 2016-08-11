package com.wu.allen.myone.adapter.viewholder;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Qa;
import com.wu.allen.myone.ui.activity.CommentsActivity;
import com.wu.allen.myone.utils.RanNumUtil;
import com.wu.allen.myone.utils.ToastUtil;

/**
 * Created by allen on 2016/7/15.
 */

public class QaViewHolder extends MyBaseViewHolder<Qa> {

    private static final String TAG = "QaViewHolder";
    private TextView tvQues;
    private TextView tvIntr;
    private TextView tvFocu;
    private TextView tvComment;

    public QaViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_qa_list);
        tvIntr = $(R.id.tv_intr);
        tvQues = $(R.id.tv_ques);
        tvFocu = $(R.id.tv_focu);
        tvComment = $(R.id.tv_comment);
    }

    @Override
    public void setData(final Qa qa){
        String focuFormat = getContext().getResources().getString(R.string.qa_focu);
        String commentFormat = getContext().getResources().getString(R.string.qa_comment);
        tvIntr.setText(qa.getQaIntr().trim());
        tvQues.setText(qa.getQaDetail().trim());
        tvFocu.setText(RanNumUtil.genNum()+focuFormat);
        tvComment.setText(RanNumUtil.genNum()+commentFormat);
        tvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommentsActivity.class);
                intent.putExtra("objectId",qa.getObjectId());
                intent.putExtra("type","OneQa");
                intent.putExtra("comment","QuesCom");
                getContext().startActivity(intent);
            }
        });
        tvFocu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showLong(getContext(),"hello like");
            }
        });
    }
}
