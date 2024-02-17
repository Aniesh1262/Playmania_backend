package com.playmania.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OWNERS")
public class Owner {
    @Id
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "age")
    private Integer age;

    @Column(name = "contact")
    private String contact;

    // Getters and setters

    public Owner() {
    }

    public Owner(Long ownerId, String firstName, String lastName, String emailId, String passwordHash, Integer age, String contact) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passwordHash = passwordHash;
        this.age = age;
        this.contact = contact;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                '}';
    }
}
