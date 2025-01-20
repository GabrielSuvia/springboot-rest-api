package com.socialPeople.webredsocial.comment.dto;

import java.util.Date;

public class Comment {

    private String content;
    private Date date;

    public Comment(String content, Date date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public Date getDate() {
        return this.date;
    }

    public void setContent(String contents) {
        this.content = contents;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
