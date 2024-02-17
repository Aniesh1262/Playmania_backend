package com.playmania.service;

import com.playmania.dao.UserDAO;
import com.playmania.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    private UUIDGenService uuidGenService;
    @Autowired
    public UserServiceImpl (UserDAO userDAO ,UUIDGenService uuidGenService){

        this.userDAO=userDAO;
        this.uuidGenService=uuidGenService;
    }
    @Override
    public void save(User theUser) {
        Long id=uuidGenService.generateUniqueId();
        theUser.setUserId(id);
        System.out.println(id);
        userDAO.save(theUser);
    }

    @Override
    public List<User> getALlUsers() {
        return userDAO.getAllUsers();
    }
}
