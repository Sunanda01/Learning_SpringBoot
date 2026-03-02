package com.spring_boot_security_demo.controller;

import com.spring_boot_security_demo.entity.UserEntity;
import com.spring_boot_security_demo.service.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final AppUserDetailsService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.createUser(user);
        return ResponseEntity.ok("User registered Successfully\n"+user);
    }
    @GetMapping("/user")
    public String userEndpoint(){
        return "WELCOME USER\nThis is user-endpoint";
    }
    @GetMapping("/admin")
    public String adminEndpoint(){
        return "WELCOME ADMIN\nThis is admin-endpoint";
    }
    @GetMapping()
    public String publicEndpoint(){
        return "WELCOME\nThis is public-endpoint";
    }
}
