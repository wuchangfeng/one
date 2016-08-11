package com.wu.allen.myone.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.ArticleSave;

/**
 * Created by allen on 2016/7/15.
 */

public class SaveViewHolder extends MyBaseViewHolder<ArticleSave> {

    private static final String TAG = "SuJinViewHolder";
    private TextView tvTitle;
    private ImageView imgCover;
    private TextView tvDate;


    public SaveViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article_list);
        tvTitle = $(R.id.tv_title);
        imgCover = $(R.id.iv_cover);
        tvDate = $(R.id.tv_date);
    }

    @Override
    public void setData(final ArticleSave article){
        tvDate.setText(article.getIntr());
        tvTitle.setText(article.getTitle());
        Glide.with(getContext())
            .load(article.getImg())
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(imgCover);
    }
}
