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
    private CommentController commentController;
    private CommentService commentService;

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

        when(commentService.getAllComments()).thenReturn(commentList);
        // System.out.println("ADADA" + commentService.getAllComments());
        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(commentList, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getAllComments();
    }

    // 2
    @Test
    void getAllComments_WhenUsersServerReturn_EmptyList() {

        ArrayList<Comment> listComment = new ArrayList<Comment>();
        when(commentService.getAllComments()).thenReturn(listComment);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(0, response.getBody().size());
        assertTrue(response.getBody() == listComment);
        Mockito.verify(commentService, Mockito.times(1)).getAllComments();
    }

    // 3

    @Test
    void getAllComments_WhenUsersServerReturn_Null() {
        // Arrange
        when(commentService.getAllComments()).thenReturn(null);

        // Act
        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        // Assert
        assertNull(response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getAllComments();
    }

    // 4

    @Test
    void getAllComments_WhenTheBorderIsMaxAndMin() {

        ArrayList<Comment> maxComments = new ArrayList<Comment>();
        for (int i = 0; i < 10000; i++) {
            maxComments.add(comment);
        }
        when(commentService.getAllComments()).thenReturn(maxComments);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(maxComments, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getAllComments();
    }

    // 5

    @Test
    void getAllComments_WhenUserServiceThrowsException_ReturnsInternalServerError() {

        when(commentService.getAllComments()).thenThrow(new RuntimeException("Error al obtener usuarios"));

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(commentService, Mockito.times(1)).getAllComments();
    }

    // 6

    @Test
    void getAllComments_ExecutionFlowAtLeastOneTime() {

        ArrayList<Comment> listComments = new ArrayList<>();
        listComments.add(comment);
        listComments.add(comment);
        when(commentService.getAllComments()).thenReturn(listComments);

        commentController.getAllComments();

        Mockito.verify(commentService, Mockito.atLeastOnce()).getAllComments();
    }

    // 7

    @Test
    void getAllComments_WhenifItHasCollateralsEffects() {
        // Arrange
        ArrayList<Comment> listComment = new ArrayList<Comment>();
        listComment.add(comment);
        when(commentService.getAllComments()).thenReturn(listComment);

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
        when(commentService.getAllComments()).thenReturn(listComment);

        ResponseEntity<ArrayList<Comment>> response = commentController.getAllComments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ArrayList);
        assertEquals(1, response.getBody().size());
        Mockito.verify(commentService, Mockito.times(1)).getAllComments();
    }

}
