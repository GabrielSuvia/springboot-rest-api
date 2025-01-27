package com.socialPeople.webredsocial.publication.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.publication.dto.Publication;
import com.socialPeople.webredsocial.publication.repository.PublicationRepository;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public List<Publication> getAllService() {
        List<Publication> publication = publicationRepository.getAllRepository();

        return publication;
    }

    public Publication getIdService(String id) {
        Publication publication = publicationRepository.getIdRepository(id);
        return publication;
    }

    public Publication createService(Publication publication) {
        Publication newPublication = publicationRepository.createRepository(publication);

        return newPublication;
    }

    public Publication updatePublication(String id, Publication publication) {
        Publication publicationUpdate = publicationRepository.updateRepository(id, publication);
        return publicationUpdate;
    }

    public Publication deleteService(String id) {
        Publication publicationUpdate = publicationRepository.deleteRepository(id);
        return publicationUpdate;
    }

}
