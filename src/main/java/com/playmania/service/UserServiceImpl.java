package com.playmania.service;

import com.playmania.dao.UserDAO;
import com.playmania.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    @Autowired
    public UserServiceImpl (UserDAO userDAO){
        this.userDAO=userDAO;
    }
    @Override
    public void save(User theUser) {
    userDAO.save(theUser);
    }

    @Override
    public List<User> getALlUsers() {
        return userDAO.getAllUsers();
    }
}
