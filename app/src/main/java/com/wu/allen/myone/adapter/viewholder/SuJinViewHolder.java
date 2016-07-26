package com.wu.allen.myone.adapter.viewholder;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Article;
import com.wu.allen.myone.ui.activity.CommentsActivity;
import com.wu.allen.myone.utils.RanNumUtil;
import com.wu.allen.myone.utils.ToastUtil;

/**
 * Created by allen on 2016/7/14.
 */

public class SuJinViewHolder extends BaseViewHolder<Article>{

    private static final String TAG = "SuJinViewHolder";
    private TextView title;
    private ImageView img;
    private TextView date;
    private TextView like;
    private TextView comment;
    private Button btnLike,btnComment;

    public SuJinViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article_list);
        title = $(R.id.tv_title);
        img = $(R.id.iv_cover);
        date = $(R.id.tv_date);
        like = $(R.id.tv_like);
        comment = $(R.id.tv_comment);
        btnLike = $(R.id.btn_like);
        btnComment = $(R.id.btn_comment);
    }

    @Override
    public void setData(final Article article){
        date.setText(article.getIntr());
        title.setText(article.getTitle());
        like.setText(article.getNumlike()+"");
        comment.setText(RanNumUtil.genNum()+"");
        Picasso.with(getContext())
            .load(article.getImg())
            .noFade()
            .into(img);
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AVObject likeNum = AVObject.createWithoutData("Content", article.getObjectId());
                likeNum.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        likeNum.increment("numlike");
                        likeNum.setFetchWhenSave(true);
                        likeNum.saveInBackground();
                        btnLike.setBackgroundResource(R.drawable.ic_thumb_up_red_24dp);
                        like.setText(article.getNumlike()+"");
                        ToastUtil.showLong(getContext(),"like!");
                    }
                });
            }
        });
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommentsActivity.class);
                intent.putExtra("objectId",article.getObjectId());
                getContext().startActivity(intent);
            }
        });
    }
}
