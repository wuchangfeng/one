package com.wu.allen.myone.model;

import java.io.Serializable;

/**
 * Created by allen on 2016/8/10.
 */

public class Book implements Serializable {
    private String bookAuth;
    private String bookTitle;
    private String bookIntr;
    private String rateNum;
    private String bookRate;
    private String imgUrl;

    public Book(String bookAuth, String bookTitle, String bookIntr, String rateNum, String bookRate, String imgUrl) {
        this.bookAuth = bookAuth;
        this.bookTitle = bookTitle;
        this.bookIntr = bookIntr;
        this.rateNum = rateNum;
        this.bookRate = bookRate;
        this.imgUrl = imgUrl;
    }

    public String getBookAuth() {
        return bookAuth;
    }

    public Book setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
        return this;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Book setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }

    public String getBookIntr() {
        return bookIntr;
    }

    public Book setBookIntr(String bookIntr) {
        this.bookIntr = bookIntr;
        return this;
    }

    public String getRateNum() {
        return rateNum;
    }

    public Book setRateNum(String rateNum) {
        this.rateNum = rateNum;
        return this;
    }

    public String getBookRate() {
        return bookRate;
    }

    public Book setBookRate(String bookRate) {
        this.bookRate = bookRate;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Book setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
