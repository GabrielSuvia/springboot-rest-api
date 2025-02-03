package com.socialPeople.webredsocial.comment.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public ArrayList<Comment> getAllComm() {
        ArrayList<Comment> listComments = commentRepository.getAllComment();
        return listComments;
    }

    public Comment getCommentById(String id) {
        Comment CommentId = commentRepository.getCommentId(id);
        return CommentId;
    }

    public Comment createComment(Comment commentNew) {
        Comment newComment = commentRepository.CommentCreate(commentNew);
        return newComment;
    }

    public Comment updateComment(String id, Comment commentUpdate) {
        Comment editComment = commentRepository.updatecomment(id, commentUpdate);
        return editComment;
    }

    public Comment deleteComment(String id) {
        Comment comment = commentRepository.deleteRepository(id);
        return comment;
    }

}
