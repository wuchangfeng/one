package com.wu.allen.myone.utils;

import java.util.Random;

/**
 * Created by allen on 2016/7/18.
 */
// this clas for generate random number for SuJinViewHolder's likes and comments
// enjoy =_=
public class RanNumUtil {
    public static String genNum() {
        int max=200;
        int min=100;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s+"";
    }
}
