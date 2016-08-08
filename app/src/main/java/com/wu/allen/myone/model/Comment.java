package com.wu.allen.myone.model;

/**
 * Created by allen on 2016/7/21.
 */

public class Comment {

    private String comments;
    private String date;
    private String phonesource;


    public Comment(String comments,String date,String phonesource) {
        this.comments = comments;
        this.date = date;
        this.phonesource = phonesource;
    }

    public String getComments() {
        return comments;
    }

    public Comment setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Comment setDate(String date) {
        this.date = date;
        return this;
    }

    public String getPhonesource() {
        return phonesource;
    }

    public Comment setPhonesource(String phonesource) {
        this.phonesource = phonesource;
        return this;
    }
}
