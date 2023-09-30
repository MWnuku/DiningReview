package com.example.DiningReview.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Column(name = "USERNAME")
    private String username;
    @Getter
    @Column(name = "USER_ID")
    private Long userId;
    @Getter
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
    @Getter
    @Column(name = "PEANUT_SCORE")
    private Integer peanutScore;
    @Getter
    @Column(name = "EGG_SCORE")
    private Integer eggScore;
    @Getter
    @Column(name = "DAIRY_SCORE")
    private Integer dairyScore;
    @Getter
    @Column(name = "COMMENT")
    private String comment;
    @Getter
    @Column(name = "REVIEW_STATUS")
    private ReviewStatus status = ReviewStatus.Unsubmitted;

    public Review(Review review){
        this.username = review.getUsername();
        this.userId = review.getUserId();
        this.restaurantId = review.getRestaurantId();
        this.peanutScore = review.getPeanutScore();
        this.eggScore = review.getEggScore();
        this.dairyScore = review.getDairyScore();
        this.comment = review.getComment();
        this.status = ReviewStatus.Submitted;
    }

    public Review() {}

    public void setUsername(String username){
        this.username = username;
    }

    public void setRestaurantId(Long restaurantId){
        this.restaurantId = restaurantId;
    }

    public void setPeanutScore(Integer peanutScore){
        this.peanutScore = peanutScore;
    }

    public void setEggScore(Integer eggScore){
        this.eggScore = eggScore;
    }

    public void setDairyScore(Integer dairyScore){
        this.dairyScore = dairyScore; }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setStatus(ReviewStatus status){
        this.status = status;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }
}