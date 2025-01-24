package com.socialPeople.webredsocial.reaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.reaction.dto.Reaction;
import com.socialPeople.webredsocial.reaction.repository.ReactionRepository;

@Service
public class ReactionService {

    private final ReactionRepository reactionRepository;

    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    // Get all Reactions
    public List<Reaction> getAllReactions() {
        return reactionRepository.findAllRepository();
    }

    // Get Reaction by id
    public Reaction getReactionById(String id) {
        return reactionRepository.findByIdRepository(id);
    }

    // Update Reaction
    public Reaction updateReaction(String id, Reaction updatedReaction) {
        Reaction existingReaction = reactionRepository.updateReactionById(id, updatedReaction);
        return existingReaction;
    }

    // Delete Reaction
    public void deleteReaction(String id) {
        reactionRepository.deleteByIdRepository(id);
    }

    // Create Reaction
    public Reaction createReaction(Reaction newReaction) {
        return reactionRepository.createReaction(newReaction);
    }

}
