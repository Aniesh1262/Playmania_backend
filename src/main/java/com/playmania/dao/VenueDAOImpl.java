package com.playmania.dao;

import com.playmania.entity.User;
import com.playmania.entity.Venue;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VenueDAOImpl implements VenueDAO{
    private EntityManager entityManager;
    @Autowired
    public VenueDAOImpl (EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Venue theVenue) {
        entityManager.persist(theVenue);
    }

    @Override
    public List<Venue> getAllVenues() {
        List<Venue> venues= entityManager.createQuery("from Venue", Venue.class).getResultList();
        return venues;
    }
}
