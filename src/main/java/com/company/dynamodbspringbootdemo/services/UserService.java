package com.company.dynamodbspringbootdemo.services;

import com.company.dynamodbspringbootdemo.entities.User;

import java.util.List;

public interface UserService {

    public List<User> findById(String theId);
    public List<User> findAll();
    public void save(User theUser);
    public void deleteUserById(String theId);

}
