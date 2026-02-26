package com.example.controller;

import com.example.entity.UserModel2;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id){
        service.updateUser(id);
        UserModel2 user=service.getUser();
        System.out.println("User After Updating => \nName => "+user.getName());
        return "Updating User With ID => "+id;
    }
}
