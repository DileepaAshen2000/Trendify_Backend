package com.trendify.trendifyBackend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    private String status;
    private String trackingDetails;

    // Additional fields like customer info, payment details, etc.
    private String customerName;
    private double totalAmount;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingDetails() {
        return trackingDetails;
    }

    public void setTrackingDetails(String trackingDetails) {
        this.trackingDetails = trackingDetails;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
