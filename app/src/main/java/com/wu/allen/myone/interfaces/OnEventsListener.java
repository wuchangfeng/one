package com.wu.allen.myone.interfaces;

/**
 * Created by allen on 2016/7/16.
 */
// for all fragment and if you implements this interface
// you can call the method like share/save/like/comment
public interface OnEventsListener {

    void share();

    void like();

    void save();

    void comment();
}
