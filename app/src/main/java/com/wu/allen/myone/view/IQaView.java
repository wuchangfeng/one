package com.wu.allen.myone.view;

import com.wu.allen.myone.model.Qa;
import java.util.List;

/**
 * Created by allen on 2016/7/15.
 */

public interface IQaView extends IBaseView {

    void showLoading();

    void hideLoading();

    void fillData(List<Qa> list);
}
