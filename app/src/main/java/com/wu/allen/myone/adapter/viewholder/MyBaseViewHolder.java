package com.wu.allen.myone.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by allen on 2016/8/11.
 */

public class MyBaseViewHolder<T> extends BaseViewHolder<T> {

    public MyBaseViewHolder(View itemView) {
        super(itemView);
    }

    public MyBaseViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    /**
     * 子类实现该方法用于替代 getResources().getString(id) 以及进行相应的类型检查
     * @param id
     * @return
     */
    protected String getStringById(@StringRes int id) {
        return getContext().getResources().getString(id);
    }
}
