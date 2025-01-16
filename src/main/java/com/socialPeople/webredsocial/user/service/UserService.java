package com.socialPeople.webredsocial.user.service;

import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.user.dto.User;
import com.socialPeople.webredsocial.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public ArrayList<User> getAllusers() {
    try {
      ArrayList<User> user = userRepository.getUser();
      return user;
    } catch (ParseException e) {
      System.out.println("Error al parsear fecha: " + e.getMessage());
      return null; // o devuelve un valor por defecto
    }

  }

  public User getUserServiceId(String id) {
    User userId = userRepository.getUserRepositoryId(id);
    return userId;
  }

  public User userServiceUpdate(String id, User userUpdate) {
    User userUpdated = userRepository.userUpdate(id, userUpdate);
    return userUpdated;
  }

}