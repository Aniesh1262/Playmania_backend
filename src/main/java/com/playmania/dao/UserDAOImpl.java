package com.playmania.dao;

import com.playmania.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    public EntityManager entityManager;

    @Autowired
    public UserDAOImpl (EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(User theUser) {
        System.out.println(theUser.getUserId());
        entityManager.merge(theUser);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }
}
