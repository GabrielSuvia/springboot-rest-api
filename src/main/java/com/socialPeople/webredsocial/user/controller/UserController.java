package com.socialPeople.webredsocial.user.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.socialPeople.webredsocial.user.User;
import com.socialPeople.webredsocial.user.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user") // Ruta base del controlador
public class UserController {
    private UserService userService;
    // Maneja las solicitudes POST a /entrada/enviar

    public UserController(UserService userService){
          this.userService = userService;
    }
   //Get of all users
    @GetMapping("/get")
    @ResponseBody  
    public ResponseEntity<Map<String, Object>> getUsers() {
        // Procesa el mensaje recibido y lo devuelve
        ArrayList<User> user = this.userService.getAllusers();

       Map<String, Object> response = new HashMap<>();
    response.put("users", user);
        return ResponseEntity
         .status(HttpStatus.OK)
        .header("Content-Type", "application/json")
        .body(response);
    }
       //Get an specific user
    /*
 @GetMapping("/info")
    @ResponseBody
    public String informacion() {
        // Procesa el mensaje recibido y lo devuelve
        return "Mensaje 2 recibido: ";
    }
*/
      //Register of User

      
      //update of user

}
