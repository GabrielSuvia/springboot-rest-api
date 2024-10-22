package com.socialPeople.webredsocial.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialPeople.webredsocial.user.User;
import java.text.ParseException;

@Service
public class UserService{
     
     private UserRepository userRepository;

     @Autowired
     public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
     }

    public User getAllusers(){
        try{
      User user = userRepository.getUser();
        return user;
        }catch(ParseException e){
         System.out.println("Error al parsear fecha: " + e.getMessage());
            return null; // o devuelve un valor por defecto
        }
       
    }
}