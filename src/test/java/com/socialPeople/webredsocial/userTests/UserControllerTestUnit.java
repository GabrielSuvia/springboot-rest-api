package com.socialPeople.webredsocial.userTests;

import java.util.Map;
import java.util.ArrayList;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.socialPeople.webredsocial.user.service.UserService;
import com.socialPeople.webredsocial.user.controller.UserController;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.socialPeople.webredsocial.user.dto.User;
import org.springframework.security.test.context.support.WithMockUser;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTestUnit {

  @Mock
  private UserService userService;
  private UserController userController;

  @BeforeEach
  public void setup() {
    userController = new UserController(userService);
  }

  // --main stage--

  // 1: case happy
  @Test
  void getUsers_ReturnAllUsers() {
    // happy
    ArrayList<User> listUser = new ArrayList<>();
    listUser.add(new User());
    listUser.add(new User());
    when(userService.getAllusers()).thenReturn(listUser);

    // act
    ResponseEntity<Map<String, Object>> response = userController.getUsers();

    // asert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(listUser, response.getBody());
    Mockito.verify(userService, Mockito.times(1)).getAllusers();
  }

  // 2:case empty

  @Test
  void getUsers_WhenUsersServerReturn_EmptyList() {

    ArrayList<User> listUser = new ArrayList<>();
    when(userService.getAllusers()).thenReturn(listUser);

    ResponseEntity<Map<String, Object>> response = userController.getUsers();

    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    assertTrue(response.getBody().isEmpty());
    Mockito.verify(userService, Mockito.times(1)).getAllusers();
  }

  // 3:case null

  @Test
  void getUsers_WhenUsersServerReturn_Null() {
    // Arrange
    when(userService.getAllusers()).thenReturn(null);

    // Act
    ResponseEntity<Map<String, Object>> response = userController.getUsers();

    // Assert
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    assertNull(response.getBody());
    Mockito.verify(userService, Mockito.times(1)).getAllusers();
  }

  // 4: edge condition

  @Test
  void getUsers_WhenTheBorderIsMaxAndMin() {

    ArrayList<User> maxUsers = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      maxUsers.add(new User());
    }
    when(userService.getAllusers()).thenReturn(maxUsers);

    ResponseEntity<Map<String, Object>> response = userController.getUsers();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(maxUsers, response.getBody());
    Mockito.verify(userService, Mockito.times(1)).getAllusers();
  }

  // --code behavior--

  // 5:exceptions

  @Test
  void getUsers_WhenUserServiceThrowsException_ReturnsInternalServerError() {

    when(userService.getAllusers()).thenThrow(new RuntimeException("Error al obtener usuarios"));

    ResponseEntity<Map<String, Object>> response = userController.getUsers();

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertNull(response.getBody());
    Mockito.verify(userService, Mockito.times(1)).getAllusers();
  }

  // 6:execution flow

  @Test
  void getUsers_ExecutionFlowAtLeastOneTime() {

    ArrayList<User> listUser = new ArrayList<>();
    listUser.add(new User());
    listUser.add(new User());
    when(userService.getAllusers()).thenReturn(listUser);

    userController.getUsers();

    Mockito.verify(userService, Mockito.atLeastOnce()).getAllusers();
  }

  // 7:collaterals effects

  @Test
  void getUsers_WhenifItHasCollateralsEffects() {
    // Arrange
    ArrayList<User> listUser = new ArrayList<>();
    listUser.add(new User());
    when(userService.getAllusers()).thenReturn(listUser);

    // Act
    userController.getUsers();

    // Assert
    // Ensure no unexpected method calls are made
    Mockito.verifyNoMoreInteractions(userService);
  }

  // 8:expected return

  @Test
  void getUsers_WhenReturnTheTypeAndFormat() {

    ArrayList<User> listUser = new ArrayList<>();
    listUser.add(new User("jose", "joseVillalva@hotmail.com", "745856", "123", "Bolivia", null));
    when(userService.getAllusers()).thenReturn(listUser);

    ResponseEntity<Map<String, Object>> response = userController.getUsers();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(response.getBody().get("Users") instanceof ArrayList);
    assertEquals(listUser, response.getBody().get("users"));
    @SuppressWarnings("unchecked")
    ArrayList<User> arrUsers = (ArrayList<User>) response.getBody().get("users");
    assertEquals(1, arrUsers.size());
    Mockito.verify(userService, Mockito.times(1)).getAllusers();
  }

}
