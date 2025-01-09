package com.socialPeople.webredsocial;

import java.time.LocalDate;

public class User{
    private String name;
    private String email;
    private String phone;
    private String password;
    private String country;
    private LocalDate birthday;

    public User() {}

    public User(String name, String email, String phone, String password, String country, LocalDate birthday){
    this.name= name;
    this.email= email;
    this.phone= phone;
    this.password= password;
    this.country= country;
    this.birthday= birthday;
    }
//getter and setter

public String getName(){
    return this.name;
}
public String getEmail(){
    return this.email;
}
public String getPhone(){
    return this.phone;
}

public String getPassword(){
    return this.password;
}

public String getCountry(){
    return this.country;
}

public LocalDate getBirthday(){
    return this.birthday;
}
}

