package com.playmania.service;

import com.playmania.dao.OwnerDAO;
import com.playmania.dao.VenueDAO;
import com.playmania.dao.VenueDAOImpl;
import com.playmania.entity.Owner;
import com.playmania.entity.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Service
public class VenueServiceImpl implements VenueService{
    private VenueDAO venueDAO;
    private StorageService storageService;
    private UUIDGenService uuidGenService;
    private OwnerDAO ownerDAO;
    @Autowired
    public VenueServiceImpl(VenueDAO venueDAO,StorageService storageService,UUIDGenService uuidGenService,OwnerDAO ownerDAO){
        this.venueDAO=venueDAO;
        this.storageService=storageService;
        this.uuidGenService=uuidGenService;
        this.ownerDAO=ownerDAO;
    }

    @Override
    public Long save(Venue theVenue, MultipartFile[] images,Long ownerId) {
        List<String> urls=new ArrayList<>();
        if (images!=null && images.length>0){
            for (MultipartFile image: images){
                String url=storageService.uploadFile(image,"Venues");
                urls.add(url);
            }
        }

        theVenue.setImageUrl(urls);
        Long id=uuidGenService.generateUniqueId();
        theVenue.setVenueId(id);

        Owner owner= ownerDAO.getOwnerById(ownerId);
        theVenue.setOwner(owner);
        venueDAO.save(theVenue);
        return id;
    }

    @Override
    public List<Venue> getAllVenues() {
       List<Venue> venues= venueDAO.getAllVenues();
        return  venues;
    }
}
