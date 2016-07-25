package com.wu.allen.myone.presenter;

import android.util.Log;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.wu.allen.myone.model.One;
import com.wu.allen.myone.view.IOneView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2016/7/15.
 */

public class OneImgFragmentPresenter extends BaseFragmentPresenter  {

    private IOneView mIOneView;
    private List<One> ones = new ArrayList<>();

    @Override
    public void onCreate(int page) {
        mIOneView.showLoading();
        getArticle(page);
    }

    public void onAttachView(IOneView iOneView) {
        mIOneView = iOneView;
    }
    /**
    public Article getIntentArticle(int position){
        return articles.get(position);
    }*/

    private void getArticle(int page) {
        mIOneView.hideLoading();
        AVQuery<AVObject> query = AVQuery.getQuery("OneImg");
        query.orderByDescending("index");
        query.setLimit(10);
        query.setSkip(page * 10);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    One one;
                    for (AVObject avObject : list) {
                        String imgIntr = avObject.getString("imgIntr");
                        String imgUrl = avObject.getString("imgUrl");
                        String imgAuth = avObject.getString("imgAuth");
                        String imgDate = avObject.getString("imgDate");
                        one = new One(imgIntr, imgUrl, imgAuth, imgDate);
                        ones.add(one);
                    }
                    mIOneView.fillData(ones);
                } else {
                    mIOneView.errorLayoutShow();
                    Log.d("OneImgFragmentPresenter",e.getMessage());
                }
            }
        });
    }
}
