package com.wu.allen.myone.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by allen on 2016/8/2.
 */

public class DateUtil {
    /**
     * 获取如 2016-08-08 格式日期
     * @return
     */
    public static String getCurrentDate(){
        Calendar now = Calendar.getInstance();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }
}
