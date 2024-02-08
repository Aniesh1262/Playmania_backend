package com.playmania.service;

import com.playmania.entity.User;

import java.util.List;

public interface UserService {
    void save(User theUser);
    List<User> getALlUsers();
}
