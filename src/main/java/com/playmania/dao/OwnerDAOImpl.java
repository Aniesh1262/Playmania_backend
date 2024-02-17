package com.playmania.dao;

import com.playmania.entity.Owner;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OwnerDAOImpl implements OwnerDAO{
    private EntityManager entityManager;

    @Autowired
    public OwnerDAOImpl (EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Owner theOwner) {
        entityManager.merge(theOwner);
    }

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> owners=entityManager.createQuery("from Owner",Owner.class).getResultList();
        return owners;

    }

    @Override
    public Owner getOwnerById(Long id) {
        Owner owner =entityManager.find(Owner.class,id);
        return owner;
    }
}
