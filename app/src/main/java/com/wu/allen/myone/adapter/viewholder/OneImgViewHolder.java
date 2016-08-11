package com.wu.allen.myone.adapter.viewholder;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.One;
import com.wu.allen.myone.ui.activity.MainActivity;
import com.wu.allen.myone.widget.ImageDialog;

/**
 * Created by allen on 2016/7/15.
 */

public class OneImgViewHolder extends MyBaseViewHolder<One> {

    private static final String TAG = "OneImgViewHolder";
    private TextView tvDate,tvAuthor,tvIntro;
    private ImageView imgBg;

    public OneImgViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_one_list);
        tvDate = $(R.id.tv_date);
        imgBg = $(R.id.iv_cover);
        tvAuthor = $(R.id.tv_author);
        tvIntro = $(R.id.tv_intr);
    }

    @Override
    public void setData(final One one){
        tvDate.setText(one.getImgDate().trim());
        tvAuthor.setText(one.getImgAuth().trim());
        tvIntro.setText(one.getImgStr().trim());
        Glide.with(getContext())
            .load(one.getImgUrl())
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(imgBg);
        imgBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = ((MainActivity)getContext()).getSupportFragmentManager();
                ImageDialog id = new ImageDialog(one.getImgUrl());
                id.show(fm,"img");
            }
        });
    }
}
