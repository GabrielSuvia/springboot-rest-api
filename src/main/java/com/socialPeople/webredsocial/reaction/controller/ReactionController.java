package com.socialPeople.webredsocial.reaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialPeople.webredsocial.reaction.dto.Reaction;
import com.socialPeople.webredsocial.reaction.service.ReactionService;

@RestController
@RequestMapping("/Reaction")

public class ReactionController {

    private ReactionService reactionService;

    // Get all Reactions

    @GetMapping
    public ResponseEntity<List<Reaction>> getAllReactions() {
        List<Reaction> Reactions = reactionService.getAllReactions();
        return ResponseEntity.ok(Reactions);
    }

    // Get Reaction by id

    @GetMapping("/{id}")
    public ResponseEntity<Reaction> getReactionById(@PathVariable String id) {
        Reaction Reaction = reactionService.getReactionById(id);
        if (Reaction != null) {
            return ResponseEntity.ok(Reaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update Reaction

    @PutMapping("/{id}")
    public ResponseEntity<Reaction> updateReaction(@PathVariable String id, @RequestBody Reaction Reaction) {
        Reaction updatedReaction = reactionService.updateReaction(id, Reaction);
        if (updatedReaction != null) {
            return ResponseEntity.ok(updatedReaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Reaction

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable String id) {
        reactionService.deleteReaction(id);
        return ResponseEntity.noContent().build();
    }

    // Create Reaction

    @PostMapping
    public ResponseEntity<Reaction> createReaction(@RequestBody Reaction Reaction) {
        Reaction newReaction = reactionService.createReaction(Reaction);
        return ResponseEntity.ok(newReaction);
    }

}
