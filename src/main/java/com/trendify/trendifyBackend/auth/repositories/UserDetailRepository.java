package com.trendify.trendifyBackend.auth.repositories;


import com.trendify.trendifyBackend.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<User,Long> {
    User findByEmail(String username);
}