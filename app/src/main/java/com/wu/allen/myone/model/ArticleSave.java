package com.wu.allen.myone.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Created by allen on 2016/7/15.
 */

public class ArticleSave extends RealmObject implements Serializable{
    @PrimaryKey
    private String title;
    private String intr;
    private String img;
    private String detail;

    public String getTitle() {
        return title;
    }

    public ArticleSave setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIntr() {
        return intr;
    }

    public ArticleSave setIntr(String intr) {
        this.intr = intr;
        return this;
    }

    public String getImg() {
        return img;
    }

    public ArticleSave setImg(String img) {
        this.img = img;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public ArticleSave setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
