package com.wu.allen.myone.view;

import com.wu.allen.myone.model.ArticleSave;
import java.util.List;

/**
 * Created by allen on 2016/7/15.
 */

public interface ISaveView extends IBaseView {

    void showLoading();

    void hideLoading();

    void fillData(List<ArticleSave> list);
}
