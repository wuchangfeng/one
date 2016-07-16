package com.wu.allen.myone.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.adapter.viewholder.OneImgViewHolder;
import com.wu.allen.myone.model.One;

/**
 * Created by allen on 2016/7/15.
 */

public class OneImgAdapter extends RecyclerArrayAdapter<One> {

    public OneImgAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OneImgViewHolder(parent);
    }
}
