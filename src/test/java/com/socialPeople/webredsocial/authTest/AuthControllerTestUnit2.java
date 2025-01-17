package com.socialPeople.webredsocial.authTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.socialPeople.webredsocial.auth.controller.AuthController;
import com.socialPeople.webredsocial.auth.dto.Auth;
import com.socialPeople.webredsocial.auth.service.AuthService;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuthControllerTestUnit2 {

    @Mock
    private AuthService authService;
    private AuthController authController;

    private Auth auth;

    public AuthControllerTestUnit2(AuthController authController) {
        this.authController = new AuthController(authService);
    }

    @BeforeEach
    public void setup() {
        authController = new AuthController(authService);
        auth = new Auth("hello@hotmail.com", "355852");

    }

    @Test
    public void signIn_ReturnTheResponseSuccessfully() {
        Auth authUser = auth;

        when(authService.signInService(auth)).thenReturn(authUser);

        ResponseEntity<Auth> response = this.authController.signIn(authUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(authUser, response.getBody());
        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

    @Test
    public void signIn_ReturnEmptyLikeResponse() {
        Auth authUser = new Auth();
        when(authService.signInService(auth)).thenReturn(authUser);

        ResponseEntity<Auth> response = this.authController.signIn(auth);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(authUser, response.getBody());
        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

    @Test
    public void signIn_ReturnNullLikeResponse() {
        Auth authUser = null;
        when(authService.signInService(auth)).thenReturn(authUser);

        ResponseEntity<Auth> response = this.authController.signIn(auth);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(authUser, response.getBody());
        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

    @Test
    public void signIn_VerifyingLoad() {
        when(authService.signInService(auth)).thenThrow(new RuntimeException("Error to create the user"));

        ResponseEntity<Auth> response = this.authController.signIn(auth);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

    @Test
    public void signIn_WhenTheCharacterHasTheMax() {
        auth.setEmail(String.valueOf(new char[1000]));
        auth.setPassword(String.valueOf(new char[1000]));
        when(authService.signInService(auth)).thenReturn(auth);

        ResponseEntity<Auth> response = this.authController.signIn(auth);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

    @Test
    public void signIn_ReturnAnException() {
        when(authService.signInService(auth)).thenThrow(new RuntimeException("Error to create the user"));

        ResponseEntity<Auth> response = this.authController.signIn(auth);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

    @Test
    public void signIn_ExecutionFlowAtLeastOneTime() {
        Auth authUser = auth;
        when(authService.signInService(auth)).thenReturn(authUser);

        authController.signIn(auth);

        Mockito.verify(authService, Mockito.atLeastOnce()).signInService(auth);
    }

    @Test
    public void signIn_WhenifItHasCollateralsEffects() {
        // Arrange
        Auth authUser = auth;

        when(authService.signInService(auth)).thenReturn(authUser);

        // Act
        authController.signIn(auth);
        // Assert
        // Ensure no unexpected method calls are made
        Mockito.verifyNoMoreInteractions(authService);
    }

    @Test
    void signIn_WhenReturnTheTypeAndFormat() {
        Auth authUser = auth;
        when(authService.signInService(auth)).thenReturn(authUser);

        ResponseEntity<Auth> response = authController.signIn(auth);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof Auth);

        Mockito.verify(authService, Mockito.times(1)).signInService(auth);
    }

}
