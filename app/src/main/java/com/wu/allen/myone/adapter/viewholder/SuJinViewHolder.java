package com.wu.allen.myone.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Article;

/**
 * Created by allen on 2016/7/14.
 */

public class SuJinViewHolder extends BaseViewHolder<Article>{

    private static final String TAG = "SuJinViewHolder";
    private TextView title;
    private ImageView img;
    private TextView date;


    public SuJinViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article_list);
        title = $(R.id.tv_title);
        img = $(R.id.iv_cover);
        date = $(R.id.tv_date);
    }

    @Override
    public void setData(final Article article){
        date.setText(article.getIntr());
        title.setText(article.getTitle());
        Glide.with(getContext())
            .load(article.getImg())
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(img);
    }
}
