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
public class CommentControllerTestUnit4 {
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
    public void updateComment_ReturnListCommentsWithSuccesfull() {
        Comment comme = comment;
        when(commentService.updateComment(id, comme)).thenReturn(comme);

        ResponseEntity<Comment> response = commentController.updateComment(id, comme);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comme, response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).updateComment(id, comme);
    }

    @Test
    void updateComment_WhenUsersServerReturn_EmptyList() {

        Comment Comment = new Comment(null, null);
        when(commentService.updateComment(id, Comment)).thenReturn(Comment);

        ResponseEntity<Comment> response = commentController.updateComment(id, Comment);

        assertTrue(response.getBody() == Comment);
        Mockito.verify(commentService, Mockito.times(1)).updateComment(id, Comment);
    }

    @Test
    void updateComment_WhenUsersServerReturn_Null() {
        // Arrange
        when(commentService.updateComment(id, comment)).thenReturn(null);

        // Act
        ResponseEntity<Comment> response = commentController.updateComment(id, comment);

        // Assert
        assertNull(response.getBody());
        Mockito.verify(commentService, Mockito.times(1)).updateComment(id, comment);
    }

    @Test
    void updateComment_WhenUserServiceThrowsException() {

        when(commentService.updateComment(id, comment))
                .thenThrow(new RuntimeException("Error al actualizar el comentario"));

        ResponseEntity<Comment> response = commentController.updateComment(id, comment);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Mockito.verify(commentService, Mockito.times(1)).updateComment(id, comment);
    }

    @Test
    void updateComment_ExecutionFlowAtLeastOneTime() {

        Comment Comments = comment;

        when(commentService.updateComment(id, Comments)).thenReturn(Comments);

        commentController.updateComment(id, Comments);
        Mockito.verify(commentService, Mockito.atLeastOnce()).updateComment(id, Comments);
    }

    @Test
    void updateComment_WhenReturnTheTypeAndFormat() {

        Comment Comment = comment;
        when(commentService.updateComment(id, Comment)).thenReturn(Comment);

        ResponseEntity<Comment> response = commentController.updateComment(id, Comment);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof Comment);
        Mockito.verify(commentService, Mockito.times(1)).updateComment(id, Comment);
    }
}
