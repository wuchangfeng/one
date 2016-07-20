package com.wu.allen.myone.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Qa;
import com.wu.allen.myone.utils.RanNumUtil;
import com.wu.allen.myone.utils.ToastUtil;

/**
 * Created by allen on 2016/7/15.
 */

public class QaViewHolder extends BaseViewHolder<Qa> {

    private static final String TAG = "QaViewHolder";
    private TextView ques;
    private TextView intr;
    private TextView focu;
    private TextView comment;

    public QaViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_qa_list);
        intr = $(R.id.tv_intr);
        ques = $(R.id.tv_ques);
        focu = $(R.id.tv_focu);
        comment = $(R.id.tv_comment);
    }

    @Override
    public void setData(final Qa qa){
        String focuFormat = getContext().getResources().getString(R.string.qa_focu);
        String commentFormat = getContext().getResources().getString(R.string.qa_comment);
        intr.setText(qa.getQaIntr().trim());
        ques.setText(qa.getQaDetail().trim());
        focu.setText(RanNumUtil.genNum()+focuFormat);
        comment.setText(RanNumUtil.genNum()+commentFormat);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showLong(getContext(),"hello comment");
            }
        });
        focu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showLong(getContext(),"hello like");
            }
        });
    }
}
