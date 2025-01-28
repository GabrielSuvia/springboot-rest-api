package com.socialPeople.webredsocial.comment.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.socialPeople.webredsocial.comment.dto.Comment;

@Repository
public class CommentRepository {

    // db
    private Comment comment = new Comment("hello world", null);

    public ArrayList<Comment> getAllComment() {

        ArrayList<Comment> listComment = new ArrayList<Comment>();
        listComment.add(comment);
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

    public void deleteRepository(String id) {

    }
}
