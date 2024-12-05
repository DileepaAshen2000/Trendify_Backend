package com.trendify.trendifyBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderRequest {
    private UUID userId;
    private Date orderDate;
    private List<OrderItemRequest> OrderItemRequests;
    private Double totalAmount;
    private Double discount;
    private String paymentMethods;
    private Date expectedDeliveryDate;

}
