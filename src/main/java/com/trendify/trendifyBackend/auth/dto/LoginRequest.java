package com.trendify.trendifyBackend.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginRequest {
    private String userName;
    private CharSequence password;

    public Object getPassword() {
    }

    public Object getUserName() {
    }
}