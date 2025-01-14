package com.socialPeople.webredsocial.user.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.socialPeople.webredsocial.user.dto.User;
import com.socialPeople.webredsocial.user.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user") // Ruta base del controlador
public class UserController {
    private UserService userService;
    // Maneja las solicitudes POST a /entrada/enviar

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get of all users
    @GetMapping("/getUsers")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUsers() {
        ArrayList<User> user = this.userService.getAllusers();
        Map<String, Object> response = new HashMap<>();
        response.put("users", user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(response);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserId(@PathVariable Long id) {
        User user = userService.getUserServiceId(id);
        return ResponseEntity.ok(user);
    }

    // Register of User

    // update of user

}
