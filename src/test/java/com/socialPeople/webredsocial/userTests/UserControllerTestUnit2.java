package com.socialPeople.webredsocial.userTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.springframework.boot.test.context.SpringBootTest;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTestUnit2 {

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

    @Test
    void getUserId_getTheUserWithId() {
        User userSearch = this.user;
        when(userService.getUserServiceId(id)).thenReturn(userSearch);

        ResponseEntity<User> response = userController.getUserId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userSearch, response.getBody());
        Mockito.verify(userService, Mockito.times(1)).getUserServiceId(id);
    }

    // 2:case empty

    @Test
    void getUserId_WhenUsersServerReturn_EmptyList() {

        User userId = new User();
        when(userService.getUserServiceId(id)).thenReturn(userId);

        ResponseEntity<User> response = userController.getUserId(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(userId, response.getBody());
        assertNotNull(response.getBody());
        assertTrue(response.getBody() == new User());// empty
        Mockito.verify(userService, Mockito.times(1)).getUserServiceId(id);
    }

    // 3:case null

    @Test
    void getUserId_WhenUsersServerReturnNull() {
        User userId = null;
        // Arrange
        when(userService.getUserServiceId(id)).thenReturn(userId);

        // Act
        ResponseEntity<User> response = userController.getUserId(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(userId, response.getBody());
        assertNull(response.getBody());
        Mockito.verify(userService, Mockito.times(1)).getUserServiceId(id);
    }

    // --code behavior--
    // 5:exceptions

    @Test
    void getUserId_WhenUserServiceThrowsException_ReturnsInternalServerError() {
        when(userService.getUserServiceId(id)).thenThrow(new RuntimeException("Error al obtener el usuario"));

        ResponseEntity<User> response = userController.getUserId(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).getAllusers();
    }

    // 6:execution flow

    @Test
    void getUserId_ExecutionFlowAtLeastOneTime() {

        User userId = new User();
        when(userService.getUserServiceId(id)).thenReturn(userId);

        userController.getUserId(id);

        Mockito.verify(userService, Mockito.atLeastOnce()).getUserServiceId(id);
    }
    // collaterals effects

    @Test
    void getUserId_WhenifItHasCollateralsEffects() {
        // Arrange
        User userId = new User();

        when(userService.getUserServiceId(id)).thenReturn(userId);

        // Act
        userController.getUserId(id);
        // Assert
        // Ensure no unexpected method calls are made
        Mockito.verifyNoMoreInteractions(userService);
    }

    // 8:expected return

    @Test
    void getUserId_WhenReturnTheTypeAndFormat() {
        User userId = new User("jose", "joseVillalva@hotmail.com", "745856", "123", "Bolivia", null);
        when(userService.getUserServiceId(id)).thenReturn(userId);

        ResponseEntity<User> response = userController.getUserId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof User);

        Mockito.verify(userService, Mockito.times(1)).getUserServiceId(id);
    }

}
