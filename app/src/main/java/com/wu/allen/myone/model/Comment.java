package com.wu.allen.myone.model;

/**
 * Created by allen on 2016/7/21.
 */

public class Comment {

    private String comments;

    public Comment(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public Comment setComments(String comments) {
        this.comments = comments;
        return this;
    }
}
