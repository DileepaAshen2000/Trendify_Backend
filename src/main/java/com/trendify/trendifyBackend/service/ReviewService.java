package com.trendify.trendifyBackend.service;

import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.model.CreateReviewRequest;
import com.trendify.trendifyBackend.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public interface ReviewService {
    Review createReview(CreateReviewRequest req,

                        ProductDto product);
    List<Review> getReviewByProductId(UUID id);

    Review updateReview(Long reviewId, String reviewText, double rating) throws Exception;

    void deleteReview(Long reviewId) throws Exception;
    Review getReviewById(Long reviewId) throws Exception;
}
