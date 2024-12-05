package com.trendify.trendifyBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.protocol.x.XProtocolDecoder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "order_items" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnore
    private Product product;

    private UUID productVariantId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_varient_id",nullable = false)
    @JsonIgnore
    private ProductVariant productVariant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @Column(nullable = false)
    private Integer quantity;

    private Double ItemPrice;

}