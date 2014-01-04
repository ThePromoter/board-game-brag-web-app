package com.boardgamebrag.dao;

import java.util.List;

import com.boardgamebrag.model.User;

public interface UserDAO {
    public User saveUser(User user);
    public void deleteUser(User user);
    public User findById(long id);
    public List<User> findByExample(User instance);
}
