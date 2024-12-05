package com.trendify.trendifyBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "addresses" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {


    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipcode;

    // Import User class to here
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;

}
