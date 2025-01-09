package com.socialPeople.webredsocial.userTests;

import com.socialPeople.webredsocial.user.service;
import com.socialPeople.webredsocial.user.controller;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)

public class UserControllerTestUnit {
    
    @Mock private UserService userService;
    private UserController userController;

    @BeforeEach
    public void setup(){
        userController = new UserController(userService);
    }


    @Test
    void getUsers_ReturnAllUsers (){
        //Arrange
        List<User> listUser = Arrays.asList(new User(), new User(), new User());
       when(userService.getAllusers()).thenReturn(listUser);
       //act
       ResponseEntity<List<User>> response = userController.getUsers();

       //asert
       AssertEquals(HttpStatus.Ok, response.getStatusCode());
       AssertEquals(ListUser, response.getBody());
       verify(userService, time(1)).getAllusers();
    }
    @Test
    void getUsers_WhenUsersServerReturn_EmptyList(){

         List<User> listUser = new ArrayList<>();
         when(userService.getAllusers).thenReturn(listUser);
       
         ResponseEntity<List<User>> response = userController.getUsers();

         AssertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
         AssertNull(response.getBody());
         verify(userService, time(1)).getAllusers();
    }

    @Test
   void getUsers_WhenUserServiceThrowsException_ReturnsInternalServerError () {

    when(userService.getAllusers()).thenThrow(new RuntimeException("Error al obtener usuarios"));

    ResponseEntity<List<User>> response = userController.getAllUsers();

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertNull(response.getBody());
    verify(userService, times(1)).getAllusers();
}

}
