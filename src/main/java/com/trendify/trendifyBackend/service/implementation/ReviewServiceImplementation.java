package com.trendify.trendifyBackend.service.implementation;

import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.model.CreateReviewRequest;
import com.trendify.trendifyBackend.model.Product;
import com.trendify.trendifyBackend.model.Review;
import com.trendify.trendifyBackend.repository.ReviewRepository;
import com.trendify.trendifyBackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImplementation implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(CreateReviewRequest req, ProductDto productDto) {
        Product product = convertToProduct(productDto); // Convert DTO to entity
        Review review = new Review();
        review.setProduct(product);
        review.setReviewText(req.getReviewText());
        review.setProductRating(req.getProductRating());
        review.setProductImages(req.getProductImages());

        return reviewRepository.save(review);
    }
    @Override
    public Double getAverageRatingByProductId(UUID productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId); // Assuming a method in the repository
        if (reviews.isEmpty()) {
            return 0.0; // No reviews, so return 0.0
        }

        double totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getProductRating(); // Assuming the Review model has getProductRating() method
        }

        return totalRating / reviews.size(); // Return the average rating
    }


    // Convert ProductDto to Product entity
    private Product convertToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        // product.setCategoryId(productDto.getCategoryId());

        return product;
    }

    @Override
    public List<Review> getReviewByProductId(UUID id) {
        return reviewRepository.findByProductId(id);
    }

    @Override
    public Review updateReview(Long reviewId, String reviewText, double productRating) throws Exception {
        Review review = getReviewById(reviewId);
        review.setReviewText(reviewText);
        review.setProductRating(productRating);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId) throws Exception {
        Review review = getReviewById(reviewId);
        reviewRepository.delete(review);
    }

    @Override
    public Review getReviewById(Long reviewId) throws Exception {
        return reviewRepository.findById(reviewId).orElseThrow(() -> new Exception("Review not found"));
    }
}
