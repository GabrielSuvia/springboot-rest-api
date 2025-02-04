package com.socialPeople.webredsocial.friendShipTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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

import com.socialPeople.webredsocial.comment.controller.CommentController;
import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.service.CommentService;
import com.socialPeople.webredsocial.frienship.controller.FriendShipController;
import com.socialPeople.webredsocial.frienship.dto.FriendShip;
import com.socialPeople.webredsocial.frienship.service.ServiceFriendShip;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FriendShipControllerTestUnit1 {
    @Mock
    private ServiceFriendShip frienshipService;
    private FriendShipController friendShipController;

    private FriendShip friendShip;

    @BeforeEach
    public void setup() {
        friendShipController = new FriendShipController(frienshipService);

        friendShip = new FriendShip("unFriend", null, null);
    }

    // 1
    @Test
    public void getAllFriendships_ReturnListCommentsWithSuccesfull() {
        ArrayList<FriendShip> friendList = new ArrayList<FriendShip>();
        friendList.add(friendShip);
        friendList.add(friendShip);

        when(frienshipService.getAllFriendships()).thenReturn(friendList);

        ResponseEntity<ArrayList<FriendShip>> response = friendShipController.getAllFriendships();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(friendList, response.getBody());
        Mockito.verify(frienshipService, Mockito.times(1)).getAllFriendships();
    }

    // 2
    @Test
    void getAllFriendships_WhenUsersServerReturn_EmptyList() {

        ArrayList<FriendShip> listFriend = new ArrayList<FriendShip>();
        when(frienshipService.getAllFriendships()).thenReturn(listFriend);

        ResponseEntity<ArrayList<FriendShip>> response = friendShipController.getAllFriendships();

        assertEquals(0, response.getBody().size());
        assertTrue(response.getBody() == listFriend);
        Mockito.verify(frienshipService, Mockito.times(1)).getAllFriendships();
    }

    // 3

    @Test
    void getAllFriendships_WhenUsersServerReturn_Null() {
        // Arrange
        when(frienshipService.getAllFriendships()).thenReturn(null);

        // Act
        ResponseEntity<ArrayList<FriendShip>> response = friendShipController.getAllFriendships();

        // Assert
        assertNull(response.getBody());
        Mockito.verify(frienshipService, Mockito.times(1)).getAllFriendships();
    }

    // 4

    @Test
    void getAllFriendships_WhenTheBorderIsMaxAndMin() {

        ArrayList<FriendShip> maxFriends = new ArrayList<FriendShip>();
        for (int i = 0; i < 10000; i++) {
            maxFriends.add(friendShip);
        }
        when(frienshipService.getAllFriendships()).thenReturn(maxFriends);

        ResponseEntity<ArrayList<FriendShip>> response = friendShipController.getAllFriendships();

        assertEquals(maxFriends, response.getBody());
        Mockito.verify(frienshipService, Mockito.times(1)).getAllFriendships();
    }

    // 5

    @Test
    void getAllFriendships_WhenUserServiceThrowsException() {

        when(frienshipService.getAllFriendships()).thenThrow(new RuntimeException("Error al obtener usuarios"));

        ResponseEntity<ArrayList<FriendShip>> response = friendShipController.getAllFriendships();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(frienshipService, Mockito.times(1)).getAllFriendships();
    }

    // 6

    @Test
    void getAllFriendships_ExecutionFlowAtLeastOneTime() {

        ArrayList<FriendShip> listFriends = new ArrayList<FriendShip>();
        listFriends.add(friendShip);
        listFriends.add(friendShip);
        when(frienshipService.getAllFriendships()).thenReturn(listFriends);

        friendShipController.getAllFriendships();

        Mockito.verify(frienshipService, Mockito.atLeastOnce()).getAllFriendships();
    }

    // 7

    @Test
    void getAllFriendships_WhenifItHasCollateralsEffects() {
        // Arrange
        ArrayList<FriendShip> listFriends = new ArrayList<FriendShip>();
        listFriends.add(friendShip);
        when(frienshipService.getAllFriendships()).thenReturn(listFriends);

        // Act
        friendShipController.getAllFriendships();

        // Assert
        // Ensure no unexpected method calls are made
        Mockito.verifyNoMoreInteractions(frienshipService);
    }

    // 8

    @Test
    void getAllFriendships_WhenReturnTheTypeAndFormat() {

        ArrayList<FriendShip> listFriend = new ArrayList<FriendShip>();
        listFriend.add(friendShip);
        when(frienshipService.getAllFriendships()).thenReturn(listFriend);

        ResponseEntity<ArrayList<FriendShip>> response = friendShipController.getAllFriendships();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ArrayList);
        assertEquals(1, response.getBody().size());
        Mockito.verify(frienshipService, Mockito.times(1)).getAllFriendships();
    }

}
