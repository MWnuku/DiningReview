package com.example.DiningReview.model;


import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PEANUT_SCORE")
    private Integer peanut;
    @Column(name = "EGG_SCORE")
    private Integer egg;
    @Column(name = "DAIRY_SCORE")
    private Integer dairy;
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
        this.zipcode = zipcode;
    }

    public Restaurant() {

    }

    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    public Integer getPeanut() {return peanut; }

    public void setPeanut(Integer peanut) {this.peanut = peanut; }

    public Integer getEgg() {return egg; }

    public void setEgg(Integer egg) {this.egg = egg; }

    public Integer getDairy() {return dairy; }

    public void setDairy(Integer dairy) {this.dairy = dairy; }

    public Integer getZipcode(){return zipcode; }

    public void setZipcode(Integer zipcode) {this.zipcode = zipcode; }
}