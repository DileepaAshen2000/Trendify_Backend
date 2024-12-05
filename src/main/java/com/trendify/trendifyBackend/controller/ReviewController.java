package com.trendify.trendifyBackend.controller;

import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.model.CreateReviewRequest;
import com.trendify.trendifyBackend.model.Review;
import com.trendify.trendifyBackend.service.ProductService;
import com.trendify.trendifyBackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;
    private final ProductService productService;

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable("reviewId") Long reviewId) {
        try {
            Review review = reviewService.getReviewById(reviewId);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @GetMapping("/products/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable UUID id) {
        List<Review> reviews = reviewService.getReviewByProductId(id);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/products/{id}/reviews")
    public ResponseEntity<Review> createReview(
            @PathVariable UUID id,
            @RequestBody CreateReviewRequest req) {
        ProductDto productDto = productService.getProductById(id);
        Review review = reviewService.createReview(req, productDto);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable Long reviewId,
            @RequestBody CreateReviewRequest reviewRequest) throws Exception {
        Review review = reviewService.updateReview(reviewId, reviewRequest.getReviewText(), reviewRequest.getProductRating());

        return ResponseEntity.ok(review);
    }


    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(
            @PathVariable Long reviewId
             ) throws Exception {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{id}/average-rating")
    public ResponseEntity<Double> getAverageRatingByProductId(@PathVariable UUID id) {
        try {
            Double averageRating = reviewService.getAverageRatingByProductId(id);
            return ResponseEntity.ok(averageRating);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
