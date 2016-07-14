package com.wu.allen.myone.view;

import com.wu.allen.myone.model.Article;
import java.util.List;

/**
 * Created by allen on 2016/7/14.
 */

public interface ISuJinView extends IBaseView{

    void showLoading();

    void hideLoading();

    void fillData(List<Article> list);

}
