package com.playmania.contollers;

import com.google.gson.Gson;
import com.playmania.entity.Venue;
import com.playmania.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    private VenueService venueService;
    @Autowired
    public VenueController (VenueService venueService){
        this.venueService=venueService;
    }
    @GetMapping()
    public List<Venue> getAllVenues(){
        List<Venue> venues=venueService.getAllVenues();
        return venues;
    }
    @PostMapping("/addVenue")
    public Long save(@RequestParam("imageUrl") MultipartFile[] images,
                     @RequestParam("venue") String venueJson,
                     @RequestParam("owner") Long ownerId){

        Venue venue = new Gson().fromJson(venueJson, Venue.class);

        Long id=venueService.save(venue,images,ownerId);
        return id;
    }
}
