package com.example.DiningReview.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Column(name = "NAME")
    private String name;
    @Getter
    @Column(name = "PEANUT_SCORE")
    private Integer peanut;
    @Getter
    @Column(name = "EGG_SCORE")
    private Integer egg;
    @Getter
    @Column(name = "DAIRY_SCORE")
    private Integer dairy;
    @Getter
    @Column(name = "ZIPCODE")
    private Integer zipcode;

    public Restaurant(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.peanut = restaurant.getPeanut();
        this.egg = restaurant.getEgg();
        this.dairy = restaurant.getDairy();
        this.zipcode = restaurant.getZipcode();
    }
    public Restaurant(String name, Integer peanut, Integer egg, Integer dairy){
        this.name = name;
        this.peanut = peanut;
        this.egg = egg;
        this.dairy = dairy;
    }

    public Restaurant(){}

    public void setName(String name){
        this.name = name;
    }

    public void setPeanut(Integer peanut){
        this.peanut = peanut;
    }

    public void setEgg(Integer egg){
        this.egg = egg;
    }

    public void setDairy(Integer dairy){
        this.dairy = dairy;
    }

    public void setZipcode(Integer zipcode){
        this.zipcode = zipcode;
    }
}