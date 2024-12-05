package com.trendify.trendifyBackend.service.implementation;

import com.trendify.trendifyBackend.auth.entities.User;
import com.trendify.trendifyBackend.dto.AddressRequest;
import com.trendify.trendifyBackend.model.Address;
import com.trendify.trendifyBackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class AddressService {


    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressRequest addressRequest, Principal principal){
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        //TODO ; add this to UserDetailDTo -> private List<Address> addressList and also in the userDetails controller -- Done 06/12--01.25
        Address address = Address.builder()
                .name(addressRequest.getName())
                .street(addressRequest.getStreet())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .zipcode(addressRequest.getZipcode())
                .phoneNumber(addressRequest.getPhoneNumber())
                .user(user)
                .build();

        return addressRepository.save(address);
    }

}
