package com.playmania.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "transaction_time")
    private Time transactionTime;

    @Column(name = "transaction_status")
    private Boolean transactionStatus;

    // Getters and setters

    public Transaction() {
    }

    public Transaction(Long transactionId, Venue venue, User user, Date transactionDate, Time transactionTime, Boolean transactionStatus) {
        this.transactionId = transactionId;
        this.venue = venue;
        this.user = user;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.transactionStatus = transactionStatus;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Time getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Time transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", venue=" + venue +
                ", user=" + user +
                ", transactionDate=" + transactionDate +
                ", transactionTime=" + transactionTime +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}

