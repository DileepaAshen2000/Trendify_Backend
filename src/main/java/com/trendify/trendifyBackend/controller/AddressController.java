package com.trendify.trendifyBackend.controller;


import com.trendify.trendifyBackend.dto.AddressRequest;
import com.trendify.trendifyBackend.model.Address;
import com.trendify.trendifyBackend.service.implementation.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody AddressRequest addressRequest, Principal principal){
        Address address = addressService.createAddress(addressRequest,principal);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
