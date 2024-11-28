package com.trendify.trendifyBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "category_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryType {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = true)
    @JsonIgnore
    private Category category;
}