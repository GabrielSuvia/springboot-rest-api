package com.socialPeople.webredsocial.user.repository;

import java.util.ArrayList;
import java.text.ParseException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Repository;

import com.socialPeople.webredsocial.user.dto.User;

@Repository
public class UserRepository {

    private User user = new User("jose", "joseVillalva@hotmail.com", "745856", "123", "Bolivia", null);

    public ArrayList<User> getUser() throws ParseException {
        ArrayList<User> userList = new ArrayList<>();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate birthday = LocalDate.parse("19/07/1994", formatter);
        userList.add(user);
        return userList;
    }

    public User getUserRepositoryId(String id) {
        // db
        // User userId = user;
        return user;
    }

    public User userUpdate(String id, User userUpdate) {
        User userUpdated = user;
        return userUpdated;
    }

}

/*
 * import org.springframework.data.jpa.repository.jpaRepository;
 * import org.springframework.stereotype.repository;
 * 
 * @repository
 * public interface UserRepository extends jpaRepository<>{
 * 
 * }
 */