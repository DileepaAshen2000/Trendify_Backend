package com.trendify.trendifyBackend.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationResponse {


    public static RegistrationResponse builder() {
    }

    public RegistrationResponse code(int i) {
    }

    public RegistrationResponse message(String emailAlredyExist) {
    }

    public RegistrationResponse build() {
    }

    public int getCode() {
    }
}
