package com.example.DiningReview.repository;

import com.example.DiningReview.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {

    List<Restaurant> findRestaurantPeanutByZipcode(Integer zipcode);

    List<Restaurant> findRestaurantEggByZipcode(Integer zipcode);

    List<Restaurant> findRestaurantDairyByZipcode(Integer zipcode);

    Optional<Restaurant> findById(Long restaurantId);

    Optional<Restaurant> findByNameAndZipcode(String name, Integer zipcode);
}