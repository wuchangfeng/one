package com.wu.allen.myone.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.adapter.viewholder.SaveViewHolder;
import com.wu.allen.myone.model.ArticleSave;

/**
 * Created by allen on 2016/7/15.
 */

public class SaveAdapter extends RecyclerArrayAdapter<ArticleSave> {

    public SaveAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new SaveViewHolder(parent);
    }
}
