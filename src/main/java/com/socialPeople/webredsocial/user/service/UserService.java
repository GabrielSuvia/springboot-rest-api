package com.socialPeople.webredsocial.user.service;

import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.user.dto.User;
import com.socialPeople.webredsocial.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public ArrayList<User> getAllusers() {
    ArrayList<User> user = userRepository.getUser();
    return user;

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