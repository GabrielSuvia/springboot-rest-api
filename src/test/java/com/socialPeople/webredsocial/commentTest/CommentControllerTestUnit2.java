package com.socialPeople.webredsocial.commentTest;

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
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.http.HttpStatus;
import com.socialPeople.webredsocial.comment.controller.CommentController;
import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.service.CommentService;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommentControllerTestUnit2 {
    @Mock
    private CommentService commentService;
    private CommentController commentController;

    private Comment comment;
    private String id;

    @BeforeEach
    public void setup() {
        commentController = new CommentController(commentService);
        comment = new Comment("the best post", null);
        id = "1";
    }

    @Test
    public void getCommentById_ReturnListCommentsWithSuccesfull() {
        Comment comme = comment;
        when(commentService.getCommentById(id)).thenReturn(comme);

        ResponseEntity<Comment> response = commentController.getCommentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comme, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getCommentById(id);
    }

    @Test
    void getCommentById_WhenUsersServerReturn_EmptyList() {

        Comment Comment = new Comment(null, null);
        when(commentService.getCommentById(id)).thenReturn(Comment);

        ResponseEntity<Comment> response = commentController.getCommentById(id);

        assertTrue(response.getBody() == Comment);
        Mockito.verify(commentService, Mockito.times(1)).getCommentById(id);
    }

    @Test
    void getCommentById_WhenUsersServerReturn_Null() {
        // Arrange
        when(commentService.getCommentById(id)).thenReturn(null);

        // Act
        ResponseEntity<Comment> response = commentController.getCommentById(id);

        // Assert
        assertNull(response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).getCommentById(id);
    }

    @Test
    void getCommentById_WhenUserServiceThrowsException() {

        when(commentService.getCommentById(id)).thenThrow(new RuntimeException("Error al obtener usuarios"));

        ResponseEntity<Comment> response = commentController.getCommentById(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(commentService, Mockito.times(1)).getCommentById(id);
    }

    @Test
    void getCommentById_ExecutionFlowAtLeastOneTime() {

        Comment Comments = comment;

        when(commentService.getCommentById(id)).thenReturn(Comments);

        commentController.getCommentById(id);

        Mockito.verify(commentService, Mockito.atLeastOnce()).getCommentById(id);
    }

    @Test
    void getCommentById_WhenReturnTheTypeAndFormat() {

        Comment Comment = comment;
        when(commentService.getCommentById(id)).thenReturn(Comment);

        ResponseEntity<Comment> response = commentController.getCommentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof Comment);
        Mockito.verify(commentService, Mockito.times(1)).getCommentById(id);
    }

}
