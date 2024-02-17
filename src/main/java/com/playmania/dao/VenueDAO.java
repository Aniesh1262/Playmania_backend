package com.playmania.dao;

import com.playmania.entity.User;
import com.playmania.entity.Venue;

import java.util.List;

public interface VenueDAO {
    void save(Venue theVenue);
    List<Venue> getAllVenues();
}
