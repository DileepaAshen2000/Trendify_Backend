package com.trendify.trendifyBackend.controller;

import com.trendify.trendifyBackend.dto.OrderRequest;
import com.trendify.trendifyBackend.model.Order;
import com.trendify.trendifyBackend.service.implementation.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest, Principal principal) throws Exception{
        Order order = orderService.createOrder(orderRequest,principal);
        return new ResponseEntity<>(order, HttpStatus.CREATED);

    }
}
