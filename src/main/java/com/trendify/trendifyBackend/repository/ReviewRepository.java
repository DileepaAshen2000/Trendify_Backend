package com.trendify.trendifyBackend.repository;

import com.trendify.trendifyBackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByProductId(UUID id);
}
