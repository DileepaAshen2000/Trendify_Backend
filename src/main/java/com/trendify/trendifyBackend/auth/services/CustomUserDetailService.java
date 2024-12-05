package com.trendify.trendifyBackend.auth.services;


import com.trendify.trendifyBackend.auth.entities.User;
import com.trendify.trendifyBackend.auth.repositories.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userDetailRepository.findByEmail(username);
        if(null == user){
            throw new UsernameNotFoundException("User Not Found with userName "+username);
        }
        return user;
    }
}