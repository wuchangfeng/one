package com.wu.allen.myone.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.wu.allen.myone.model.Qa;
import com.wu.allen.myone.ui.activity.QaDetailActivity;
import com.wu.allen.myone.view.IQaView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2016/7/15.
 */

public class QaFragmentPresenter extends BaseFragmentPresenter  {


    private IQaView mIQaView;
    private Qa mQa;
    private List<Qa> qas = new ArrayList<>();

    @Override
    public void onCreate(int page) {
        mIQaView.showLoading();
        getArticle(page);
    }

    public void onAttachView(IQaView iqaView) {
        mIQaView = iqaView;
    }

    public void getIntentQa(Context context,int position){
        Intent i = new Intent(context, QaDetailActivity.class);
        i.putExtra("qa", qas.get(position));
        context.startActivity(i);
    }

    private void getArticle(int page) {
        mIQaView.hideLoading();
        AVQuery<AVObject> query = AVQuery.getQuery("OneQa");
        query.orderByDescending("index");
        query.setLimit(10);
        query.setSkip(page * 10);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    Qa qa;
                    for (AVObject avObject : list) {
                        String qaAnsw = avObject.getString("qaAnsw");
                        String qaDetail = avObject.getString("qaDetail");
                        String qaIntr = avObject.getString("qaIntr");
                        qa = new Qa(qaIntr,qaDetail,qaAnsw);
                        qas.add(qa);
                    }
                    mIQaView.fillData(qas);
                } else {
                    mIQaView.errorLayoutShow();
                    Log.d("QaFragmentPresenter",e.getMessage());
                }
            }
        });
    }
}
