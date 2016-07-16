package com.wu.allen.myone.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by allen on 2016/7/15.
 */

public class ToastUtil {

    // shortTime
    public static void showShort(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

    // LongTime
    public static void showLong(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}
