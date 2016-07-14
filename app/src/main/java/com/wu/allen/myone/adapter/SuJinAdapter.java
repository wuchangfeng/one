package com.wu.allen.myone.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.model.Article;

/**
 * Created by allen on 2016/7/14.
 */

public class SuJinAdapter extends RecyclerArrayAdapter<Article>{

    public SuJinAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new SuJinViewHolder(parent);
    }
}
