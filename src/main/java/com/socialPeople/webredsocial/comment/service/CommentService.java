package com.socialPeople.webredsocial.comment.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.repository.CommentRepository;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> listComments = this.commentRepository.getAllComment();
        return listComments;
    }

    public Comment getCommentById(String id) {
        Comment CommentId = this.commentRepository.getCommentId(id);
        return CommentId;
    }

    public Comment createComment(Comment commentNew) {
        Comment newComment = this.commentRepository.CommentCreate(commentNew);
        return newComment;
    }

    public Comment updateComment(String id, Comment commentUpdate) {
        Comment editComment = this.commentRepository.updatecomment(id, commentUpdate);
        return editComment;
    }

    public void deleteComment(String id) {
        this.commentRepository.deleteRepository(id);

    }

}
