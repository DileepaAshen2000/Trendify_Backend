package com.trendify.trendifyBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trendify.trendifyBackend.auth.entities.User;
import jakarta.persistence.*;
import lombok.*;

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
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipcode;

    @Column(nullable = false)
    private String phoneNumber;

     //Import User class to here
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private User user;

}
