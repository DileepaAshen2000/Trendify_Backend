package com.trendify.trendifyBackend.service.implementation;

import com.trendify.trendifyBackend.dto.OrderRequest;
import com.trendify.trendifyBackend.model.*;
import com.trendify.trendifyBackend.repository.OrderRepository;
import com.trendify.trendifyBackend.service.ProductService;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    //TODO : import userDetailsService here
//    @Autowired
//    private userDetailsService userDetailsService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Transactional
    public Order createOrder(OrderRequest orderRequest, Principal principal) throws Exception{
        //TODO : import UserDetailsServices
//        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
//        Address address = user.getAddressList().stream().filter(address1 -> orderRequest.getAddressId().equals(address1.getId())).findFirst().orElseThrow(BadRequestException::new);

        Order order = Order.builder()
//                .user(user)
//                .address(address)
                .totalAmount(orderRequest.getTotalAmount())
                .orderDate(orderRequest.getOrderDate())
                .discount(orderRequest.getDiscount())
                .expectedDeliveryDate(orderRequest.getExpectedDeliveryDate())
                .paymentMethod(orderRequest.getPaymentMethods())
                .orderStatus(OrderStatus.PENDING)
                .build();


        List<OrderItem> orderItems = orderRequest.getOrderItemRequests().stream().map(orderItemRequest ->{
            try {
                Product product = productService.fetchProductById(orderItemRequest.getProductId());
                ProductVariant productVariant = product.getProductVariants().stream().filter(productVariant1 -> productVariant1.getId() == orderItemRequest.getProductVariantId()).findFirst().orElseThrow(BadRequestException::new);
                OrderItem orderItem = OrderItem.builder()
                        .product(product)
                        .productVariantId(orderItemRequest.getProductVariantId())
                        .quantity(orderItemRequest.getQuantity())
                        .order(order)
                        .build();
                return orderItem;


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();

        order.setOrderItemList(orderItems);
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(new Date());
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentMethod(order.getPaymentMethod());
        order.setPayment(payment);
        return orderRepository.save(order);



    }
}
