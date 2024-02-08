package com.playmania.dao;

import com.playmania.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User theUser);
    List<User> getAllUsers();
}
