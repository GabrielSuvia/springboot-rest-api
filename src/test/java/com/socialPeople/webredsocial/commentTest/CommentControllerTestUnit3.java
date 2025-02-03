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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import com.socialPeople.webredsocial.comment.controller.CommentController;
import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.service.CommentService;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommentControllerTestUnit3 {
    @Mock
    private CommentService commentService;
    private CommentController commentController;

    private Comment comment;

    @BeforeEach
    public void setup() {
        commentController = new CommentController(commentService);
        comment = new Comment("the best post", null);
    }

    @Test
    public void createComment_ReturnListCommentsWithSuccesfull() {
        Comment comme = comment;
        when(commentService.createComment(comme)).thenReturn(comme);

        ResponseEntity<Comment> response = commentController.createComment(comme);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(comme, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).createComment(comme);
    }

    @Test
    void createComment_WhenUsersServerReturn_EmptyList() {

        Comment Comment = new Comment(null, null);
        when(commentService.createComment(Comment)).thenReturn(Comment);

        ResponseEntity<Comment> response = commentController.createComment(Comment);

        assertTrue(response.getBody() == Comment);
        Mockito.verify(commentService, Mockito.times(1)).createComment(Comment);
    }

    @Test
    void createComment_WhenUsersServerReturn_Null() {
        // Arrange
        when(commentService.createComment(comment)).thenReturn(null);

        // Act
        ResponseEntity<Comment> response = commentController.createComment(comment);

        // Assert
        assertNull(response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).createComment(comment);
    }

    @Test
    void createComment_WhenUserServiceThrowsException() {

        when(commentService.createComment(comment)).thenThrow(new RuntimeException("Error al crear comentario"));

        ResponseEntity<Comment> response = commentController.createComment(comment);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(commentService, Mockito.times(1)).createComment(comment);
    }

    @Test
    void createComment_ExecutionFlowAtLeastOneTime() {

        Comment Comments = comment;

        when(commentService.createComment(Comments)).thenReturn(Comments);

        commentController.createComment(Comments);
        Mockito.verify(commentService, Mockito.atLeastOnce()).createComment(Comments);
    }

    @Test
    void createComment_WhenReturnTheTypeAndFormat() {

        Comment Comment = comment;
        when(commentService.createComment(Comment)).thenReturn(Comment);

        ResponseEntity<Comment> response = commentController.createComment(Comment);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody() instanceof Comment);
        Mockito.verify(commentService, Mockito.times(1)).createComment(Comment);
    }
}
