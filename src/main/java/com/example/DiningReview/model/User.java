package com.example.DiningReview.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
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
    private Boolean intrestedInPeanut;
    @Column(name = "EGG_ALLERGY")
    private Boolean intrestedInEgg;
    @Column(name = "DAIRY_ALLERGY")
    private Boolean intrestedInDairy;

    public User(User user){
        this.username = user.getUsername();
        this.city = user.getCity();
        this.state = user.getState();
        this.zipcode = user.getZipcode();
        this.intrestedInPeanut = user.getIntrestedInPeanut();
        this.intrestedInEgg = user.getIntrestedInEgg();
        this.intrestedInDairy = user.getIntrestedInDairy();
    }

    public User(String username) {
        this.username = username;
    }

    public User() {

    }


    public String getUsername(){return username; }

    public void setUsername(String username){this.username = username; }

    public String getCity(){return city; }

    public void setCity(String city){this.city = city; }

    public String getState(){return state; }

    public void setState(String state){this.state = state; }

    public Integer getZipcode(){return zipcode; }

    public void setZipcode(Integer zipcode){this.zipcode = zipcode; }

    public Boolean getIntrestedInPeanut(){return intrestedInPeanut; }

    public void setIntrestedInPeanut(Boolean intrestedInPeanut){this.intrestedInPeanut = intrestedInPeanut; }

    public Boolean getIntrestedInEgg() {return intrestedInEgg; }

    public void setIntrestedInEgg(Boolean intrestedInEgg){this.intrestedInEgg = intrestedInEgg; }

    public Boolean getIntrestedInDairy() {return intrestedInDairy; }

    public void setIntrestedInDairy(Boolean intrestedInDairy) {this.intrestedInDairy = intrestedInDairy; }
}