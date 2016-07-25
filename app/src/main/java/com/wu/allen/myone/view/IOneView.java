package com.wu.allen.myone.view;

import com.wu.allen.myone.model.One;
import java.util.List;

/**
 * Created by allen on 2016/7/15.
 */

public interface IOneView extends IBaseView{

    void showLoading();

    void hideLoading();

    void fillData(List<One> list);
}
