package com.socialPeople.webredsocial.user;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Repository;


@Repository
public class UserRepository{
      private User user;

    public ArrayList<User> getUser()throws ParseException {
        ArrayList<User> userList = new ArrayList<>();
        SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = dat.parse("19/07/1994");
           
           user = new User("jose","joseVillalva@hotmail.com","745856","123","Bolivia",birthday);
           userList.add(user);
        return userList;
    }
}

/*
import org.springframework.data.jpa.repository.jpaRepository;
import org.springframework.stereotype.repository;

@repository
public interface UserRepository extends jpaRepository<>{
    
}*/