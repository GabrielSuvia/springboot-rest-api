package com.socialPeople.webredsocial.publication.dto;

import java.util.ArrayList;
import java.util.Date;

import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.user.dto.User;

public class Publication {
    private User user;
    private String content;
    private Date date;
    private String typePublication;
    private ArrayList<Comment> comments;

    public Publication() {
    }

    public Publication(User user, String content, Date date, String typePublication, ArrayList<Comment> comments) {
        this.user = user;
        this.content = content;
        this.date = date;
        this.typePublication = typePublication;
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypePublication() {
        return typePublication;
    }

    public void setTypePublication(String typePublication) {
        this.typePublication = typePublication;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
