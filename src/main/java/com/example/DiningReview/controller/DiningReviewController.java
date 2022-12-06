package com.example.DiningReview.controller;

import com.example.DiningReview.DiningReviewApplication;
import com.example.DiningReview.model.*;
import com.example.DiningReview.repository.ReviewRepository;
import com.example.DiningReview.repository.RestaurantRepository;
import com.example.DiningReview.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/review")
public class DiningReviewController {
    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final RestaurantRepository restaurantRepository;

    public DiningReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository){
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }
    @PostMapping("/add")
    public Review  createNewReview(@RequestBody Review review){
        if(restaurantRepository.findById(review.getRestaurantId()).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This restaurant doesnt exist");
        if(userRepository.findByUsername(review.getUsername()).isEmpty())
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "This username doesnt exist");
        return reviewRepository.save(review);
    }
    @GetMapping("")
    public Iterable<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @GetMapping("/pending")
    public Iterable<Review> getAllPendingReviews(){
        return reviewRepository.findByStatus(ReviewStatus.Pending);
    }
    @PutMapping("/{id}/approve")
    public Review approveReview(@PathVariable("id") Long id){
        Optional<Review> optReview = reviewRepository.findById(id);
        if(!optReview.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This review doesn't exist");
        Review reviewToApprove = optReview.get();
        reviewToApprove.setStatus(ReviewStatus.Accpeted);
        return reviewRepository.save(reviewToApprove);
    }
    @GetMapping("/{id}/approved")
    public Iterable<Review> getApprovedReviews(@PathVariable("id") Long id){
        return reviewRepository.findByStatusAndId(ReviewStatus.Accpeted, id);
    }



}