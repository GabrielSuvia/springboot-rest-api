package com.socialPeople.webredsocial.publication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.socialPeople.webredsocial.publication.dto.Publication;

@Repository
public class PublicationRepository {
    Publication publications = new Publication(null, "hello", null, "Posteo", null);// final

    // Method to get all publications
    public List<Publication> getAllRepository() {
        List<Publication> ListPublication = new ArrayList<Publication>();
        ListPublication.add(publications);
        ListPublication.add(publications);
        return ListPublication; // Return a copy of the list to avoid external modifications
    }

    // Method to get a publication by ID
    public Publication getIdRepository(String id) {
        Publication publicationId = publications;
        return publicationId; // Return null if not found
    }

    // Method to create a new publication
    public Publication createRepository(Publication publication) {
        Publication newPublication = publications;
        return newPublication;
    }

    // Method to update a publication
    public Publication updateRepository(String id, Publication updatedPublication) {
        Publication updatePublication = publications;
        return updatePublication; // Return null if publication not found
    }

    // Method to delete a publication
    public Publication deleteRepository(String id) {
        Publication deletePublication = publications;
        return deletePublication;
    }
}
