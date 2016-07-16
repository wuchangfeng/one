package com.wu.allen.myone.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.adapter.viewholder.QaViewHolder;
import com.wu.allen.myone.model.Qa;

/**
 * Created by allen on 2016/7/15.
 */

public class QaAdapter extends RecyclerArrayAdapter<Qa> {

    public QaAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new QaViewHolder(parent);
    }
}
