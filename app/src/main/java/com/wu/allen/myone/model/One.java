package com.wu.allen.myone.model;

import java.io.Serializable;

/**
 * Created by allen on 2016/7/14.
 */

public class One implements Serializable {

    private String imgStr;
    private String imgUrl;
    private String imgAuth;
    private String imgDate;

    public One(String imgStr, String imgUrl, String imgAuth, String imgDate) {
        this.imgStr = imgStr;
        this.imgUrl = imgUrl;
        this.imgAuth = imgAuth;
        this.imgDate = imgDate;
    }

    public String getImgStr() {
        return imgStr;
    }

    public One setImgStr(String imgStr) {
        this.imgStr = imgStr;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public One setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getImgAuth() {
        return imgAuth;
    }

    public One setImgAuth(String imgAuth) {
        this.imgAuth = imgAuth;
        return this;
    }

    public String getImgDate() {
        return imgDate;
    }

    public One setImgDate(String imgDate) {
        this.imgDate = imgDate;
        return this;
    }
}
