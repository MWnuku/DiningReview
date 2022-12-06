package com.example.DiningReview.model;

import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
    @Column(name = "PEANUT_SCORE")
    private Integer peanutScore;
    @Column(name = "EGG_SCORE")
    private Integer eggScore;
    @Column(name = "DAIRY_SCORE")
    private Integer dairyScore;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "REVIEW_STATUS")
    private ReviewStatus status = ReviewStatus.Unsubmitted;


    public Review(Review review){
        this.username = review.getUsername();

        this.restaurantId = review.getRestaurantId();

        this.peanutScore = review.getPeanutScore();

        this.eggScore = review.getEggScore();

        this.dairyScore = review.getDairyScore();

        this.comment = review.getComment();

        this.status = ReviewStatus.Submitted;
    }

    public Review() {

    }

    public String getUsername(){return username; }

    public void setUsername(String username){this.username = username; }

    public Long getRestaurantId(){return restaurantId; }

    public void setRestaurantId(Long restaurantId){this.restaurantId = restaurantId; }

    public Integer getPeanutScore(){return peanutScore; }

    public void setPeanutScore(Integer peanutScore){this.peanutScore = peanutScore; }

    public Integer getEggScore() {return eggScore; }

    public void setEggScore(Integer eggScore) {this.eggScore = eggScore; }

    public Integer getDairyScore(){return dairyScore; }

    public void setDairyScore(Integer dairyScore){this.dairyScore = dairyScore; }

    public String getComment(){return comment; }

    public void setComment(String comment){this.comment = comment; }

    public ReviewStatus getStatus(){return status; }

    public void setStatus(ReviewStatus status){this.status = status;}
}