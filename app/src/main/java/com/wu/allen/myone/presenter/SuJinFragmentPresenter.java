package com.wu.allen.myone.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.wu.allen.myone.model.Article;
import com.wu.allen.myone.ui.activity.ArtDetailActivity;
import com.wu.allen.myone.view.ISuJinView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2016/7/14.
 */

public class SuJinFragmentPresenter extends BaseFragmentPresenter {

    private ISuJinView mSuJinView;
    private List<Article> articles = new ArrayList<>();

    @Override
    public void onCreate(int page) {
        getArticle(page);
    }

    public void onAttachView(ISuJinView iSuJinView) {
        mSuJinView = iSuJinView;
    }

    public void getIntentArticle(Context context,int position){
        Intent intent = new Intent(context, ArtDetailActivity.class);
        intent.putExtra("article", articles.get(position));
        context.startActivity(intent);
    }

    private void getArticle(int page) {
        mSuJinView.showLoading();
        AVQuery<AVObject> query = AVQuery.getQuery("Content");
        query.orderByDescending("index");
        query.setLimit(10);
        query.setSkip(page * 10);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    Article article;
                    for (AVObject avObject : list) {
                        String title = avObject.getString("title");
                        String intr = avObject.getString("intr");
                        String img = avObject.getString("img");
                        String detail = avObject.getString("detail");
                        String objectId = avObject.getObjectId();
                        Integer numLike =avObject.getInt("numlike");
                        article = new Article(title, intr, img, detail,objectId,numLike);
                        articles.add(article);
                    }
                    mSuJinView.hideLoading();
                    mSuJinView.fillData(articles);
                } else {
                    mSuJinView.errorLayoutShow();
                    Log.d("SuJinFragmentPresenter",e.getMessage());
                }
            }
        });
    }

}
