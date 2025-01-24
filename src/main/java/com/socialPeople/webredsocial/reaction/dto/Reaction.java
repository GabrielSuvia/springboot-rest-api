package com.socialPeople.webredsocial.reaction.dto;

import com.socialPeople.webredsocial.publication.dto.Publication;
import com.socialPeople.webredsocial.user.dto.User;

public class Reaction {

    private Publication publication;// ????
    private User user;
    private String typeReaction;

    public Reaction() {
    }

    public Reaction(Publication publication, User user, String typeReaction) {
        this.publication = publication;
        this.user = user;
        this.typeReaction = typeReaction;
    }

    public Publication getPublication() {
        return this.publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReaction() {
        return this.typeReaction;
    }

    public void setReaction(String typeReaction) {
        this.typeReaction = typeReaction;
    }
}
