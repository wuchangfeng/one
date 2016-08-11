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
import com.squareup.picasso.Picasso;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Article;
import com.wu.allen.myone.ui.activity.CommentsActivity;
import com.wu.allen.myone.utils.RanNumUtil;
import com.wu.allen.myone.utils.ShareUtil;
import com.wu.allen.myone.utils.ToastUtil;

import static com.wu.allen.myone.R.string.like;

/**
 * Created by allen on 2016/7/14.
 */

public class SuJinViewHolder extends MyBaseViewHolder<Article>{

    private static final String TAG = "SuJinViewHolder";
    private ImageView imgCover;
    private TextView tvComment,tvShare,tvLike,tvDate,tvTitle;
    private Button btnLike,btnComment,btnShare;

    public SuJinViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article_list);
        tvTitle = $(R.id.tv_title);
        imgCover = $(R.id.iv_cover);
        tvDate = $(R.id.tv_date);
        tvLike = $(R.id.tv_like);
        tvComment = $(R.id.tv_comment);
        btnLike = $(R.id.btn_like);
        btnComment = $(R.id.btn_comment);
        btnShare = $(R.id.btn_share);
        tvShare = $(R.id.tv_share);
    }

    @Override
    public void setData(final Article article){
        tvDate.setText(article.getIntr());
        tvTitle.setText(article.getTitle());
        tvLike.setText(article.getNumlike()+"");
        tvComment.setText(RanNumUtil.genNum()+"");
        tvShare.setText(RanNumUtil.genNum()+"");
        Picasso.with(getContext())
            .load(article.getImg())
            .noFade()
            .into(imgCover);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtil.shareText(getContext(),article.getTitle());
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvLike.setText(" "+(article.getNumlike()+1));
                btnLike.setBackgroundResource(R.drawable.ic_thumb_up_red_24dp);
                final AVObject likeNum = AVObject.createWithoutData("Content", article.getObjectId());
                likeNum.put("numlike", article.getNumlike()+1);
                likeNum.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            ToastUtil.showLong(getContext(), getContext().getResources().getString(like));
                        } else {
                            // 模拟一个延时效果
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException s) {
                                s.printStackTrace();
                            }
                            tvLike.setText(" "+(article.getNumlike()));
                            btnLike.setBackgroundResource(R.drawable.ic_thumb_up_24dp);
                            ToastUtil.showLong(getContext(), getContext().getResources().getString(R.string.error_happen));
                        }
                    }
                });
            }
        });
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommentsActivity.class);
                intent.putExtra("objectId",article.getObjectId());
                intent.putExtra("type","Content");
                intent.putExtra("comment","ArticleCom");
                getContext().startActivity(intent);
            }
        });
    }
}
