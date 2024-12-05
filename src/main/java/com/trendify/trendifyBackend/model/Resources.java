package com.trendify.trendifyBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "product_resources")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resources {

    @Id
    @GeneratedValue
    private long id;


    private String name;


    private String url;


    private Boolean isPrimary;


    private String type;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnore
    private Product product;
}