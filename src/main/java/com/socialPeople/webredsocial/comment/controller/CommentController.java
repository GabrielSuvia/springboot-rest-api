package com.socialPeople.webredsocial.comment.controller;

import java.util.ArrayList;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialPeople.webredsocial.comment.dto.Comment;
import com.socialPeople.webredsocial.comment.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    // Servicio de comentarios
    private CommentService commentService;

    // Constructor
    // @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Obtener todos los comentarios
    @GetMapping("/getComments")
    public ResponseEntity<ArrayList<Comment>> getAllComments() {
        ArrayList<Comment> comments = this.commentService.getAllComm();
        System.out.println(comments);
        return ResponseEntity.ok(comments);

    }

    // Obtener un comentario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable String id) {
        Comment comment = this.commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    // Crear un nuevo comentario
    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment newComment = this.commentService.createComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    // Actualizar un comentario
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable String id, @RequestBody Comment comment) {
        Comment updatedComment = this.commentService.updateComment(id, comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    // Eliminar un comentario
    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable String id) {
        Comment comment = this.commentService.deleteComment(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
