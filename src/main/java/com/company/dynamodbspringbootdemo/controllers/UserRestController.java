package com.company.dynamodbspringbootdemo.controllers;

import com.company.dynamodbspringbootdemo.entities.User;
import com.company.dynamodbspringbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public List<User>  getUser(@PathVariable String userId) {

        List<User> theUser = userService.findById(userId);

        return theUser;
    }

    /* send post to http://localhost:8080/users/
    {
	    "firstName" : "Mehmetcan"
    }
     */
    @PostMapping("/users")
    public User updateEmployee(@RequestBody User theUser) {

        userService.save(theUser);

        return theUser;
    }

//    @RequestMapping(value = "/newuser")
//    public User addUser() {
//        User user = new User();
//        user.setFirstName("Mingch");
//        userService.save(user);
//        return user;
//    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId) {

        userService.deleteUserById(userId);

        return "Deleted user";
    }

}
