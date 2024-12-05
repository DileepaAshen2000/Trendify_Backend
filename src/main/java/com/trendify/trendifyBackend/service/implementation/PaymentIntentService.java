package com.trendify.trendifyBackend.service.implementation;

import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.trendify.trendifyBackend.auth.entities.User;
import com.trendify.trendifyBackend.model.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentIntentService {

    public Map<?,?> createPaymentIntent(Order order){
        User user = order.getUser();
        PaymentIntentCreateParams paymentIntentCreateParams = PaymentIntentCreateParams.builder()
                .setCustomer(user.getId().toString())
                .setAmount(10)
                .setCurrency("inr")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                )
                .build();
        PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentCreateParams);
        Map<String,String> map = new HashMap<>();
        map.put("client_secret",paymentIntent.getClientSecret());
        return map;
    }
}
