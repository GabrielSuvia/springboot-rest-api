package com.socialPeople.webredsocial.frienship.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialPeople.webredsocial.frienship.dto.FriendShip;
import com.socialPeople.webredsocial.frienship.repository.RepositoryFriendShip;

@Service
public class ServiceFriendShip {
    private RepositoryFriendShip repositoryFriendShip;

    public List<FriendShip> getAllFriendships() {
        List<FriendShip> listFriendShips = repositoryFriendShip.repositoryAllFriend();
        return listFriendShips;
    }

    public FriendShip getIdFriendships(String id) {// pible problem for the order
        FriendShip friendShip = repositoryFriendShip.repositoryIdFriend(id);
        return friendShip;
    }

    public FriendShip serviceCreate(FriendShip friend) {
        FriendShip newFriendShip = repositoryFriendShip.repositoryCreate(friend);
        return newFriendShip;
    }

    public FriendShip serviceFriendEdit(String id, FriendShip updatedFriendship) {
        FriendShip friendState = repositoryFriendShip.updateStateRepo(id, updatedFriendship);
        return friendState;
    }

    public FriendShip createFriendships(String id) {
        FriendShip deleteFriendShip = repositoryFriendShip.deleteFriendShip(id);
        return deleteFriendShip;
    }
}
