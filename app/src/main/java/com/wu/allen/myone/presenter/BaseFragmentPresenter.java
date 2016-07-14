package com.wu.allen.myone.presenter;

import com.wu.allen.myone.view.IBaseView;

/**
 * Created by allen on 2016/7/14.
 */

public class BaseFragmentPresenter {

    private IBaseView mIBaseView;

    public void onAttachView(IBaseView iBaseView){
        mIBaseView = iBaseView;
    }

    public void onCreate(int page){

    }
}
