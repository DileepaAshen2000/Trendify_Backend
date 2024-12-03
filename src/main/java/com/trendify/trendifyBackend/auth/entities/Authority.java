package com.trendify.trendifyBackend.auth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Table(name = "AUTH_AUTHORITY")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String roleCode;

    @Column(nullable = false)
    private String roleDescription;

    public static Authority builder() {
    }

    @Override
    public String getAuthority() {
        return roleCode;
    }

    public void add(Authority authority) {
    }

    public Object roleCode(String role) {
    }
}
