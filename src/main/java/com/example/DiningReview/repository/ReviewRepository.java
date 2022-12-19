package com.example.DiningReview.repository;

import com.example.DiningReview.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;
import com.example.DiningReview.model.Review;

import java.util.Optional;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByStatus(ReviewStatus status);

    Optional<Review> findByUsername(String username);

    Optional<Review> findByRestaurantId(Long restaurantId);

    List<Review> findByStatusAndId(ReviewStatus status, Long restaurantId);

    List<Review> findAllByUserId(Long userId);
}