package com.trendify.trendifyBackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<CategoryType> categoryTypes;

}
