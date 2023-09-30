package com.example.DiningReview.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Column(name = "USERNAME")
    private String username;
    @Getter
    @Column(name = "CITY")
    private String city;
    @Getter
    @Column(name = "STATE")
    private String state;
    @Getter
    @Column(name = "ZIPCODE")
    private Integer zipcode;
    @Getter
    @Column(name = "PEANUT_ALLERGY")
    private Boolean interestedInPeanut;
    @Getter
    @Column(name = "EGG_ALLERGY")
    private Boolean interestedInEgg;
    @Getter
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

    public User(String username){
        this.username = username;
    }

    public User() {}

    public void setUsername(String username){
        this.username = username;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZipcode(Integer zipcode){
        this.zipcode = zipcode;
    }

    public void setInterestedInPeanut(Boolean interestedInPeanut){
        this.interestedInPeanut = interestedInPeanut;
    }

    public void setInterestedInEgg(Boolean interestedInEgg){
        this.interestedInEgg = interestedInEgg;
    }

    public void setInterestedInDairy(Boolean interestedInDairy){
        this.interestedInDairy = interestedInDairy;
    }
}