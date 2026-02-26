package com.example.controller;

import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping("/")
    private String getUser(){
        service.getUser();
        return "Check Console";
    }
}
