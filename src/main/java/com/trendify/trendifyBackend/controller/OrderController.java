package com.trendify.trendifyBackend.controller;

import com.trendify.trendifyBackend.model.Order;
import com.trendify.trendifyBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint to get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Endpoint to get an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Endpoint to update the status of an order
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable UUID id, @RequestParam String status) {
        Order order = orderService.updateOrderStatus(id, status);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Endpoint to add or update tracking details for an order
    @PutMapping("/{id}/track")
    public ResponseEntity<Order> updateTrackingDetails(@PathVariable UUID id, @RequestParam String trackingDetails) {
        Order order = orderService.updateTrackingDetails(id, trackingDetails);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Endpoint to get tracking details for an order
    @GetMapping("/{id}/track")
    public ResponseEntity<String> trackOrder(@PathVariable UUID id) {
        String trackingDetails = orderService.trackOrder(id);
        return new ResponseEntity<>(trackingDetails, HttpStatus.OK);
    }
}
