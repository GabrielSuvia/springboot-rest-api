package com.socialPeople.webredsocial.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.user.dto.User;
import com.socialPeople.webredsocial.user.repository.UserRepository;

import java.text.ParseException;  
import java.util.ArrayList;

@Service
public class UserService{
     
     private UserRepository userRepository;

     @Autowired
     public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
     }

    public ArrayList<User> getAllusers(){
        try{
          ArrayList<User> user = userRepository.getUser();
        return user;
        }catch(ParseException e){
         System.out.println("Error al parsear fecha: " + e.getMessage());
            return null; // o devuelve un valor por defecto
        }
       
    }
}