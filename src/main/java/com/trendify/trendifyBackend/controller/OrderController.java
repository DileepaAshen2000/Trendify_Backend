package com.trendify.trendifyBackend.controller;

import com.trendify.trendifyBackend.auth.dto.OrderResponse;
import com.trendify.trendifyBackend.dto.OrderRequest;
import com.trendify.trendifyBackend.model.Order;
import com.trendify.trendifyBackend.model.Payment;
import com.trendify.trendifyBackend.service.implementation.OrderService;
import com.trendify.trendifyBackend.service.implementation.PaymentIntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    PaymentIntentService paymentIntentService;

//    @PostMapping
//    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest, Principal principal) throws Exception{
//        Order order = orderService.createOrder(orderRequest,principal);
////        return new ResponseEntity<>(order, HttpStatus.CREATED);
//        OrderResponse orderResponse = OrderResponse.builder()
//                .orderId(order.getId())
//                .paymentMethod(order.getPaymentMethod())
//                .build();
//
//        if(Objects.equals(orderRequest.getPaymentMethods(),"CARD")){
//
//            orderResponse.getCredentials(paymentIntentService.createPaymentIntent(order));
//
//        }
//
//        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
//
//    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest, Principal principal) throws Exception{
        OrderResponse orderResponse = orderService.createOrder(orderRequest,principal);

        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }
}
