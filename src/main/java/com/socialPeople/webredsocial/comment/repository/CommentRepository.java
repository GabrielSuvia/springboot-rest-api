package com.socialPeople.webredsocial.comment.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.socialPeople.webredsocial.comment.dto.Comment;

@Repository
public class CommentRepository {
    private LocalDate date = LocalDate.of(2025, 1, 1);
    // db
    private Comment comment = new Comment("this is good", date);

    public ArrayList<Comment> getAllComment() {
        ArrayList<Comment> listComment = new ArrayList<Comment>();
        listComment.add(comment);
        return listComment;
    }

    public Comment getCommentId(String id) {
        Comment comentId = comment;
        return comentId;
    }

    public Comment CommentCreate(Comment commentNew) {
        Comment createComment = comment;
        return createComment;
    }

    public Comment updatecomment(String id, Comment updateComment) {
        Comment commentEdited = comment;
        return commentEdited;
    }

    public Comment deleteRepository(String id) {
        return comment;
    }
}
