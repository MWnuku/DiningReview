package com.example.DiningReview.controller;

import com.example.DiningReview.model.Restaurant;
import com.example.DiningReview.repository.RestaurantRepository;
import com.example.DiningReview.repository.ReviewRepository;
import com.example.DiningReview.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        if(restaurantRepository.findByNameAndZipcode(restaurant.getName(), restaurant.getZipcode()).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is already restaurant with this name and zipcode");
        }
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@RequestParam("id") Long id){
        if(restaurantRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no restaurant with this Id");
        }
        return restaurantRepository.findById(id);
    }

    @GetMapping("/{zipcode}/{allergy}")
    public List<Restaurant> getRestaurantByZipcodeAndAllergy(@RequestParam("zipcode") Integer zipcode, @RequestParam("allergy") String allergy){
        switch (allergy) {
            case "peanut":
                if (restaurantRepository.findRestaurantPeanutByZipcode(zipcode).isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such restaurant.");
                }
                return restaurantRepository.findRestaurantPeanutByZipcode(zipcode);
            case "dairy":
                if (restaurantRepository.findRestaurantDairyByZipcode(zipcode).isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such restaurant.");
                }
                return restaurantRepository.findRestaurantDairyByZipcode(zipcode);
            case "egg":
                if (restaurantRepository.findRestaurantEggByZipcode(zipcode).isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no such restaurant.");
                }
                return restaurantRepository.findRestaurantEggByZipcode(zipcode);
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You've provided wrong allergy value");
        }
    }

}