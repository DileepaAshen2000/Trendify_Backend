package com.trendify.trendifyBackend.auth.repositories;

import com.trendify.trendifyBackend.auth.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.UUID;

@Repository
//public class AuthorityRepository extends JpaRepository<Authority, UUID> {
//    public Authority findByRoleCode(String user) {
//    }

public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
    Authority findByRoleCode(String roleCode); // Ensure method has a proper return value
}

