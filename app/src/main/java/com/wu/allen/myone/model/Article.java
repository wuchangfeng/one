package com.wu.allen.myone.model;

import java.io.Serializable;

/**
 * Created by allen on 2016/7/14.
 */

public class Article implements Serializable {

    private String title;
    private String intr;
    private String img;
    private String detail;
    private String objectId;

    public Article(String title, String intr, String img, String detail,String objectId) {
        this.title = title;
        this.intr = intr;
        this.img = img;
        this.detail = detail;
        this.objectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIntr() {
        return intr;
    }

    public Article setIntr(String intr) {
        this.intr = intr;
        return this;
    }

    public String getImg() {
        return img;
    }

    public Article setImg(String img) {
        this.img = img;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Article setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getObjectId() {
        return objectId;
    }

    public Article setObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }
}
