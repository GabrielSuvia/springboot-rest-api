package com.socialPeople.webredsocial.like.controller;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {
    /*
     * @Autowired
     * private LikeService likeService;
     * 
     * // Get all likes
     * 
     * @GetMapping
     * public ResponseEntity<List<Like>> getAllLikes() {
     * List<Like> likes = likeService.getAllLikes();
     * return ResponseEntity.ok(likes);
     * }
     * 
     * // Get like by id
     * 
     * @GetMapping("/{id}")
     * public ResponseEntity<Like> getLikeById(@PathVariable String id) {
     * Like like = likeService.getLikeById(id);
     * if (like != null) {
     * return ResponseEntity.ok(like);
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     * 
     * // Update like
     * 
     * @PutMapping("/{id}")
     * public ResponseEntity<Like> updateLike(@PathVariable String id, @RequestBody
     * Like like) {
     * Like updatedLike = likeService.updateLike(id, like);
     * if (updatedLike != null) {
     * return ResponseEntity.ok(updatedLike);
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     * 
     * // Delete like
     * 
     * @DeleteMapping("/{id}")
     * public ResponseEntity<Void> deleteLike(@PathVariable String id) {
     * likeService.deleteLike(id);
     * return ResponseEntity.noContent().build();
     * }
     * 
     * // Create like
     * 
     * @PostMapping
     * public ResponseEntity<Like> createLike(@RequestBody Like like) {
     * Like newLike = likeService.createLike(like);
     * return ResponseEntity.ok(newLike);
     * }
     */
    // get all like () //like
    // get id like ( String id) //:id
    // put like/dislike (String like) //:id
    // delete like (String id) //:id
    // add like () //create
}
