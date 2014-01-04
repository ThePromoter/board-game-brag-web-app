package com.boardgamebrag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boardgamebrag.model.User;
import com.boardgamebrag.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;
    
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> getUsers(@RequestParam(value="emailAddress", required = false) String emailAddress) throws Exception {
        User user = new User();
        user.setEmailAddress(emailAddress);
        
        return userService.getUsersLike(user);
    }
    
    @RequestMapping(value="/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }
    
    @RequestMapping(value="", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @RequestMapping(value="/{userId}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable long userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.updateUser(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}