package com.playmania.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "VENUES")
public class Venue {
    @Id
    @Column(name = "venue_id")
    private Long venueId;

    @Column(name = "venue_name")
    private String venueName;

    @Column(name = "venue_location")
    private String venueLocation;

    @Column(name = "availability",columnDefinition = "json")
    private String availability;

    @Column(name = "start_time",columnDefinition = "json")
    private Time startTime;

    @Column(name = "end_time",columnDefinition = "json")
    private Time endTime;

    @Column(name = "facilities",columnDefinition = "json")
    private String facilities;

    @Column(name = "address",columnDefinition = "json")
    private String address;

    @Column(name = "location",columnDefinition = "json")
    private String location;

    @Column(name = "image_url",columnDefinition = "json")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // Getters and setters

    public Venue(Long venueId, String venueName, String venueLocation, String availability, Time startTime, Time endTime, String facilities, String address, String location, String imageUrl, Owner owner) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueLocation = venueLocation;
        this.availability = availability;
        this.startTime = startTime;
        this.endTime = endTime;
        this.facilities = facilities;
        this.address = address;
        this.location = location;
        this.imageUrl = imageUrl;
        this.owner = owner;
    }

    public Venue() {
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getImageUrl() {
        Gson gson = new Gson();
        return gson.fromJson(this.imageUrl, List.class);
    }

    public void setImageUrl(List<String> urls) {
        Gson gson = new Gson();
        this.imageUrl = gson.toJson(urls);

    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", venueName='" + venueName + '\'' +
                ", venueLocation='" + venueLocation + '\'' +
                ", availability='" + availability + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", facilities='" + facilities + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", owner=" + owner +
                '}';
    }
}

