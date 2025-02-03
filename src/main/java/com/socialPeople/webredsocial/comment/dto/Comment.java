package com.socialPeople.webredsocial.comment.dto;

import java.time.LocalDate;

public class Comment {

    private String content;
    private LocalDate date;

    public Comment(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setContent(String contents) {
        this.content = contents;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
