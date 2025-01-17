package com.socialPeople.webredsocial.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialPeople.webredsocial.auth.dto.Auth;
import com.socialPeople.webredsocial.auth.service.AuthService;
import com.socialPeople.webredsocial.user.dto.User;

@RestController
@RequestMapping("/auth")

public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("signup")
    @ResponseBody
    public ResponseEntity<Auth> signUpUser(@RequestBody User userNew) {
        Auth user = this.authService.signUpService(userNew);
        return ResponseEntity.ok(user);
    }

    @PostMapping("signIn")
    @ResponseBody
    public ResponseEntity<Auth> signIn(@RequestBody User userNew) {
        Auth user = this.authService.signUpService(userNew);
        return ResponseEntity.ok(user);
    }

}
