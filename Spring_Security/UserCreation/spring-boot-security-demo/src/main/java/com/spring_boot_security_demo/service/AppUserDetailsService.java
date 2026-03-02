package com.spring_boot_security_demo.service;

import com.spring_boot_security_demo.entity.UserEntity;
import com.spring_boot_security_demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found With Name => "+username));
    }
    public UserEntity createUser(UserEntity user){
        return repo.save(user);
    }
}
