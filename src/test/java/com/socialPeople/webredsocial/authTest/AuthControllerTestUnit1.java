package com.socialPeople.webredsocial.authTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import com.socialPeople.webredsocial.auth.controller.AuthController;
import com.socialPeople.webredsocial.auth.dto.Auth;
import com.socialPeople.webredsocial.auth.service.AuthService;
import com.socialPeople.webredsocial.user.dto.User;

public class AuthControllerTestUnit1 {

    @Mock
    private AuthService authService;
    private AuthController authController;

    private Auth auth;
    private User user;

    public AuthControllerTestUnit1(AuthController authController) {
        this.authController = new AuthController(authService);
    }

    @BeforeEach
    public void setup() {
        authController = new AuthController(authService);
        auth = new Auth("hello@hotmail.com", "355852");
        user = new User("jose", "joseVillalva@hotmail.com", "745856", "123",
                "Bolivia", null);
    }

    public void signUpUser_ReturnTheResponseSuccessfully() {
        Auth authUser = auth;

        when(authService.signUpService(user)).thenReturn(authUser);

        ResponseEntity<Auth> response = this.authController.signIn(authUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(authUser, response.getBody());
        Mockito.verify(authService, Mockito.times(1)).signUpService(user);
    }

    public void signUpUser_ReturnEmptyLikeResponse() {
        Auth authUser = new Auth();
        when(authService.signUpService(user)).thenReturn(authUser);

        ResponseEntity<Auth> response = this.authController.signUpUser(user);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(authUser, response.getBody());
        Mockito.verify(authService, Mockito.times(1)).signUpService(user);
    }

    public void signUpUser_ReturnNullLikeResponse() {
        Auth authUser = null;
        when(authService.signUpService(user)).thenReturn(authUser);

        ResponseEntity<Auth> response = this.authController.signUpUser(user);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(authUser, response.getBody());
        Mockito.verify(authService, Mockito.times(1)).signUpService(user);
    }

    public void signUpUser_ReturnAnException() {
        when(authService.signUpService(user)).thenThrow(new RuntimeException("Error to create the user"));

        ResponseEntity<Auth> response = this.authController.signUpUser(user);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Mockito.verify(authService, Mockito.times(1)).signUpService(user);
    }

    public void signUpService_WhenBorderIsMaxAndMin() {

    }

}
