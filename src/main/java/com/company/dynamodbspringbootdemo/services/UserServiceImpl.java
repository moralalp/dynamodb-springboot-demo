package com.company.dynamodbspringbootdemo.services;

import com.company.dynamodbspringbootdemo.entities.User;
import com.company.dynamodbspringbootdemo.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findById(String theId) {
        return userDAO.findById(theId);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(User theUser) {
        userDAO.save(theUser);
    }

    @Override
    public void deleteUserById(String theId) {
        List<User> users = userDAO.findById(theId);
        for (User myUser : users) {
            userDAO.deleteUser(myUser);
        }
    }
}
