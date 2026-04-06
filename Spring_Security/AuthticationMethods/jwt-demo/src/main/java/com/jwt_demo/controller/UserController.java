package com.jwt_demo.controller;

import com.jwt_demo.component.JwtUtil;
import com.jwt_demo.entity.UserEntity;
import com.jwt_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/user-register")
    public ResponseEntity<String> register(@RequestBody UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.save(user);
        return ResponseEntity.ok("User Registered Successfully");
    }

    @GetMapping("/users")
    public String getUserDetails(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return "Fetched UserDetails Successfully";
    }
}
