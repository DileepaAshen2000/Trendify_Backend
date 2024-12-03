package com.trendify.trendifyBackend.auth.controller;

import com.trendify.trendifyBackend.auth.dto.UserDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserDetailController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Principal principal){
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());

        if(null == user){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);


        }

        UserDetailDto userDetailDto = UserDetailDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .id(user.getId())
                .phoneNumber(user.getPhoneNumber())
                .authorityList(user.getAuthorities().toArray()).build();

        return new ResponseEntity<>(userDetailDto, HttpStatus.OK);



    }

}
