package com.wu.allen.myone.model;

/**
 * Created by allen on 2016/7/21.
 */

public class Comment {

    private String comments;
    private String date;

    public Comment(String comments,String date) {
        this.comments = comments;
        this.date = date;
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
}
