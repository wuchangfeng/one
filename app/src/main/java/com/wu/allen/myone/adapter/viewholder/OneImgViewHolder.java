package com.wu.allen.myone.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.One;

/**
 * Created by allen on 2016/7/15.
 */

public class OneImgViewHolder extends BaseViewHolder<One> {

    private static final String TAG = "OneImgViewHolder";
    private TextView date;
    private ImageView img;
    private TextView author;
    private TextView intr;

    public OneImgViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_one_list);
        date = $(R.id.tv_date);
        img = $(R.id.iv_cover);
        author = $(R.id.tv_author);
        intr = $(R.id.tv_intr);
    }

    @Override
    public void setData(final One one){
        date.setText(one.getImgDate().trim());
        author.setText(one.getImgAuth().trim());
        intr.setText(one.getImgStr().trim());
        Glide.with(getContext())
            .load(one.getImgUrl())
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(img);
    }
}
