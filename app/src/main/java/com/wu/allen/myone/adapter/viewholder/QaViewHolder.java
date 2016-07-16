package com.wu.allen.myone.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Qa;

/**
 * Created by allen on 2016/7/15.
 */

public class QaViewHolder extends BaseViewHolder<Qa> {

    private static final String TAG = "QaViewHolder";
    private TextView ques;
    private TextView intr;

    public QaViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_qa_list);
        intr = $(R.id.tv_intr);
        ques = $(R.id.tv_ques);
    }

    @Override
    public void setData(final Qa qa){
        intr.setText(qa.getQaIntr().trim());
        ques.setText(qa.getQaDetail().trim());
    }
}
