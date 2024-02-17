package com.playmania.service;

import com.playmania.entity.Venue;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VenueService {
    Long save(Venue theUser, MultipartFile[] images,Long ownerId);
    List<Venue> getAllVenues();
}
