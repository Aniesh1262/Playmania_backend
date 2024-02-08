package com.playmania.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "BOOKINGS")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "reserved_by")
    private User reservedBy;

    @Column(name = "reserved_date")
    private Date reservedDate;

    @Column(name = "reserved_time",columnDefinition = "json")
    private Time reservedTime;

    // Getters and setters

    public Booking() {
    }

    public Booking(Long bookingId, Venue venue, User reservedBy, Date reservedDate, Time reservedTime) {
        this.bookingId = bookingId;
        this.venue = venue;
        this.reservedBy = reservedBy;
        this.reservedDate = reservedDate;
        this.reservedTime = reservedTime;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Time getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(Time reservedTime) {
        this.reservedTime = reservedTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", venue=" + venue +
                ", reservedBy=" + reservedBy +
                ", reservedDate=" + reservedDate +
                ", reservedTime=" + reservedTime +
                '}';
    }
}

