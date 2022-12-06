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
@RequestMapping("/user")
public class UserController{
    private final UserRepository userRepository;

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    public UserController(UserRepository userRepository, RestaurantRepository restaurantRepository, ReviewRepository reviewRepository){
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        if(!userRepository.findByUsername(user.getUsername()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is already user with this username.");
        }
        return userRepository.save(user);
    }
    @PostMapping("/edit/{id}")
    public User editUser(@PathVariable("id") Integer id, @RequestBody User userEdited){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This user doesnt exist"));

        user.setCity(userEdited.getCity());
        user.setState(userEdited.getState());
        user.setZipcode(userEdited.getZipcode());
        user.setIntrestedInDairy(userEdited.getIntrestedInDairy());
        user.setIntrestedInEgg(userEdited.getIntrestedInEgg());
        user.setIntrestedInPeanut(userEdited.getIntrestedInPeanut());

        return userRepository.save(user);
    }
    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable("username") String username){
        if(!userRepository.findByUsername(username).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is no user with such username");
        }
        return userRepository.findByUsername(username);
    }
    @GetMapping("/validate/{username}")
    public Optional<User> validateUser(@PathVariable("username") String username){
        if(reviewRepository.findByUsername(username).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with such username");
        }
        return userRepository.findByUsername(username);
    }
}
