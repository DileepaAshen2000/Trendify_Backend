package com.trendify.trendifyBackend.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDetailDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Object authorityList;


    public static UserDetailDto builder() {
    }
}
