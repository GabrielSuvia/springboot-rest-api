package com.socialPeople.webredsocial.reaction.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.socialPeople.webredsocial.reaction.dto.Reaction;

@Repository
public class ReactionRepository {
    private Reaction reaction = new Reaction(null, null, "happy");

    public List<Reaction> findAllRepository() {
        List<Reaction> reactions = new ArrayList<>();
        reactions.add(reaction);
        return reactions;
    }

    public Reaction findByIdRepository(String id) {
        Reaction reactionId = reaction;
        return reactionId;
    }

    public Reaction updateReactionById(String id, Reaction updatedReaction) {
        Reaction updated = reaction;
        return updated;
    }

    public Reaction deleteByIdRepository(String id) {
        Reaction deleteReaction = reaction;
        return deleteReaction;
    }

    public Reaction createReaction(Reaction newReaction) {
        Reaction createReaction = reaction;
        return createReaction;
    }
}
