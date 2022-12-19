package com.example.DiningReview.controller;

import com.example.DiningReview.model.User;
import com.example.DiningReview.repository.ReviewRepository;
import com.example.DiningReview.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    public UserController(UserRepository userRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already user with this username.");
        }
        return userRepository.save(user);
    }

    @PostMapping("/edit/{id}")
    public User editUser(@PathVariable("id") Long id, @RequestBody User userEdited) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This user doesnt exist"));

        user.setCity(userEdited.getCity());
        user.setState(userEdited.getState());
        user.setZipcode(userEdited.getZipcode());
        user.setInterestedInDairy(userEdited.getInterestedInDairy());
        user.setInterestedInEgg(userEdited.getInterestedInEgg());
        user.setInterestedInPeanut(userEdited.getInterestedInPeanut());

        return userRepository.save(user);
    }

    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable("username") String username) {
        if (userRepository.findByUsername(username).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with such username");
        }
        return userRepository.findByUsername(username);
    }

    @GetMapping("/validate/{username}")
    public Optional<User> validateUser(@PathVariable("username") String username) {
        if (reviewRepository.findByUsername(username).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with such username");
        }
        return userRepository.findByUsername(username);
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        userRepository.save(new User("John"));
        return userRepository.findAll();
    }
}
