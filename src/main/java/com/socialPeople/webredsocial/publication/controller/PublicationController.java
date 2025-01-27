package com.socialPeople.webredsocial.publication.controller;

import java.util.List;

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

import com.socialPeople.webredsocial.publication.dto.Publication;
import com.socialPeople.webredsocial.publication.service.PublicationService;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Publication>> getAllPublications() {
        List<Publication> publications = this.publicationService.getAllService();
        return ResponseEntity.ok(publications);
    }

    @GetMapping("/{id}")
    public Publication getPublicationById(@PathVariable String id) {
        Publication publicationId = this.publicationService.getIdService(id);
        return publicationId;
    }

    @PostMapping("/create")
    public ResponseEntity<Publication> createPublication(@RequestBody Publication publication) {
        Publication publicationCreate = this.publicationService.createService(publication);
        return ResponseEntity.status(HttpStatus.CREATED).body(publicationCreate);
    }

    @PutMapping("/{id}")
    public Publication updatePublication(@PathVariable String id, @RequestBody Publication publication) {
        Publication publicationUpdate = this.publicationService.updatePublication(id, publication);
        return publicationUpdate;
    }

    @DeleteMapping("/{id}")
    public Publication deletePublication(@PathVariable String id) {
        Publication publication = this.publicationService.deleteService(id);
        return publication;
    }

    // get all publication () //publication
    // get id publication ( String id) //:id
    // put publication (String publication) //:id
    // delete publication (String id) //:id
    // post publication () //create
}
