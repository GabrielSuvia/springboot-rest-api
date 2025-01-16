package com.socialPeople.webredsocial.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.auth.dto.Auth;
import com.socialPeople.webredsocial.auth.repository.AuthRepository;
import com.socialPeople.webredsocial.user.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthService {
    private AuthRepository authRepository;

    public Auth signUpService(User userCreate) {
        Auth user = this.authRepository.createUserRepository(userCreate);
        return user;
    }
}
