package com.socialPeople.webredsocial.userTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import com.socialPeople.webredsocial.user.controller.UserController;
import com.socialPeople.webredsocial.user.dto.User;
import com.socialPeople.webredsocial.user.service.UserService;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTestUnit3 {

    @Mock
    private UserService userService;
    private UserController userController;

    private User user;
    private String id;

    @BeforeEach
    public void setup() {
        userController = new UserController(userService);
        user = new User("jose", "joseVillalva@hotmail.com", "745856", "123",
                "Bolivia", null);
        id = "1";
    }

    // --main stage--

    // 1: case happy
    @Test
    void putMethodName_theChangesOfUserIsSuccessfully() {

        User updateUser = user;
        when(userService.userServiceUpdate(id, updateUser)).thenReturn(updateUser);

        ResponseEntity<User> response = userController.putMethodName(id, updateUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updateUser, response.getBody());
        Mockito.verify(userService, Mockito.times(1)).userServiceUpdate(id, updateUser);
    }

    // 2:case empty

    @Test
    void putMethodName_WhenUsersServerReturn_EmptyList() {

        User updateUser = new User();// empty contructor
        when(userService.userServiceUpdate(id, updateUser)).thenReturn(updateUser);

        ResponseEntity<User> response = userController.putMethodName(id, updateUser);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertTrue(updateUser == response.getBody());
        Mockito.verify(userService, Mockito.times(1)).userServiceUpdate(id, updateUser);
    }

    // 3:case null

    @Test
    void putMethodName_WhenUsersServerReturn_Null() {
        User userUpdate = null;
        // Arrange
        when(userService.userServiceUpdate(id, userUpdate)).thenReturn(userUpdate);

        // Act
        ResponseEntity<User> response = userController.putMethodName(id, userUpdate);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        Mockito.verify(userService, Mockito.times(1)).userServiceUpdate(id, userUpdate);
    }

    // 4: edge condition

    @Test
    void putMethodName_WhenTheBorderIsMaxAndMinCharacter() {

        User userCharacter = user;
        userCharacter.setName(String.valueOf(new char[1000]));
        userCharacter.setPhone(String.valueOf(new char[1000]));
        when(userService.userServiceUpdate(id, userCharacter)).thenReturn(userCharacter);

        ResponseEntity<User> response = userController.putMethodName(id, userCharacter);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).userServiceUpdate(id, userCharacter);
    }

    // --code behavior--

    // 5:exceptions

    @Test
    void putMethodName_WhenUserServiceThrowsException_ReturnsInternalServerError() {

        when(userService.userServiceUpdate(id, user))
                .thenThrow(new RuntimeException("Error al obtener usuarios"));

        ResponseEntity<User> response = userController.putMethodName(id, user);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).userServiceUpdate(id, user);
    }

    // 6:execution flow

    @Test
    void putMethodName_ExecutionFlowAtLeastOneTime() {

        when(userService.userServiceUpdate(id, user)).thenReturn(user);

        userController.putMethodName(id, user);

        Mockito.verify(userService, Mockito.atLeastOnce()).userServiceUpdate(id, user);
    }

    // 7:collaterals effects

    @Test
    void putMethodName_WhenifItHasCollateralsEffects() {
        // Arrange
        when(userService.userServiceUpdate(id, user)).thenReturn(user);

        // Act
        userController.putMethodName(id, user);

        // Assert
        // Ensure no unexpected method calls are made
        Mockito.verifyNoMoreInteractions(userService);
    }

    // 8:expected return

    @Test
    void putMethodName_WhenReturnTheTypeAndFormat() {

        when(userService.userServiceUpdate(id, user)).thenReturn(user);

        ResponseEntity<User> response = userController.putMethodName(id, user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof User);
        assertEquals(user, response.getBody());

        Mockito.verify(userService, Mockito.times(1)).userServiceUpdate(id, user);
    }
}
