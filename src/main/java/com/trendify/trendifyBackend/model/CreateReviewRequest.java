package com.trendify.trendifyBackend.model;

import lombok.Data;

import java.util.List;
@Data
public class CreateReviewRequest {
    private String reviewText;
    private double productRating;
    private List<String> productImages;

}
