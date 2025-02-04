package com.socialPeople.webredsocial.frienship.controller;

import java.util.ArrayList;
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

import com.socialPeople.webredsocial.frienship.dto.FriendShip;
import com.socialPeople.webredsocial.frienship.service.ServiceFriendShip;

@RestController
@RequestMapping("/friendShip")
public class FriendShipController {

    private ServiceFriendShip serviceFriendShip;

    public FriendShipController(ServiceFriendShip serviceFriendShip) {
        this.serviceFriendShip = serviceFriendShip;
    }

    // GET all friendships
    @GetMapping
    public ResponseEntity<ArrayList<FriendShip>> getAllFriendships() {
        // Logic to fetch all friendships
        ArrayList<FriendShip> listFriendShip = this.serviceFriendShip.getAllFriendships();
        return ResponseEntity.ok(listFriendShip); // Example response
    }

    // GET a specific friendship by ID
    @GetMapping("/{id}")
    public ResponseEntity<FriendShip> getFriendshipById(@PathVariable String id) {
        // Logic to fetch a friendship by ID
        FriendShip listFriendShip = this.serviceFriendShip.getIdFriendships(id);
        return ResponseEntity.ok(listFriendShip); // Example response
    }

    // POST to create a new friendship
    @PostMapping
    public ResponseEntity<String> createFriendship(@RequestBody FriendShip friendship) {
        // Logic to create a new friendship
        this.serviceFriendShip.serviceCreate(friendship);
        return ResponseEntity.ok("User Created successfully"); // Example response
    }

    // PUT to update a friendship by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFriendship(@PathVariable String id, @RequestBody FriendShip updatedFriendship) {
        // Logic to update a friendship
        return ResponseEntity.ok("edited succefully"); // Example response
    }

    // DELETE a friendship by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFriendship(@PathVariable String id) {
        // Logic to delete a friendship
        this.serviceFriendShip.createFriendships(id);
        return ResponseEntity.ok("Friendship with ID " + id + " deleted"); // Example response
    }

}
