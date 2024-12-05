package com.trendify.trendifyBackend.service;

import com.trendify.trendifyBackend.model.Order;
import com.trendify.trendifyBackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updateOrderStatus(UUID id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order updateTrackingDetails(UUID id, String trackingDetails) {
        Order order = getOrderById(id);
        order.setTrackingDetails(trackingDetails);
        return orderRepository.save(order);
    }

    public String trackOrder(UUID id) {
        Order order = getOrderById(id);
        return order.getTrackingDetails();
    }
}
