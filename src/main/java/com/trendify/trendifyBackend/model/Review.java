
package com.trendify.trendifyBackend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Category;
import lombok.Data;
import jakarta.persistence.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reviewId;

    @Column(nullable = false)
    private String reviewText;

    @Column(nullable =false)
    private double productRating;

    @ElementCollection
    private List<String> productImages;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "productId" , nullable =false)
    private Product product;

    //@ManyToOne
    //@JoinColumn(name= "user_id" , nullable =false)
    //private User user;

    @Column(nullable = false)
    private LocalDateTime createdAt=LocalDateTime.now();


}
