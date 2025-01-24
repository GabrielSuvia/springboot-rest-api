package com.socialPeople.webredsocial.frienship.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.socialPeople.webredsocial.frienship.dto.FriendShip;

@Repository
public class RepositoryFriendShip {

    private FriendShip friend = new FriendShip("friend", null, null);

    public List<FriendShip> repositoryAllFriend() {
        List<FriendShip> list = new ArrayList<>();
        list.add(new FriendShip("friend", null, null));
        list.add(new FriendShip("friend", null, null));
        return list;
    }

    public FriendShip repositoryIdFriend(String id) {
        FriendShip searchFriend = friend;
        return searchFriend;
    }

    public FriendShip repositoryCreate(FriendShip friend) {
        FriendShip createFriend = friend;
        return createFriend;
    }

    public FriendShip updateStateRepo(String id, FriendShip updatedFriendship) {
        FriendShip friendShipUpdate = friend;
        return friendShipUpdate;
    }

    public FriendShip deleteFriendShip(String id) {
        FriendShip friendShip = repositoryIdFriend(id);
        return friendShip;
    }
}
