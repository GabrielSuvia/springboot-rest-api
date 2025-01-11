package com.socialPeople.webredsocial.userTests;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    // Arrange
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
  /*
   * // 2:case empty
   * 
   * @Test
   * void getUsers_WhenUsersServerReturn_EmptyList() {
   * 
   * List<User> listUser = new ArrayList<>();
   * when(userService.getAllusers).thenReturn(listUser);
   * 
   * ResponseEntity<List<User>> response = userController.getUsers();
   * 
   * AssertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
   * AssertNull(response.getBody());
   * verify(userService, time(1)).getAllusers();
   * }
   * 
   * // 3:case null
   * 
   * @Test
   * void getUsers_WhenUsersServerReturn_Null() {
   * // Arrange
   * when(userService.getAllusers()).thenReturn(null);
   * 
   * // Act
   * ResponseEntity<List<User>> response = userController.getUsers();
   * 
   * // Assert
   * assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
   * assertNull(response.getBody());
   * verify(userService, times(1)).getAllusers();
   * }
   * 
   * // 4: edge condition
   * 
   * @Test
   * void getUsers_WhenTheBorderIsMaxAndMin() {
   * 
   * List<User> maxUsers = new ArrayList<>();
   * for (int i = 0; i < 1000; i++) {
   * maxUsers.add(new User());
   * }
   * when(userService.getAllusers()).thenReturn(maxUsers);
   * 
   * ResponseEntity<List<User>> response = userController.getUsers();
   * 
   * assertEquals(HttpStatus.OK, response.getStatusCode());
   * assertEquals(maxUsers, response.getBody());
   * verify(userService, times(1)).getAllusers();
   * }
   * 
   * // --code behavior--
   * 
   * // 5:exceptions
   * 
   * @Test
   * void getUsers_WhenUserServiceThrowsException_ReturnsInternalServerError() {
   * 
   * when(userService.getAllusers()).thenThrow(new
   * RuntimeException("Error al obtener usuarios"));
   * 
   * ResponseEntity<List<User>> response = userController.getAllUsers();
   * 
   * assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
   * assertNull(response.getBody());
   * verify(userService, times(1)).getAllusers();
   * }
   * // 6:execution flow
   * 
   * @Test
   * void getUsers_ExecutionFlowAtLeastOneTime() {
   * 
   * List<User> listUser = Arrays.asList(new User(), new User());
   * when(userService.getAllusers()).thenReturn(listUser);
   * 
   * userController.getUsers();
   * 
   * verify(userService, atLeastOnce()).getAllusers();
   * }
   * 
   * // 7:collaterals effects
   * 
   * @Test
   * void getUsers_WhenifItHasCollateralsEffects() {
   * // Arrange
   * List<User> listUser = Arrays.asList(new User(), new User());
   * when(userService.getAllusers()).thenReturn(listUser);
   * 
   * // Act
   * userController.getUsers();
   * 
   * // Assert
   * // Ensure no unexpected method calls are made
   * verifyNoMoreInteractions(userService);
   * }
   * 
   * // 8:expected return
   * 
   * @Test
   * void getUsers_WhenReturnTheTypeAndFormat() {
   * 
   * List<User> listUser = Arrays.asList(new User("John"), new User("Jane"));
   * when(userService.getAllusers()).thenReturn(listUser);
   * 
   * ResponseEntity<List<User>> response = userController.getUsers();
   * 
   * assertEquals(HttpStatus.OK, response.getStatusCode());
   * assertTrue(response.getBody() instanceof List);
   * assertEquals("John", response.getBody().get(0).getName());
   * assertEquals("Jane", response.getBody().get(1).getName());
   * verify(userService, times(1)).getAllusers();
   * }
   */
}
