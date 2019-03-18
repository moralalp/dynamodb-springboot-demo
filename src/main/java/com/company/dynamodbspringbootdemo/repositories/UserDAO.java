package com.company.dynamodbspringbootdemo.repositories;

import com.company.dynamodbspringbootdemo.entities.User;

import java.util.List;

public interface UserDAO {

    public List<User> findById(String theId);
    public List<User> findAll();
    public void save(User theUser);
    public void deleteUser(User theUser);

}
