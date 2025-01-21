package com.socialPeople.webredsocial.frienship.dto;

import com.socialPeople.webredsocial.user.dto.User;

public class FriendShip {

    private String state;
    private User user1;
    private User user2;

    public FriendShip() {
    }

    public FriendShip(String state, User user1, User user2) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser1() {
        return this.user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return this.user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

}
