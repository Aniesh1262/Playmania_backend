package com.playmania.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "review")
    private String reviews;

    @Column(name = "rating")
    private Integer rating;

    // Getters and setters

    public Review(Long reviewId, Venue venue, User user, String reviews, Integer rating) {
        this.reviewId = reviewId;
        this.venue = venue;
        this.user = user;
        this.reviews = reviews;
        this.rating = rating;
    }

    public Review() {
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
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

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", venue=" + venue +
                ", user=" + user +
                ", reviews='" + reviews + '\'' +
                ", rating=" + rating +
                '}';
    }
}
