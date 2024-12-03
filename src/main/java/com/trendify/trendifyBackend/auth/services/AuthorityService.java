package com.trendify.trendifyBackend.auth.services;

import com.trendify.trendifyBackend.auth.entities.Authority;
import com.trendify.trendifyBackend.auth.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> getUserAuthority(){
        List<Authority> authorities=new ArrayList<>();
        Authority authority= authorityRepository.findByRoleCode("USER");
        authority.add(authority);
        return authorities;

    }

    public Authority createAuthority(String role, String description){
        Authority authority= Authority.builder().roleCode(role).roleDecription(description).build();
        return authorityRepository.save(authority);
    }
}
