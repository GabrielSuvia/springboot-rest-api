package com.socialPeople.webredsocial.user;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.socialPeople.webredsocial.user.User;
import java.text.ParseException;

import org.springframework.stereotype.Repository;


@Repository
public class UserRepository{
      private User user;

    public User getUser()throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = sdf.parse("19/07/1994");

          User user = new User("jose","joseVillalva@hotmail.com","745856","123","Bolivia",birthday);

        return user;
    }
}

/*
import org.springframework.data.jpa.repository.jpaRepository;
import org.springframework.stereotype.repository;

@repository
public interface UserRepository extends jpaRepository<>{
    
}*/