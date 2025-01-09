package com.socialPeople.webredsocial.userTests;

import com.socialPeople.webredsocial.user.service;

import java.util.ArrayList;
import java.util.List;

import com.socialPeople.webredsocial.user.controller;
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


    }

}
