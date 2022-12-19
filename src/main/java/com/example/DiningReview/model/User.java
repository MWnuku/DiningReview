package com.example.DiningReview.model;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIPCODE")
    private Integer zipcode;
    @Column(name = "PEANUT_ALLERGY")
    private Boolean interestedInPeanut;
    @Column(name = "EGG_ALLERGY")
    private Boolean interestedInEgg;
    @Column(name = "DAIRY_ALLERGY")
    private Boolean interestedInDairy;

    public User(User user) {
        this.username = user.getUsername();
        this.city = user.getCity();
        this.state = user.getState();
        this.zipcode = user.getZipcode();
        this.interestedInPeanut = user.getInterestedInPeanut();
        this.interestedInEgg = user.getInterestedInEgg();
        this.interestedInDairy = user.getInterestedInDairy();
    }

    public User(String username) {
        this.username = username;
    }

    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Boolean getInterestedInPeanut() {
        return interestedInPeanut;
    }

    public void setInterestedInPeanut(Boolean interestedInPeanut) {
        this.interestedInPeanut = interestedInPeanut;
    }

    public Boolean getInterestedInEgg() {
        return interestedInEgg;
    }

    public void setInterestedInEgg(Boolean interestedInEgg) {
        this.interestedInEgg = interestedInEgg;
    }

    public Boolean getInterestedInDairy() {
        return interestedInDairy;
    }

    public void setInterestedInDairy(Boolean interestedInDairy) {
        this.interestedInDairy = interestedInDairy;
    }
}