package com.socialPeople.webredsocial.commentTest;

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
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.http.HttpStatus;
import com.socialPeople.webredsocial.comment.controller.CommentController;
import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.service.CommentService;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommentControllerTestUnit1 {
    @Mock
    private CommentService commentService;
    private CommentController commentController;

    private Comment comment;

    @BeforeEach
    public void setup() {
        commentController = new CommentController(commentService);
        comment = new Comment("the best post", null);
    }

    // 1
    @Test
    public void getAllComments_ReturnListCommentsWithSuccesfull() {
        ArrayList<Comment> commentList = new ArrayList<Comment>();
        commentList.add(comment);
        commentList.add(comment);

        when(commentService.getAllComm()).thenReturn(commentList);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(commentList, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getAllComm();
    }

    // 2
    @Test
    void getAllComments_WhenUsersServerReturn_EmptyList() {

        ArrayList<Comment> listComment = new ArrayList<Comment>();
        when(commentService.getAllComm()).thenReturn(listComment);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(0, response.getBody().size());
        assertTrue(response.getBody() == listComment);
        Mockito.verify(commentService, Mockito.times(1)).getAllComm();
    }

    // 3

    @Test
    void getAllComments_WhenUsersServerReturn_Null() {
        // Arrange
        when(commentService.getAllComm()).thenReturn(null);

        // Act
        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        // Assert
        assertNull(response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getAllComm();
    }

    // 4

    @Test
    void getAllComments_WhenTheBorderIsMaxAndMin() {

        ArrayList<Comment> maxComments = new ArrayList<Comment>();
        for (int i = 0; i < 10000; i++) {
            maxComments.add(comment);
        }
        when(commentService.getAllComm()).thenReturn(maxComments);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(maxComments, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getAllComm();
    }

    // 5

    @Test
    void getAllComments_WhenUserServiceThrowsException() {

        when(commentService.getAllComm()).thenThrow(new RuntimeException("Error al obtener usuarios"));

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(commentService, Mockito.times(1)).getAllComm();
    }

    // 6

    @Test
    void getAllComments_ExecutionFlowAtLeastOneTime() {

        ArrayList<Comment> listComments = new ArrayList<>();
        listComments.add(comment);
        listComments.add(comment);
        when(commentService.getAllComm()).thenReturn(listComments);

        commentController.getAllComments();

        Mockito.verify(commentService, Mockito.atLeastOnce()).getAllComm();
    }

    // 7

    @Test
    void getAllComments_WhenifItHasCollateralsEffects() {
        // Arrange
        ArrayList<Comment> listComment = new ArrayList<Comment>();
        listComment.add(comment);
        when(commentService.getAllComm()).thenReturn(listComment);

        // Act
        commentController.getAllComments();

        // Assert
        // Ensure no unexpected method calls are made
        Mockito.verifyNoMoreInteractions(commentService);
    }

    // 8

    @Test
    void getAllComments_WhenReturnTheTypeAndFormat() {

        ArrayList<Comment> listComment = new ArrayList<>();
        listComment.add(comment);
        when(commentService.getAllComm()).thenReturn(listComment);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ArrayList);
        assertEquals(1, response.getBody().size());
        Mockito.verify(commentService, Mockito.times(1)).getAllComm();
    }

}
