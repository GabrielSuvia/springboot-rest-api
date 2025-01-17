package com.socialPeople.webredsocial.auth.repository;

import com.socialPeople.webredsocial.auth.dto.Auth;
import com.socialPeople.webredsocial.user.dto.User;

public class AuthRepository {
    private Auth userRepo = new Auth("hello.app@hotmail.com", "6595269");

    public Auth createUserRepository(User userCreate) {

        Auth user = userRepo;// db
        return user;
    }

    public Auth userSignIn(Auth userIn) {
        Auth userAuth = userRepo;
        return userAuth;
    }
}
