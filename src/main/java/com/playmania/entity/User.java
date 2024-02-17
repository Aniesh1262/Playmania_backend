package com.playmania.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "age")
    private Integer age;

    @Column(name = "contact")
    private String contact;

    @Column(name = "Hobbies",columnDefinition = "json")
    private String hobbies;

    @Column(name = "dob")
    private Date dob;

    // Getters and setters

    public User() {
    }

    public User(Long userId, String firstName, String lastName, String emailId, String passwordHash, Integer age, String contact, String hobbies, Date dob) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passwordHash = passwordHash;
        this.age = age;
        this.contact = contact;
        this.hobbies = hobbies;
        this.dob = dob;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", dob=" + dob +
                '}';
    }
}
